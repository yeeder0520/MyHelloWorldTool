package com.testConstructor;

import com.TestJava8Files;
import com.test2.TestBean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/8/2 下午 02:38
 **/
public class Hello {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.test2.TestBean");
        TestBean testbean = (TestBean) clazz.newInstance();
        testbean.setApple("富士山");
        System.out.println("testbean.getApple() = " + testbean.getApple());

        System.out.println("clazz.getName() = " + clazz.getName());

//        for (Field declaredField : clazz.getDeclaredFields()) {
//            Field field = clazz.getDeclaredField(declaredField.getName());
//            field.setAccessible(true);
//            System.out.println("field.getName() = " + field.getName());
//        }


//        Method[] declaredMethods = clazz.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println("declaredMethod.getName() = " + declaredMethod.getName());
//            declaredMethod.invoke("aaa");
//        }
    }

}
