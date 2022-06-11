package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8Files {

    final static String MY_PATH = "C:\\Users\\yeeder\\Desktop\\楓之谷測試\\";

    public static void main(String[] args) throws IOException {

        /*讀檔案，直接用Files.line()*/
//        testLines();
        /*寫檔案*/
//        testNewBufferedWriter();
        /*讀檔案*/
//        testNewBufferedReader();
        /*建立檔案*/
//        testCreateFile();
        /*建立資料夾*/
//        testCreateDirectories();
        /*掃描目錄*/
//        testNewDirectoryStream();
        /*掃描目錄 -> Files.walk*/
        testWalk();
        /*移動檔案*/
//        testMove();

    }

    /**
     * 移動檔案
     *
     * @throws IOException
     */
    private static void testMove() throws IOException {
        Files.move(Paths.get(MY_PATH + "B.txt"), Paths.get(MY_PATH, "changeB.txy"));
    }

    /**
     * 掃描目錄 -> Files.walk
     *
     * @throws IOException
     */
    private static void testWalk() throws IOException {
        List<Path> collectFiles = Files.walk(Paths.get(MY_PATH))
                .filter(file -> file.toFile().isFile())
                .limit(10)
                .collect(Collectors.toList());

        for (Path collectFile : collectFiles) {
            System.out.println("collectFile = " + collectFile);
        }
    }

    /**
     * 讀檔案，直接用Files.line()
     *
     * @throws IOException
     */
    private static void testLines() throws IOException {
        Stream<String> lines = Files.lines(Paths.get(MY_PATH + "B.txt"));
        List<String> aaa = lines.filter(s -> !s.contains("aaa")).collect(Collectors.toList());
        for (String s : aaa) {
            System.out.println("s = " + s);
        }
    }

    /**
     * 寫檔案
     *
     * @throws IOException
     */
    private static void testNewBufferedWriter() throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(MY_PATH + "B.txt"));
        bufferedWriter.write("靠北阿eee");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /**
     * 讀檔案
     *
     * @throws IOException
     */
    private static void testNewBufferedReader() throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(MY_PATH, "B.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("line = " + line);
        }
        bufferedReader.close();
    }

    /**
     * 掃描目錄
     *
     * @throws IOException
     */
    private static void testNewDirectoryStream() throws IOException {
        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(MY_PATH));
        for (Path path : paths) {
            System.out.println("path.getFileName() = " + path.getFileName());
        }
    }

    /**
     * 建立檔案
     *
     * @throws IOException
     */
    private static void testCreateFile() throws IOException {
        Files.createFile(Paths.get(MY_PATH + "createFile.txt"));
    }

    /**
     * 建立資料夾
     *
     * @throws IOException
     */
    private static void testCreateDirectories() throws IOException {
        Files.createDirectories(Paths.get(MY_PATH + "createDirectories"));
    }
}
