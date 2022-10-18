package com;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/9/1 上午 11:43
 **/
public class TestJustin {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("fieldName","Justin");
        String s = setVariable("%Justin%.xml", map);
        System.out.println("s = " + s);
    }

    public static String setVariable(String str, Map info) {
        int firstPos = str.indexOf("%");
        if (firstPos < 0) return str;
        int count = countStr(str, "%")/2+1;
        int idx = 0;
        while (firstPos >= 0) {
            idx++;
            if (idx > count) break;
            int endPos = str.indexOf("%",firstPos+1);
            if (endPos-firstPos > 1) {
                String fieldName = str.substring(firstPos+1,endPos);
                String Str1 = str.substring(0,firstPos);
                String Str2 = str.substring(endPos+1,str.length());
                if (fieldName != null && !fieldName.equals("")) {
                    String valName = (String)info.get(fieldName);
                    if (valName != null) {
                        str = Str1 + valName + Str2;
                    } else {
                        str = Str1 + Str2;
                    }
                }
            }
            firstPos = str.indexOf("%");
        }
        return str;
    }

    public static int countStr(String str, String s) {
        int pos = str.indexOf(s);
        if (pos < 0) return 0;
        int count = 0;
        while (pos >= 0) {
            count++;
            pos = str.indexOf(s, pos+s.length());
        }
        return count;
    }
}
