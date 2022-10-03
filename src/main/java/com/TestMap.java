package com;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/8/3 下午 02:32
 **/
public class TestMap {

    public static void main(String[] args) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("AA","11");
        resultMap.put("BB","22");
        resultMap.put("CC","33");

        resultMap.forEach((key,value) ->{
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        });

    }
}
