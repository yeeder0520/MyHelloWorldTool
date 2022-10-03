package com.SftpFtpTester;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    }

//
//
//    private static String sanitizePathTraversal(String filename) {
//        Path p = Paths.get(filename);
//        return p.getFileName().toString();
//    }
//    private String getFileContents_fixed(HttpServletRequest request) throws IOException {
//        String filename = sanitizePathTraversal(""); // Ensures
////        access only to files in a given folder, no traversal
//        Path path = Paths.get(SERVED_FILES_DIR + filename);
//        byte[] fileContentBytes = Files.readAllBytes(path);
//        String fileContents = new String(fileContentBytes, FILE_CONTENT_ENCODING_STRING);
//        return fileContents;
//    }
}