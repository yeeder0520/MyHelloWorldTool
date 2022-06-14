package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Title: PPLineParse.java<br>
 * Description: <br>
 * Company: Tradevan Co.<br>
 * <p>
 * 列出與前一行相差 ${ALERT_TIME} 的紀錄
 *
 * @author 2920
 * @version 1.0.0
 * @since 2021/3/29
 */
public class EDISplitterParse {
    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STRING);
    public static final long ALERT_TIME = 2000; // ms


    public static void main(String[] args) {
        File fileName = new File("C:\\Users\\6620\\Desktop\\MDC相關\\spliteEDI的log");

        System.out.println(fileName.getAbsolutePath());
        System.out.println(fileName.isFile());
        System.out.println(fileName.isDirectory());

        if (fileName.isFile()) {
            checkFile(fileName.getAbsolutePath());
        } else if (fileName.isDirectory()) {
            for (File file : fileName.listFiles()) {
                checkFile(file.getAbsolutePath());
            }
        }
    }

    public static void checkFile(String fileName) {
//        System.out.println("Handle: " + fileName);
        BufferedReader br = null;
        String line = null;
        long begin = 0;
        long tmpDate = 0;

        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
//                if(!line.contains("2022-06-07 14:3")){
//                    continue;
//                }
                if (!line.startsWith("[")) {
                    continue;
                }
                tmpDate = DATE_FORMAT.parse(line.substring(1, DATE_FORMAT_STRING.length() + 1)).getTime();

                if (begin == 0) {
                    begin = tmpDate;
                } else {
                    long end = tmpDate;
                    if ((end - begin) > ALERT_TIME && !line.contains("Start listFile")) {
                        System.out.println((end - begin) / 1000 + "s \t " + line);
                    }
                    begin = end;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
