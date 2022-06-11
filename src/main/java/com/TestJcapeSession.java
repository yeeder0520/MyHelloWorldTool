package com;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class TestJcapeSession {
    public static void main(String[] args) {
        String ip = "172.31.70.16";
        int port = 10021;


        //2015.09.08 調整多設定port
        try {
            FTPClient ftpclient = new FTPClient();
            //2007.12.31 設定ftp timeout時間
            ftpclient.setDefaultTimeout(5 * 60 * 60 * 1000); //setDefaultTimeout以毫秒為單位
            ftpclient.setDataTimeout(5 * 60 * 60 * 1000);
            ftpclient.setConnectTimeout(5 * 60 * 60 * 1000);
            ftpclient.setStrictReplyParsing(false); // 2020.06.16 6334 修正 Truncated server reply: '220 '
            System.out.println("FTP > connect to " + ip + ":" + port + " ...");
            ftpclient.connect(ip, port);
            ftpclient.enterLocalPassiveMode();

            System.out.println("FTP > data connection mode " + ftpclient.getDataConnectionMode());
            System.out.println("Login: " + ftpclient.login("TEST", "TEST"));
            while (true) { //會一直保持連線
                System.out.println(ftpclient.changeWorkingDirectory("/"));
                System.out.println("Dir: " + ftpclient.printWorkingDirectory());
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
