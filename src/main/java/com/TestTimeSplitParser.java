package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 利用MAP不重複的性質，去做每個時段MDC處理數量的統計
 *
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/6/13 下午 02:54
 **/
public class TestTimeSplitParser {
    public static final long TIME_LIMIT = 1000; // ms
    public static final String EACH_TIME = "20220614";
    public static final String SPACE = " ";


    public static void main(String[] args) throws IOException {

//        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("C:\\Users\\6620\\Desktop\\MDC相關\\spliteEDI的log (0614 1740異常時段)\\EDISplitter_N5135_1.log.1"));
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("C:\\Users\\yeeder\\Downloads\\新增資料夾\\EDISplitter_N5135_1.log"));

        String line;
        Map<String, Integer> minuteMaps = new HashMap<>();
        int dataAmount = 0;

        while ((line = bufferedReader.readLine()) != null) {

            /*我只要含有 "[INFO][EDISplitter][main]  - From:" 的資料*/
            if (!line.contains("[INFO][EDISplitter][main]  - From:")) {
                continue;
            }
            /*時間格式分割*/
            String time = line.substring(12, 24);
            /*取到分鐘*/
            String timeForMinute = time.split(":")[0] + time.split(":")[1];
            /*把"每分鐘"當作key，如果key不存在，表示要開始統計下一段分鐘數的處理量，把統計量歸0*/
            if (!minuteMaps.containsKey(timeForMinute)) {
                dataAmount = 0;
            }
            minuteMaps.put(timeForMinute, ++dataAmount);
        }

        /*印出統計結果*/
        minuteMaps.keySet().forEach(key -> {
            System.out.println(EACH_TIME + key + SPACE + minuteMaps.get(key));
        });
    }
}
