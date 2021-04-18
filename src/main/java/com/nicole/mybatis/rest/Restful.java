package com.nicole.mybatis.rest;

import com.nicole.mybatis.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class Restful {
    public static Map<String, Object> set(int code, String msg, Student student){
        Map<String, Object> restful = new HashMap<>();
        restful.put("code" , code);
        restful.put("msg" , msg);
        restful.put("student" , student);
        return restful;
    }

    public static Map<String, Object> set(int code, String msg){
        Map<String, Object> restful = new HashMap<>();
        restful.put("code" , code);
        restful.put("msg" , msg);
        return restful;
    }
}
