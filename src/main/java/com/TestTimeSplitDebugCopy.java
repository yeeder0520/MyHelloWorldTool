package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/6/13 下午 02:54
 **/
public class TestTimeSplitDebugCopy {
    public static final long TIME_LIMIT = 1000; // ms


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("C:\\Users\\6620\\Desktop\\MDC相關\\spliteEDI的log (0614 1740異常時段)\\EDISplitter_N5135_1.log.1"));
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("C:\\Users\\6620\\Downloads\\ediTest\\結果.txt"));
        StringBuffer sb = new StringBuffer();

        String line;
        int totalHandleCount = 0;
        int count = 1;
        LocalTime startTime = null;
        LocalTime endTime = null;


        while ((line = bufferedReader.readLine()) != null) {

            if (!line.contains("[INFO][EDISplitter][main]  - From:")) {
                continue;
            }

            String time = line.substring(12, 24);

            if (totalHandleCount == 0) {
                totalHandleCount++;
                String previousMinute = time.split(":")[2];
                System.out.println("previousMinute = " + previousMinute);
            }else{
                String nextMinute = time.split(":")[2];
            }



            System.out.println("time = " + line);


//            DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");
//            sb.append(line).append("\r\n");
//
//            if(startTime == null){
//                startTime = LocalTime.parse(time, df);
//            } else {
//                endTime = LocalTime.parse(time, df);
//                Duration duration = Duration.between(startTime, endTime);
//                if (duration.toMillis() > TIME_LIMIT && !line.contains("Start listFile")) {
//                    // 睡1秒後開始作業，故忽略不算
//                    sb.append("相差 = ").append(duration.toMillis()).append("\r\n");
//                    System.out.println(duration.getSeconds() + " : " + line);
//                }
//                startTime = endTime;
//            }
        }
//        bufferedWriter.write(String.valueOf(sb));
//        bufferedWriter.flush();
//        bufferedWriter.close();

    }

}
