package com.example.demo.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestClient {
    CloseableHttpClient httpClient;
    HttpGet httpGet;
    HttpPost httpPost;
    HttpPut httpPut;
    HttpDelete httpDelete;
    CloseableHttpResponse httpResponse;
    int responseCode;
    JSONObject responseBody;
    static String code = "";
    static String errorHttpResponse;


    public void getResponse(String url, String requestMethod, String jsonData, String header) throws ClientProtocolException, IOException, URISyntaxException {
        Gson gson = new Gson();
        Map headerMap = new HashMap<String, Object>();
        headerMap = gson.fromJson(header, headerMap.getClass());
        httpClient = HttpClients.createDefault();
        HashMap getJsonData = JSON.parseObject(jsonData, HashMap.class);
        switch (requestMethod) {
            case "get":
                url = url + "?";
                for (Object key : getJsonData.keySet()) {
                    url = url + key + "=" + getJsonData.get(key) + "&";
                }
                httpGet = new HttpGet(url);
                try {
                    httpResponse = httpClient.execute(httpGet);
                }catch (Exception e){
                    System.out.println(e);
                    errorHttpResponse = e.getMessage();
//                    System.out.println(errorHttpResponse);
                }

                try {
                    code = String.valueOf(httpResponse.getStatusLine().getStatusCode());
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            case "post":
                httpPost = new HttpPost(url);
                for (Object key : headerMap.keySet()) {
                    httpPost.addHeader((String.valueOf(key)), String.valueOf(headerMap.get(key)));
                }
                StringEntity s = new StringEntity(jsonData);
                httpPost.setEntity(s);
                httpResponse = httpClient.execute(httpPost);
                System.out.println(httpResponse.getStatusLine().getStatusCode());
                System.out.println(httpResponse.toString());
                code = String.valueOf(httpResponse.getStatusLine().getStatusCode());
                break;
            case "delete":
                httpDelete = new HttpDelete(url);
                httpResponse = httpClient.execute(httpDelete);
                code = String.valueOf(httpResponse.getStatusLine().getStatusCode());
                break;
            case "put":
                httpPut = new HttpPut(url);
                for (Object key : headerMap.keySet()) {
                    httpPut.addHeader((String.valueOf(key)), String.valueOf(headerMap.get(key)));
                }
                StringEntity s2 = new StringEntity(jsonData);
                httpPut.setEntity(s2);
                httpResponse = httpClient.execute(httpPut);
                code = String.valueOf(httpResponse.getStatusLine().getStatusCode());
                break;
        }
    }

    public JSONObject getBodyInJSON() throws ParseException, IOException {
        HttpEntity entity;
        String entityToString;
        entity = httpResponse.getEntity();
        entityToString = EntityUtils.toString(entity);
        responseBody = JSON.parseObject(entityToString);
        return responseBody;
    }

    public boolean assertMethod(String resultAssert, String method, String responseResult) {
        boolean result = false;
        switch (method) {
            case "in":
                return responseResult.contains(resultAssert);
            case "=":
                return resultAssert.equals(responseResult);
            case "code":
                System.out.println(resultAssert.equals(code));
                return resultAssert.equals(code);
        }
        return result;
    }

    public static ExecutorService executorService() {
        return Executors.newFixedThreadPool(10);
    }
}
