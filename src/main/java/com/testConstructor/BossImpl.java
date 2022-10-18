package com.testConstructor;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/8/2 下午 02:38
 **/
public class BossImpl implements Boss{


    public BossImpl(String string) {
        System.out.println("string = " + string);
    }

    public BossImpl(int intee) {
        System.out.println("intee = " + intee);
    }
}
