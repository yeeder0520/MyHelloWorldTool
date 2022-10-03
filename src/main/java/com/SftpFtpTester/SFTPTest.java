package com.SftpFtpTester;

import com.jcraft.jsch.*;

import java.io.File;
import java.util.Properties;
import java.util.Vector;

/**
 * Title: SFTPTest.java<br>
 * Description: <br>
 * Company: Tradevan Co.<br>
 *
 * @author 2920
 * @version 1.0.0
 * @since 2021/1/29
 */
public class SFTPTest {

    public static void main(String[] args) {

        String userId = "tv6689";
        String ftpServerIp = "172.31.70.16";
        String port = "2222";
        String pwd = "111111";

        ChannelSftp sftpClient = null;
        Session session = null;
        JSch jsch = new JSch();
        try {
            session = jsch.getSession(userId, ftpServerIp, Integer.parseInt(port));
            System.out.println("SFTP > Session created.");
            session.setPassword(pwd);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(300 * 1000);
            session.connect();
            System.out.println("SFTP > Session connected.");

            sftpClient = (ChannelSftp) session.openChannel("sftp");
            System.out.println("SFTP > connect...");
            sftpClient.connect(300 * 1000);
            System.out.println("SFTP > Connected successfully to sftpHost = " + ftpServerIp + ", sftpUserName = "
                    + userId);
//            sftpClient = (ChannelSftp) channel;

            System.out.println("connect: " + sftpClient.isConnected());


//            sftpClient.put("C:\\Users\\6689\\Desktop\\exeRedoJob.sct-1.log", "/tv6689/", ChannelSftp.OVERWRITE);
//            sftpClient.put("C:\\Users\\6689\\Desktop\\PMSGSchedulerEntry.log", "/tv6689/", ChannelSftp.OVERWRITE);
            Vector ls = sftpClient.ls("/");

            for (Object files : ls) {
                String fileName = files.toString().substring(files.toString().lastIndexOf(" "));
                File file = new File(fileName);
                System.out.println("file = " + file);
                sftpClient.get("/", "C:\\worksapceTest\\MyHelloWorldTool\\testFile\\");
            }
            System.out.println("OK");
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }

    }
}
