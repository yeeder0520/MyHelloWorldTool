package com;

import com.FileNumberFilter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestMDCEDISpiltter {


    public static void main(String[] args) throws IOException {
        /* PNGSC/data/MDC/ISF_N5116   => splitEDI_N5116.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5116_1 => splitEDI_N5116_1.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5117   => splitEDI_N5117.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5118   => splitEDI_N5118.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5119   => splitEDI_N5119.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5120   => splitEDI_N5120.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF         => splitEDI (最原始的)
         * */

        /////////////////////////////////////////////////////
        /*清單.lst
         * /PNGSC/data/MDC/ISF_N5116
         * /PNGSC/data/MDC/ISF_N5116_1
         * /PNGSC/data/MDC/ISF_N5117
         * /PNGSC/data/MDC/ISF_N5118
         * /PNGSC/data/MDC/ISF_N5119
         * /PNGSC/data/MDC/ISF_N5120
         * */

        //PNGSC/data/MDC/ISF_N5116 => splitXML.sct(while啟動，每分鐘掃一份清單.lst，清單內容是收檔目錄，然後確認java有沒有啟動) => 起java => 派檔
        //PNGSC/data/MDC/ISF_N5117 => splitXML.sct
        //PNGSC/data/MDC/ISF_N5118 => splitXML.sct
        //PNGSC/data/MDC/ISF_N5119 => splitXML.sct
        //PNGSC/data/MDC/ISF       => splitEDI.sct (最原始的)


//        共16971個檔案
        newMethodByFileList();
        System.out.println("==================================");
        oldMethodByListFiles();

    }

    private static void newMethodByFileList() throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\6620\\Desktop\\新增資料夾\\新方法查找結果.txt");
        StringBuffer sb = new StringBuffer();

        /*開始時間*/
        LocalTime startTime = LocalDateTime.now().toLocalTime();

        File file = new File("C:\\Users\\6620\\Desktop\\測試資料集散地\\N5116MDC測試用轉檔檔案\\20220528\\00");
        String[] fileList = file.list(new FileNumberFilter(1000));

        for (String aaa : fileList) {
            File file1 = new File(aaa);
            sb.append(file1.getName()).append("\r\n");
        }
        fw.write(String.valueOf(sb));
        fw.flush();
        fw.close();

        /*結束時間*/
        LocalTime endTime = LocalDateTime.now().toLocalTime();
        Duration duration = Duration.between(startTime, endTime);

        System.out.println("New method Total Time : " + duration.toMillis() + " Millis");
    }

    private static void oldMethodByListFiles() throws IOException {

        FileWriter fw = new FileWriter("C:\\Users\\6620\\Desktop\\新增資料夾\\舊方法查找結果.txt");
        StringBuffer sb = new StringBuffer();

        /*開始時間*/
        LocalTime startTime = LocalDateTime.now().toLocalTime();

        File file2 = new File("C:\\Users\\6620\\Desktop\\測試資料集散地\\N5116MDC測試用轉檔檔案\\20220528\\00");
        File[] files = file2.listFiles();
        System.out.println("files.length = " + files.length);
        for (File file : files) {
            sb.append(file.getName()).append("\r\n");
        }
        fw.write(String.valueOf(sb));
        fw.flush();
        fw.close();

        /*結束時間*/
        LocalTime endTime = LocalDateTime.now().toLocalTime();
        Duration duration = Duration.between(startTime, endTime);

        System.out.println("Old method Total Time : " + duration.toMillis() + " Millis");
    }

}
