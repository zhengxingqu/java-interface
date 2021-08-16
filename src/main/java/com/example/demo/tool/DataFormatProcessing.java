package com.example.demo.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.EnvironmentalManagement;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DataFormatProcessing {
    public static JSONObject arrayToJson(List array) {
        Gson gson = new Gson();
        String jsonResult = gson.toJson(array, new TypeToken<List<EnvironmentalManagement>>() {
        }.getType());
        JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
        JSONObject jsObj = JSON.parseObject(object.get(0).toString());
        return jsObj;
    }

    public static Map stringToJson(String body) {
        JSONObject requestParamMap = JSON.parseObject(body);
        return requestParamMap;
    }

    public static Map jsonToMap(JSONObject js) {
        Map jsonToMap = JSONObject.parseObject(js.toJSONString());
        return jsonToMap;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static Map stringToMap(String str) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(str, map.getClass());
        return map;
    }

}
