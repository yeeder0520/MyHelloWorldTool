package com;

/**
 * @author YeeDer
 * @since 2023/2/8 下午 05:45
 **/
public class TestAppdata {
    public static void main(String[] args) {
        String appData = System.getenv("APPDATA");
        System.out.println("APPDATA: " + appData);
    }
}
