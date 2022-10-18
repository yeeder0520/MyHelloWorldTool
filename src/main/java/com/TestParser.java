package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2021/7/23 上午 11:18
 **/
public class TestParser {

    final static String MY_PATH = "C:\\Users\\6620\\Desktop\\20220704\\";

    public static void main(String[] args) throws IOException {
        TestParser testParser  = new TestParser();
        testParser.startXMLParser();
    }

    private void startXMLParser() throws IOException {

        DirectoryStream<Path> files = Files.newDirectoryStream(Paths.get(MY_PATH));
        for (Path file : files) {
            if (file.getFileName().toString().endsWith("hdr")) {
                continue;
            }
            handleLine(file.toString());
        }

    }

    private void handleLine(String filename) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filename));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains("<TransactionID>")){
                String substring = line.substring(line.indexOf("<TransactionID>")+15, line.indexOf("</TransactionID>"));
                sb.append("'").append(substring).append("',");
                sb.append("\n");
                System.out.println("sb.toString() = " + sb.toString());
                break;
            }
        }
        writeNewXMLFile(sb.toString());
        bufferedReader.close();
    }


    private static void writeNewXMLFile(String data) throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("C:\\Users\\6620\\Desktop\\20220704\\result.txt"), StandardOpenOption.APPEND);
        bufferedWriter.write(data);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
