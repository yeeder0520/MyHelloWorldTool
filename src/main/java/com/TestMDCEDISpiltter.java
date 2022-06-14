package com;


import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestMDCEDISpiltter {


    public static void main(String[] args) throws IOException {


        /*
         * 參數
         * INDIRORFILE => /PNGSC/data/MDC/ISF_N5116_3
         * OUTDIR => /PNGSC/data/MDC/ICF
         * BKPDIR => /PNGSC/data/MDC/HISF
         * ERRDIR => /PNGSC/data/MDC/EISF
         * XML_OUTDIR => /PNGSC/data/UTC/IXF/SMALL
         * XML_OUTDIR_LARGE => /PNGSC/data/UTC/IXF/LARGE
         * CC2UTC_LST => /APNGSC/def/MDC_CC2UTC.lst
         * ELIMINATE_LST => /APNGSC/def/MDC_ELIMINATE.lst
         * PEDI_OUTDIR => /PNGSC/data/UTC/IEF_TDM/PEDI
         * SLEEPTIME => 1
         * /APNGSC/def/XML_NEW_LINE_NODE.lst
         * TXT_OUTDIR => /PNGSC/data/UTC/IFF/SMALL
         * TXT_OUTDIR_LARGE => /PNGSC/data/UTC/IFF/LARGE
         */


        /* PNGSC/data/MDC/ISF_N5116   => splitEDI_N5116.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5116_1 => splitEDI_N5116_1.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5117   => splitEDI_N5117.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5118   => splitEDI_N5118.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5119   => splitEDI_N5119.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF_N5120   => splitEDI_N5120.sct => 起java => 派檔
         * PNGSC/data/MDC/ISF         => splitEDI (最原始的)
         * */

        /////////////////////////////////////////////////////
        /*清單.lst
         * /PNGSC/data/MDC/ISF_N5116
         * /PNGSC/data/MDC/ISF_N5116_1
         * /PNGSC/data/MDC/ISF_N5117
         * /PNGSC/data/MDC/ISF_N5118
         * /PNGSC/data/MDC/ISF_N5119
         * /PNGSC/data/MDC/ISF_N5120
         * */

        //PNGSC/data/MDC/ISF_N5116 => splitXML.sct(while啟動，每分鐘掃一份清單.lst，清單內容是收檔目錄，然後確認java有沒有啟動) => 起java => 派檔
        //PNGSC/data/MDC/ISF_N5117 => splitXML.sct
        //PNGSC/data/MDC/ISF_N5118 => splitXML.sct
        //PNGSC/data/MDC/ISF_N5119 => splitXML.sct
        //PNGSC/data/MDC/ISF       => splitEDI.sct (最原始的)

        File file = new File("C:\\Users\\6620\\Desktop\\123\\123");
        for (File listFile : file.listFiles()) {
            System.out.println("file = " +  listFile.getName());
            System.out.println("file = " +  listFile.lastModified());

        }
//        共16971個檔案
//        newMethodByFileList();
        System.out.println("==================================");
//        oldMethodByListFiles();

    }

    private static void newMethodByFileList() throws IOException {
//        FileWriter fw = new FileWriter("C:\\Users\\6620\\Desktop\\新增資料夾\\新方法查找結果.txt");
        StringBuffer sb = new StringBuffer();

        /*開始時間*/
        LocalTime startTime = LocalDateTime.now().toLocalTime();

        File file = new File("/PNGSC/data/6620/01/");
        String[] fileList = file.list(new FileNumberFilter(1000));

        List<File> ifiles = new ArrayList<>();

        for (String aaa : fileList) {
            File file1 = new File(aaa);
            sb.append(file1.getName()).append("\r\n");
            ifiles.add(file1);
        }

        File[] itemsArray = new File[ifiles.size()];
        itemsArray = ifiles.toArray(itemsArray);


        /*開始時間*/
        LocalTime startTimeForSort = LocalDateTime.now().toLocalTime();
        Arrays.sort(itemsArray, new Comparator<File>() {
            public int compare(File f1, File f2) {
                long diffDate = f1.lastModified() - f2.lastModified();
                if (diffDate > 0)
                    return 1;
                else if (diffDate == 0)
                    return 0;
                else
                    return -1;
            }
            public boolean equals(Object obj) {
                return true;
            }
        });
        LocalTime endTimeForSort = LocalDateTime.now().toLocalTime();
        Duration durationForSort = Duration.between(startTimeForSort, endTimeForSort);
        System.out.println("New method Sort Total Time : " + durationForSort.toMillis() + " Millis");

//        fw.write(String.valueOf(sb));
//        fw.flush();
//        fw.close();

        /*結束時間*/
        LocalTime endTime = LocalDateTime.now().toLocalTime();
        Duration duration = Duration.between(startTime, endTime);

        System.out.println("New method Total Time : " + duration.toMillis() + " Millis");
    }

    private static void oldMethodByListFiles() throws IOException {

//        FileWriter fw = new FileWriter("C:\\Users\\6620\\Desktop\\新增資料夾\\舊方法查找結果.txt");
        StringBuffer sb = new StringBuffer();

        /*開始時間*/
        LocalTime startTime = LocalDateTime.now().toLocalTime();

        File file2 = new File("/PNGSC/data/6620/01/");
        File[] files = file2.listFiles();
        System.out.println("files.length = " + files.length);
//        for (File file : files) {
//            sb.append(file.getName()).append("\r\n");
//        }

        /*開始時間*/
        LocalTime startTimeForSort = LocalDateTime.now().toLocalTime();
        Arrays.sort(files, new Comparator<File>() {
            public int compare(File f1, File f2) {
                long diffDate = f1.lastModified() - f2.lastModified();
                if (diffDate > 0)
                    return 1;
                else if (diffDate == 0)
                    return 0;
                else
                    return -1;
            }
            public boolean equals(Object obj) {
                return true;
            }
        });
        LocalTime endTimeForSort = LocalDateTime.now().toLocalTime();
        Duration durationForSort = Duration.between(startTimeForSort, endTimeForSort);
        System.out.println("Old method Sort Total Time : " + durationForSort.toMillis() + " Millis");
//        fw.write(String.valueOf(sb));
//        fw.flush();
//        fw.close();

        /*結束時間*/
        LocalTime endTime = LocalDateTime.now().toLocalTime();
        Duration duration = Duration.between(startTime, endTime);

        System.out.println("Old method Total Time : " + duration.toMillis() + " Millis");
    }

}
