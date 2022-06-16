package com;

import java.io.*;
import java.nio.file.*;

/**
 * 自動產生SplitEDI.sct
 *
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/6/10 下午 06:02
 **/
public class CreateNewSplitEDIFactory {

    static final String XML_PATH = "/APNGSC/JAVA/conf/logging-EDISplitter_";
    static final String BASE_XML_FILE = "/APNGSC/SCT/MDC/UTIL/logging-EDISplitter_Base.xml";
    static final String SCRIPT_PATH = "/APNGSC/SCT/MDC/";
    static final String BASE_SCRIPT_FILE = "/APNGSC/SCT/MDC/UTIL/splitEDI_Base.sct";

    public static void main(String[] args) throws IOException {

        String scriptName = args[0];
        /*取出文件別*/
        String msgType = scriptName.substring(scriptName.indexOf("_") + 1, scriptName.lastIndexOf(".sct"));

        /*Step1.產生XML檔案*/
        createLoggingXmlFile(msgType);
        /*Step2.產生Script檔案*/
        createSplitEDI(scriptName, msgType);
    }

    /**
     * 產生分流 splitEDI所需要使用的logging.xml檔案
     *
     * @param msgType 文件別
     * @throws IOException
     */
    private static void createLoggingXmlFile(String msgType) throws IOException {
        /*範本檔案*/
        BufferedReader reader = Files.newBufferedReader(Paths.get(BASE_XML_FILE));
        /*寫出檔案的位置*/
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(XML_PATH + msgType + ".xml"));

        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                if (line.contains("<property name=\"filename\" value=\"/PNGSC/log/MDC/")) {
                    sb.append("        <property name=\"filename\" value=\"/PNGSC/log/MDC/EDISplitter_").append(msgType).append(".log\"/>").append("\n");
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

    /**
     * 產生分流 splitEDI ShellScript
     *
     * @param scriptName scriptName
     * @param msgType    msgType
     * @throws IOException
     */
    private static void createSplitEDI(String scriptName, String msgType) throws IOException {
        /*範本檔案*/
        BufferedReader reader = Files.newBufferedReader(Paths.get(BASE_SCRIPT_FILE));

        /*寫出檔案的位置*/
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SCRIPT_PATH + scriptName));

        StringBuilder sb = new StringBuilder();
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
