package com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/6/10 下午 06:02
 **/
public class TestSplitEDI {


    public static void main(String[] args) throws IOException {

        List<String> msgTypeList = new ArrayList<>();
        msgTypeList.add("splitEDI_N5102_1.sct");
        msgTypeList.add("splitEDI_N5102_3.sct");
        msgTypeList.add("splitEDI_N5108.sct");
        msgTypeList.add("splitEDI_N5110.sct");
        msgTypeList.add("splitEDI_N5110_1.sct");
        msgTypeList.add("splitEDI_N5110_2.sct");
        msgTypeList.add("splitEDI_N5110_3.sct");
        msgTypeList.add("splitEDI_N5116.sct");
        msgTypeList.add("splitEDI_N5116_1.sct");
        msgTypeList.add("splitEDI_N5116_2.sct");
        msgTypeList.add("splitEDI_N5116_3.sct");
        msgTypeList.add("splitEDI_N5116_4.sct");
        msgTypeList.add("splitEDI_N5116_5.sct");
        msgTypeList.add("splitEDI_N5117.sct");
        msgTypeList.add("splitEDI_N5117_1.sct");
        msgTypeList.add("splitEDI_N5117_2.sct");
        msgTypeList.add("splitEDI_N5117_3.sct");
        msgTypeList.add("splitEDI_N5135.sct");
        msgTypeList.add("splitEDI_N5135_1.sct");
        msgTypeList.add("splitEDI_N5135_2.sct");
        msgTypeList.add("splitEDI_N5135_3.sct");
        msgTypeList.add("splitEDI_N5135_4.sct");
        msgTypeList.add("splitEDI_N5135_5.sct");
        msgTypeList.add("splitEDI_NX5105.sct");

        for (String sct : msgTypeList) {
            StringBuffer sb = new StringBuffer();

            //寫出檔案的位置
            FileWriter fw = new FileWriter("C:\\Users\\6620\\Desktop\\abcdefg\\產出檔案\\"+sct);

            //範本檔案
            FileReader fr = new FileReader("C:\\Users\\6620\\Desktop\\abcdefg\\splitEDI_N5102_1.sct");
            BufferedReader br = new BufferedReader(fr);

            //取出文件別
            String msgType = sct.substring(sct.indexOf("_") + 1, sct.lastIndexOf(".sct"));


            String line = null;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
                if (line.contains("PgId=")) {
                    sb.append("PgId=").append(sct).append("\n");
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

                sb.append(line + "\n");
            }
            fr.close();
            fw.write(String.valueOf(sb));
            fw.flush();
            fw.close();
        }


    }

}
