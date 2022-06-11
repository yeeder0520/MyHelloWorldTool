package com;

import com.test2.TestBean;

import java.text.MessageFormat;
import java.util.Collections;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/5/23 下午 05:40
 **/
public class TestJava8_Collection {


    public static void main(String[] args) {

        String[] pattern = new String[22];
        pattern[0] = "aaa";
        pattern[1] = "bbb";
        pattern[2] = "ccc";
        pattern[3] = "ddd";
        String billingPattern = "{0}幹{1}幹{2}^{3}^{4}^{5}^{6}^{7}^{8}^{9}^{10}^{11}^{12}^{13}^{14}^{15}^{16}^{17}^{18}^{19}^{20}^{21}";

        String writeRecord = MessageFormat.format(billingPattern,pattern);
        System.out.println("writeRecord = " + writeRecord);
    }
}
