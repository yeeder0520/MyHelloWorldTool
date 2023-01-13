package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/9/1 上午 11:43
 **/
public class parseEmailToSend {

    static String totalEmployee = "C:\\Users\\6620\\Desktop\\測試資料集散地\\組合Mail\\total.txt";
    static String send = "C:\\Users\\6620\\Desktop\\測試資料集散地\\組合Mail\\needsend.txt";

    public static void main(String[] args) {
        parseEmailToSend justn = new parseEmailToSend();
        int count=0;
        StringBuilder sb = new StringBuilder();
        /*Step1.取出總名單*/
        Map<String, String> totalEmployeeMap = justn.generateEmployeeMapFromFile(totalEmployee);
        /*Step2.取出通訊錄名單*/
        List<String> employeeNameInformationList = justn.generateEmployeeNameInformation(send);
        /*Step3.比對作業*/
        for (String employeeName : employeeNameInformationList) {
            if (totalEmployeeMap.containsKey(employeeName)){
                sb.append(totalEmployeeMap.get(employeeName)).append(",");
                count++;
            }else {
                System.out.println("employeeName = " + employeeName);
            }
        }
        System.out.println(sb);
        System.out.println("總人數 : " + count);
    }

    /**
     * 讀取總名單 總名單
     *
     * @return Map<姓名, 信箱>
     */
    private Map<String, String> generateEmployeeMapFromFile(String fileName) {
        /*先讀出總名單*/
        Map<String, String> resultMap = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            while (bufferedReader.ready()) {
                String[] employeeSplit = bufferedReader.readLine().split(",");
                //把信名,信箱放進去總名單
                resultMap.put(
                        employeeSplit[0],
                        employeeSplit[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    private List<String> generateEmployeeNameInformation(String fileName){
        ArrayList<String> resultList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                //把姓名放進去
                resultList.add(bufferedReader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

}
