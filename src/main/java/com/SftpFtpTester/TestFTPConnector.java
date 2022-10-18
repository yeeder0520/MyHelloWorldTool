package com.SftpFtpTester;

//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Properties;
import java.util.Vector;

public class TestFTPConnector {

//    public static void main(String[] args) {
//
//
//
//
//
//        JSch jsch = new JSch();
//
//        session = jsch.getSession(this.userID, this.sftpServerIP, this.sftpServerPort);
//        Logger.info("SFTP > Session created.");
//        session.setPassword(this.password);
//        Properties config = new Properties();
//        config.put("StrictHostKeyChecking", "no");
//        session.setConfig(config);
//        session.setTimeout(this.timeOut * 1000);
//        session.connect();
//        Logger.info("SFTP > Session connected.");
//
//        channel = session.openChannel("sftp");
//        Logger.info("SFTP > connect...");
//        channel.connect(conTimeOut);  // 2016.06.02 �ק� by 6202 �s�W �i�]�w�s�u�O�ɪ��ɶ�
//        Logger.info("SFTP > Connected successfully to sftpHost = " + this.sftpServerIP + ", sftpUserName = "
//                + this.userID);
//        sftpClient = (ChannelSftp) channel;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        String server = "172.31.70.16";
//        int port = 2222;
//        FTPClient ftp = new FTPClient();
//        try {
//            ftp.connect(server, port);
//            ftp.login("tv6689", "111111");
////            ftp.changeWorkingDirectory("/A23416579");
//            System.out.println("------> in directory.....");
////            System.out.println("FTPS > printWorkingDirectory(): " + ftp.printWorkingDirectory());
////            FTPFile[] files = ftp.listFiles();
////            String fileName = "C:\\Users\\6689\\Desktop\\6689test.txt";
//            String fileName = "/home/pngscmgr/6689/6689test.txt";
//            File file = new File(fileName);
//            FileInputStream fs = new FileInputStream(file);
//
//            //boolean b = ftp.storeFile("6689test.txt", fs);
//            //System.out.println(b);
//            sftpClient.put(uploadFileName, remoteFileNamePath, ChannelSftp.OVERWRITE);
//            ftp.logout();
//
//            ftp.disconnect();
//        } catch (SocketException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}

