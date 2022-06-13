package com;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 自動產生SplitEDI.sct
 *
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/6/10 下午 06:02
 **/
public class TestSplitEDI {

//        scriptNameLists.add("splitEDI_N5102_1.sct");
//        scriptNameLists.add("splitEDI_N5102_3.sct");
//        scriptNameLists.add("splitEDI_N5108.sct");
//        scriptNameLists.add("splitEDI_N5110.sct");
//        scriptNameLists.add("splitEDI_N5110_1.sct");
//        scriptNameLists.add("splitEDI_N5110_2.sct");
//        scriptNameLists.add("splitEDI_N5110_3.sct");
//        scriptNameLists.add("splitEDI_N5116.sct");
//        scriptNameLists.add("splitEDI_N5116_1.sct");
//        scriptNameLists.add("splitEDI_N5116_2.sct");
//        scriptNameLists.add("splitEDI_N5116_3.sct");
//        scriptNameLists.add("splitEDI_N5116_4.sct");
//        scriptNameLists.add("splitEDI_N5116_5.sct");
//        scriptNameLists.add("splitEDI_N5117.sct");
//        scriptNameLists.add("splitEDI_N5117_1.sct");
//        scriptNameLists.add("splitEDI_N5117_2.sct");
//        scriptNameLists.add("splitEDI_N5117_3.sct");
//        scriptNameLists.add("splitEDI_N5135.sct");
//        scriptNameLists.add("splitEDI_N5135_1.sct");
//        scriptNameLists.add("splitEDI_N5135_2.sct");
//        scriptNameLists.add("splitEDI_N5135_3.sct");
//        scriptNameLists.add("splitEDI_N5135_4.sct");
//        scriptNameLists.add("splitEDI_N5135_5.sct");
//        scriptNameLists.add("splitEDI_NX5105.sct");


    public static void main(String[] args) throws IOException {


        String scriptName = args[0];
        
        StringBuilder sb = new StringBuilder();

        /*範本檔案*/
        BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\6620\\Desktop\\abcdefg\\splitEDI_N5102_1.sct"));

        /*寫出檔案的位置*/
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\6620\\Desktop\\abcdefg\\產出檔案\\" + scriptName));

        /*取出文件別*/
        String msgType = scriptName.substring(scriptName.indexOf("_") + 1, scriptName.lastIndexOf(".sct"));

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {

                if (line.contains("PgId=")) {
                    sb.append("PgId=").append(scriptName).append("\n");
                    continue;
                }

                if (line.contains("InputDir=${MDC_DATA_DIR}/ISF_")) {
                    sb.append("InputDir=${MDC_DATA_DIR}/ISF_").append(msgType).append("\n");
                    continue;
                }

                if (line.contains("CONF_FILE=${NGSC_AP_DIR}/JAVA/conf/logging-EDISplitter_")) {
                    sb.append("CONF_FILE=${NGSC_AP_DIR}/JAVA/conf/logging-EDISplitter_" + msgType + ".xml").append("\n");
                    continue;
                }
                sb.append(line).append("\n");
            }

        } finally {
            reader.close();
            writer.write(String.valueOf(sb));
            writer.flush();
            writer.close();
        }


    }

}
