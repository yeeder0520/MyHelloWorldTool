package com;

import java.io.*;
import java.nio.file.*;
import java.util.*;

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
    public static final String SPACE = "    ";


    public static void main(String[] args) throws IOException {
        System.out.println("GO");
        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("C:\\Users\\6620\\Desktop\\新增資料夾 (3)"));
        Map<String, Integer> minuteMaps = new HashMap<>();

        paths.forEach(file -> {
            try (BufferedReader bufferedReader = Files.newBufferedReader(file);) {
                String line;

                int dataAmount = 0;

                while ((line = bufferedReader.readLine()) != null) {

                    /*我只要含有 "[INFO][EDISplitter][main]  - From:" 的資料*/
                    if (!line.contains("[INFO][EDISplitter][main]  - From:") ) {
                        continue;
                    }
                    /*時間格式分割*/
                    String time = line.substring(12, 24);
                    /*取到分鐘*/
                    String timeForMinute = time.split(":")[0] + time.split(":")[1];
                    /*把"每分鐘"當作key，如果key不存在，表示要開始統計下一段分鐘數的處理量，把統計量歸0*/
                    if (!minuteMaps.containsKey(timeForMinute)) {
                        dataAmount = 0;
                    } else {
                        dataAmount = minuteMaps.get(timeForMinute);
                    }
                    minuteMaps.put(timeForMinute, ++dataAmount);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        /*印出統計結果*/
        minuteMaps.keySet().forEach(key -> {
            System.out.println(EACH_TIME + key + SPACE + minuteMaps.get(key));
        });

    }
}
