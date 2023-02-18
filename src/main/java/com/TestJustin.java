package com;


import com.tradevan.taurus.xdao.SqlPredicate;
import com.tradevan.taurus.xdao.SqlWhere;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/9/1 上午 11:43
 **/
public class TestJustin {

    public static void main(String[] args) {
        String dateString = "20200229";  // 日期字符串
        String dateFormat = "yyyyMMdd";  // 日期格式

//// 使用正则表达式检查日期字符串是否符合指定格式
//        if (!dateString.matches("^[0-9]{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$")) {
//            // 日期字符串不合法
//            throw new IllegalArgumentException("日期字符串格式不合法");
//        }

// 将日期字符串转换为 Date 对象
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateString);
        } catch (ParseException e) {
            // 日期字符串不合法
            throw new IllegalArgumentException("日期字符串格式不合法");
        } catch (IllegalArgumentException e) {
            // 日期不合法
            throw new IllegalArgumentException("日期不合法");
        }
    }

}



