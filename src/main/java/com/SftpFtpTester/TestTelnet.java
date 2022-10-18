package com.SftpFtpTester;


import javax.net.SocketFactory;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

/**
 * 2020.12.29 ����loacl��ӥD��telnet�s�u�A�]�w�ɬ�a.txt
 *
 * @author 6619
 */
public class TestTelnet {
    public static void main(String[] args) throws IOException {
//        ArrayList<String> ipArray = new ArrayList<>();
//        ArrayList<String> portArray = new ArrayList<>();
//        BufferedReader reader = null;
//        try {
//            FileReader fr = new FileReader("TelnetFile_20211022");
//            BufferedReader br = new BufferedReader(fr);
//            String str = null;
//            while ((str = br.readLine()) != null) {
//                if (!str.startsWith("#")) {
//                    String[] strsplit = str.split(":");
//                    String ip = strsplit[0];
//                    int startPort = Integer.parseInt(strsplit[1]);
//                    int endPort = Integer.parseInt(strsplit[2]);
//                    if (startPort == endPort) {
//                        ipArray.add(ip);
//                        portArray.add(strsplit[1]);
//                        continue;
//                    }
//                    while (startPort <= endPort) {
//                        ipArray.add(ip);
//                        portArray.add(String.valueOf(startPort));
//                        startPort++;
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (reader != null)
//                    reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        Socket socket = null;
//        SocketAddress socketAddress;
//        for (int i = 0; i < ipArray.size(); i++) {
//            try {
//                socket = SocketFactory.getDefault().createSocket();
//                socketAddress = new InetSocketAddress(ipArray.get(i), Integer.valueOf(portArray.get(i)));
//                socket.connect(socketAddress, 1000);
//                if (socket.isConnected()) {
//                    System.out.println("ALIVE     " + "telnet " + ipArray.get(i) + " " + portArray.get(i));
//                }
//            } catch (IOException e) {
//                System.out.println("FAIL!!!   " + "telnet " + ipArray.get(i) + " " + portArray.get(i));
//                continue;
//            } finally {
//                if (socket != null && !socket.isClosed())
//                    socket.close();
//            }
//        }
    }
}
