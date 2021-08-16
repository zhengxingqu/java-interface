package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Result;
import com.example.demo.mapper.CaseMapper;
import com.example.demo.mapper.ModuleManagementMapper;
import com.example.demo.model.CaseManagement;
import com.example.demo.model.EnvironmentalManagement;
import com.example.demo.service.CaseManagementService;
import com.example.demo.service.EnvironmentalManagementService;
import com.example.demo.service.ModuleManagementService;
import com.example.demo.tool.DataFormatProcessing;
import com.example.demo.tool.RequestClient;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.*;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CaseManagementServiceImpl implements CaseManagementService {

    private static final Logger logger = LoggerFactory.getLogger(CaseManagementServiceImpl.class);
    @Autowired
    private CaseMapper caseMapper;

    @Autowired
    private ModuleManagementService moduleManagementService;

    @Autowired
    private ModuleManagementMapper moduleManagementMapper;

    @Autowired
    private EnvironmentalManagementService environmentalManagementService;

    @Override
    public Page<CaseManagement> findAllCase(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<CaseManagement>) caseMapper.selectAll();
    }

    @Override
    public CaseManagement findCaseById(int id) {
        return caseMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCase(CaseManagement caseManagement) {
        caseMapper.updateByPrimaryKeySelective(caseManagement);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertCase(CaseManagement caseManagement) throws Exception {
        if (this.findCaseName(caseManagement.getCaseName()).size() == 0) {
            Gson gson = new Gson();
            String jsonResult = gson.toJson(moduleManagementService.findModuleName(caseManagement.getModuleName()), new TypeToken<List<CaseManagement>>() {
            }.getType());
            JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
            JSONObject jsObj = JSON.parseObject(object.get(0).toString());
            caseManagement.setProjectName(jsObj.getString("projectName"));
            caseMapper.insertSelective(caseManagement);
        } else {
            throw new Exception("用例名称名称已存在");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCase(int id) {
        try {
            caseMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(String.valueOf(e));
        }
    }

    @Override
    public Page<CaseManagement> findSearchCase(Integer page, Integer size, CaseManagement caseManagement) {
        PageHelper.startPage(page, size);
        Example example = new Example(CaseManagement.class);
        Example.Criteria criteria = example.createCriteria();
        if (caseManagement != null) {
            if (!StringUtil.isEmpty(caseManagement.getCaseName())) {
                criteria.andLike("caseName", "%" + caseManagement.getCaseName() + "%");
            }
        }
        List<CaseManagement> pageProject = caseMapper.selectByExample(example);
        return (Page<CaseManagement>) pageProject;
    }

    @Override
    public List findCaseName(String caseName) {
        Example example = new Example(CaseManagement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("caseName", caseName);
        return caseMapper.selectByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void interfaceRequest(Map map, Integer id) throws Exception {

        if (this.getInterfaceFields(id).getString("quoteCase").equals("[]") || this.getInterfaceFields(id).getString("switchs").equals("false")) {
            RequestClient t = new RequestClient();
            if (map.get("envName").toString().equals("")) {
                throw new Exception("请选择环境名称");
            }
            Gson gson = new Gson();
            String jsonResult = gson.toJson(environmentalManagementService.findEnvironmentalName(String.valueOf(map.get("envName"))), new TypeToken<List<EnvironmentalManagement>>() {
            }.getType());
            JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
            JSONObject jsObj = JSON.parseObject(object.get(0).toString());
            String url = String.valueOf(jsObj.get("environmentalUrl")) + String.valueOf(map.get("url"));
            t.getResponse(url, String.valueOf(map.get("requestMethod")), String.valueOf(map.get("requestParam")), String.valueOf(map.get("header")));
            JSONObject response = t.getBodyInJSON();
            if (t.assertMethod(String.valueOf(map.get("resultAssert")), String.valueOf(map.get("assertMethod")), response.toString())) {
                String errorResponse = "";
                updateErrorResponse(id, "成功", errorResponse);
            } else {
                updateErrorResponse(id, "失败", response.toJSONString());
            }
        } else {
            this.invokingCase(map, id);
        }


    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateErrorResponse(Integer id, String result, String errorResponse) {
        caseMapper.updateErrorResponse(id, result, errorResponse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCases(Map map) throws InterruptedException {
        ArrayList ids = (ArrayList) map.get("ids");
        ExecutorService executor = RequestClient.executorService();
        ids.forEach(id -> {
            Thread t = new Thread(() -> {
                synchronized (this) {
                    caseMapper.deleteByPrimaryKey(id);
                }
            });
            executor.submit(t);

        });
        executor.shutdown();
    }

    @Override
    public Result runManyInterfaceRequest(Map map) {
        ArrayList ids = (ArrayList) map.get("ids");
        ExecutorService executor = RequestClient.executorService();
        ids.forEach(id -> {
            Thread t1 = new Thread(() -> {
                synchronized (this) {
                    if (this.getInterfaceFields(id).getString("quoteCase").equals("[]") || this.getInterfaceFields(id).getString("switchs").equals("false")) {
                        try {
                            this.notInvokingCase(map, id);
                        } catch (Exception e) {
                            updateErrorResponse(Integer.parseInt(id.toString()), "失败", e.getMessage().toString());
                        }

                    } else {
                        try {
                            this.invokingCase(map, id);
                        } catch (JSONException e) {
                            updateErrorResponse(Integer.parseInt(id.toString()), "失败", e.getMessage().toString());
                        }
                    }
                }
            });
            executor.submit(t1);
        });
        executor.shutdown();
        return null;
    }

    private JSONObject getInterfaceFields(Object id) {
        CaseManagement bodyContent = caseMapper.selectByPrimaryKey(id);
        return (JSONObject) JSONObject.toJSON(bodyContent);
    }

    private void notInvokingCase(Map map, Object id) {
        RequestClient t = new RequestClient();
        JSONObject body = getInterfaceFields(id);
        String url = getUrlFields(map, id);
        try {
            t.getResponse(url, String.valueOf(body.getString("requestMethod")), String.valueOf(body.getString("requestParam")), String.valueOf(body.getString("header")));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        JSONObject response = null;
        try {
            response = t.getBodyInJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (t.assertMethod(String.valueOf(body.getString("resultAssert")), String.valueOf(body.getString("assertMethod")), response.toString())) {
            String errorResponse = "";
            updateErrorResponse(Integer.parseInt(id.toString()), "成功", errorResponse);
        } else {
            updateErrorResponse(Integer.parseInt(id.toString()), "失败", response.toJSONString());
        }
    }


    private void invokingCase(Map map, Object id) throws JSONException {
        String caseList = this.getInterfaceFields(id).getString("quoteCase");
        List<String> list = JSONArray.parseArray(caseList, String.class);
        JSONObject body = getInterfaceFields(id);
        String url = getUrlFields(map, id);
        String bodyString = "";
        Map requestParamMap = new HashMap<>();
        Map requestMap = new HashMap<>();
        RequestClient t1 = new RequestClient();
        for (String caseName : list) {
            JSONObject caseObject = (JSONObject) JSONObject.toJSON(findCaseName(caseName).get(0));
            String regexName = caseObject.getString("regexName");
            String regex = caseObject.getString("regex");
            String url1 = caseObject.getString("url");
            JSONObject jsObj = DataFormatProcessing.arrayToJson(environmentalManagementService.findEnvironmentalName(String.valueOf(map.get("envName"))));
            String url2 = String.valueOf(jsObj.get("environmentalUrl")) + url1;
            JSONObject response = requestInterface(url2, caseObject, caseObject.get("requestParam").toString());
            if (!(t1.assertMethod(String.valueOf(body.get("resultAssert")), String.valueOf(body.get("assertMethod")), response.toString()))) {
                updateErrorResponse(Integer.parseInt(id.toString()), "失败", MessageFormat.format("{0}接口调用失败 {1}", caseObject.get("caseName").toString(), response.toString()));
                continue;
            }
            String regex1 = MessageFormat.format("\"{0}\":(.*?)[\\}|,]", regex);
            Matcher matcher = Pattern.compile(regex1).matcher(response.toJSONString());
            String ret = null;
            Integer ret1 = 0;
            while (matcher.find()) {
                ret = matcher.group(1);
                if (DataFormatProcessing.isInteger(ret)) {
                    ret1 = Integer.parseInt(ret);
                }
                break;
            }
            requestParamMap = DataFormatProcessing.stringToMap(body.get("requestParam").toString());
            for (Object key : DataFormatProcessing.stringToMap(body.get("requestParam").toString()).keySet()) {
                if (DataFormatProcessing.stringToMap(body.get("requestParam").toString()).get(key).toString().equals(regexName) && DataFormatProcessing.isInteger(ret)) {
                    requestMap.put(key, ret1);
                } else if (requestParamMap.get(key).toString().contains("$") && requestParamMap.get(key).toString().equals(regexName) && !DataFormatProcessing.isInteger(ret)) {
                    requestMap.put(key, ret);
                }
            }
        }
        bodyString = JSONObject.toJSON(requestMap).toString();
        System.out.println(bodyString);
        JSONObject response = requestInterface(url, body, bodyString);
        if (t1.assertMethod(String.valueOf(body.get("resultAssert")), String.valueOf(body.get("assertMethod")), response.toString())) {
            String errorResponse = "";
            updateErrorResponse(Integer.parseInt(id.toString()), "成功", errorResponse);
        } else {
            updateErrorResponse(Integer.parseInt(id.toString()), "失败", response.toString());
        }
    }


    private JSONObject requestInterface(String url, Map<String, Object> body, String bodyString) {
        RequestClient t1 = new RequestClient();
        try {
            t1.getResponse(url, String.valueOf(body.get("requestMethod")), bodyString, String.valueOf(body.get("header")));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        JSONObject response = null;
        try {
            response = t1.getBodyInJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String getUrlFields(Map map, Object id) {
        String url = caseMapper.selectByPrimaryKey(id).getUrl();
        Gson gson = new Gson();
        String jsonResult = gson.toJson(environmentalManagementService.findEnvironmentalName(String.valueOf(map.get("envName"))), new TypeToken<List<EnvironmentalManagement>>() {
        }.getType());
        JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
        JSONObject jsObj = JSON.parseObject(object.get(0).toString());
        url = String.valueOf(jsObj.get("environmentalUrl")) + url;
        return url;
    }

    @Override
    public void copyCase(CaseManagement caseManagement) {
        Random r = new Random();
        caseManagement.setCaseName(String.valueOf(r.nextInt(100000)) + caseManagement.getCaseName());
        Date time = new Date(System.currentTimeMillis());
        caseManagement.setCreateTime(time);
        caseMapper.insertSelective(caseManagement);
    }

//    @Override
//    public List getCaseName() {
//        List<Map> caseNameList = new ArrayList();
//        List caseObjectList = caseMapper.selectAll();
//        for(int i = 0; i < caseObjectList.size(); i++){
//            Map<String, String> map = new HashMap<String,String>();
//            map.put("value", caseMapper.selectAll().get(i).getCaseName());
//            caseNameList.add(map);
//        }
//        return caseNameList;
//    }

    @Override
    public List getCaseName() {
        List<String> caseNameList = new ArrayList<>();
        List<CaseManagement> caseObjectList = caseMapper.selectAll();
        for (int i = 0; i < caseObjectList.size(); i++) {
            caseNameList.add(caseMapper.selectAll().get(i).getCaseName());
        }
        return caseNameList;
    }

    @Override
    public Result uploadExcel(MultipartFile file, CaseManagement caseManagement) throws Exception {
        InputStream ins = file.getInputStream();
        String fileName = file.getOriginalFilename();
        File toFile = new File(fileName);
        inputStreamToFile(ins, toFile);
        ins.close();
        FileInputStream excelData = new FileInputStream(fileName);
        XSSFWorkbook sheets = new XSSFWorkbook(excelData);
        //获取sheet
        XSSFSheet sheet = sheets.getSheet("Sheet1");
        int rows = sheet.getPhysicalNumberOfRows();
        ExecutorService executor = RequestClient.executorService();
        for (int i = 1; i < rows; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {
                synchronized (this) {
                    XSSFRow row = sheet.getRow(finalI);
                    try {
                        addExcelData(row, caseManagement);

                    } catch (Exception e) {
                        logger.error(String.valueOf(e));
                    }
                }
            });
            executor.submit(t);
        }
        executor.shutdown();
        return null;
    }

    @Override
    public void downloadExcel(Map ids) {
        ArrayList<Integer> idList = (ArrayList<Integer>) ids.get("ids");
        for (Integer i: idList){
            logger.error(String.valueOf(i));
        }
    }

    public void addExcelData(XSSFRow row, CaseManagement caseManagement) {
        String moduleName = row.getCell(0).toString();
        String caseName = row.getCell(1).toString();
        String url = row.getCell(2).toString();
        String header = row.getCell(3).toString();
        String requestMethod = row.getCell(4).toString();
        String requestParam = row.getCell(5).toString();
        String assertMethod = row.getCell(6).toString();
        String resultAssert = row.getCell(7).toString();
        String regexName = row.getCell(8).toString();
        String regex = row.getCell(9).toString();
        String quoteCase = row.getCell(10).toString();
        String projectName = row.getCell(11).toString();
        String result = row.getCell(12).toString();
        caseManagement.setModuleName(moduleName);
        caseManagement.setCaseName(caseName);
        caseManagement.setUrl(url);
        caseManagement.setHeader(header);
        caseManagement.setRequestMethod(requestMethod);
        caseManagement.setRequestParam(requestParam);
        caseManagement.setAssertMethod(assertMethod);
        caseManagement.setResultAssert(resultAssert);
        caseManagement.setRegex(regex);
        caseManagement.setRegexName(regexName);
        caseManagement.setQuoteCase(quoteCase);
        caseManagement.setProjectName(projectName);
        caseManagement.setResult(result);
        Date time = new Date(System.currentTimeMillis());
        caseManagement.setCreateTime(time);
        caseMapper.insertSelective(caseManagement);
    }


    public void inputStreamToFile(InputStream ins, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        Integer bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
    }
}
