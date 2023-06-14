package com.appPublishTest;

import org.apache.commons.collections.map.LinkedMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.regex.Pattern;

public class APPPublish {

    private static Map PubDef;
    private static Pattern numPattern = Pattern.compile("^[0-9]+$");

    private static String[] ESCAPE_AREA = { "CE", "CF", "CO", "CR", "CU", "CV", "CX", "BX" };

    static {
        //�x�s�q�\�T���]�w
        PubDef = new LinkedMap();
        //�h��(1)/���(0), �Τ@�s����m, ����, �����c����m, ����, ���渹�X, ����, �������O, ����, (�R/���)�νs, ����
        int[] DEF_5105  = { 1,   11, 14,    2, 4,  2, 14,  25, 2 };
        int[] DEF_5105A = { 1, 1072, 14, 1063, 4,  2, 14,  19, 2, 1286, 14};
        int[] DEF_5105S = { 1,  932, 14,  923, 4,  2, 14,  19, 2, 1146, 14};
        int[] DEF_5116  = { 0,   30, 14,   26, 4,  0, 14,   0, 0 }; //�S���������O
        int[] DEF_5116S = { 1,   27, 14,   16, 4,  2, 14, 152, 2 };
        int[] DEF_5203  = { 1,   11, 14,    2, 4,  2, 14,  25, 2, 224, 14 };
        int[] DEF_5203A = { 1,  953, 14,  944, 4,  2, 14,  19, 2, 1167, 14 };
        int[] DEF_5203S = { 1,  953, 14,  944, 4,  2, 14,  19, 2 };
        int[] DEF_5204  = { 0,   30, 14,   26, 4,  0, 14,   0, 0 }; //�S���������O
        int[] DEF_5204S = { 1,   27, 14,   16, 4,  2, 14,   0, 0 }; //�S���������O
        int[] DEF_5110  = { 1,   16, 14,   33, 4, 52, 14,   0, 0 }; //�S���������O
        int[] DEF_5110S = { 1,   86, 14,  103, 4,  2, 14,   0, 0 }; //�S���������O
        int[] DEF_5111  = { 0,   28, 14,   45, 4, 14, 14,   0, 0 }; //�S���������O
        int[] DEF_5111S = { 0,   28, 14,   45, 4, 14, 14,   0, 0 }; //�S���������O
        //2013.08.03 �s�WN�t�C����
        //2015.05.18 �ק�NX5105�Τ@�s����m�q347��367
        int[] DEF_NX5105= { 1,  367, 14,  107, 4, 81, 14, 105, 2, 1662, 14 };
        int[] DEF_N5116 = { 1,  383, 14,    6, 4, 13, 14,  11, 2 };
        int[] DEF_N5203 = { 1,   72, 14,    6, 4, 58, 14,  56, 2, 328, 14 };
        int[] DEF_N5204 = { 1,  288, 14,    6, 4, 10, 14,  24, 2 };
        int[] DEF_N5135 = { 1,   73, 14,    5, 4, 59, 14,  57, 2 };
        int[] DEF_N5205 = { 1,   73, 14,    5, 4, 59, 14,  57, 2 };

        int[] DEF_N5110 = { 1,   25, 14,  192, 4,359, 14, 373, 2 };
        int[] DEF_N5111 = { 1,   46, 14,  290, 4,213, 14,   0, 0 }; //�S���������O

        PubDef.put("5105", DEF_5105);
        PubDef.put("5105A", DEF_5105A);
        PubDef.put("5105S", DEF_5105S);
        PubDef.put("5116", DEF_5116);
        PubDef.put("5116S", DEF_5116S);
        PubDef.put("5203", DEF_5203);
        PubDef.put("5203A", DEF_5203A);
        PubDef.put("5203S", DEF_5203S);
        PubDef.put("5204", DEF_5204);
        PubDef.put("5204S", DEF_5204S);
        PubDef.put("5110", DEF_5110);
        PubDef.put("5110S", DEF_5110S);
        PubDef.put("5111", DEF_5111);
        PubDef.put("5111S", DEF_5111S);
        //2013.08.03 �s�WN�t�C����
        PubDef.put("NX5105", DEF_NX5105);
        PubDef.put("N5116", DEF_N5116);
        PubDef.put("N5203", DEF_N5203);
        PubDef.put("N5204", DEF_N5204);
        PubDef.put("N5135", DEF_N5135);
        PubDef.put("N5205", DEF_N5205);
        //2016.03.31 �s�WN5110�BN5111
        PubDef.put("N5110", DEF_N5110);
        PubDef.put("N5111", DEF_N5111);
    }

    public static void main(String[] args) {
        // parser���~�A�O�]������r�����Y�A�i�H�⥦�۴���
        File f = new File("C:\\Users\\6620\\Desktop\\X230509_143947.SBK0162_N595YUTDT001_0001_NX5105.app");
        /*
         *  AppPublisher �T�����e�����]�w (�� EXT)
         * �ݶi DB �d��
         */
        boolean hasOppBan = true;
        boolean escAreaIgnore = false;



        String _file = f.getName().toUpperCase(); // �ݽվ�
        int e_pos = _file.lastIndexOf(".APP");
        int s_pos = _file.lastIndexOf("_");
        String _mtype = _file.substring(s_pos + 1, e_pos);
        int[] _def = (int[]) PubDef.get(_mtype);
        /* �ݶi DB �d��
        String[] _ary = { usBean.getUserProf().getCustomerId(), usBean.getConfig().getProcessId(),
                usBean.getConfig().getCustomerBan(), usBean.getConfig().getBoxNo(),
                //2009.11.03 �ϥ�SpecialNote���w�Τ@�s����m�Ϊ���
                //2010.03.18 �P�_�������O
                //2015.01.15 �s�W�νsFilter�L�o����
                usBean.getConfig().getSpecialNote(), usBean.getConfig().getDeclType(),
                filterBan, filterLocation, filterLength};
        */
        String[] pubVec = {"28580346", "08", "28580346", "", "", "", "","", ""};

        try {
            scan(f, _mtype, _def, pubVec, hasOppBan, escAreaIgnore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void scan(File f, String _mtype, int[] _def, String[] _pub, boolean hasOppBan, boolean escAreaIgnore) throws Exception {

        System.out.println("***** scan  " + f.getName());
        BufferedReader buf = new BufferedReader(new FileReader(f));
//        BufferedReader buf = Files.newBufferedReader(Paths.get(f.getAbsolutePath()));
        try {
            String str = "";
            //�}�lŪ��
            FileWriter fw = null;
            boolean keepWriten = false;
            while ((str = buf.readLine()) != null) {
                //System.out.println(str);
                byte[] bytes = str.getBytes();

                System.out.println("bytes = " + new String(bytes));
                boolean escape = false;
                if (_def[0] == 0) {//�B�z���
                    System.out.println("===>" );
                    String m_ban = new String(subByteArray(bytes, _def[1], _def[1] + _def[2])).trim();
                    String m_boxno = new String(subByteArray(bytes, _def[3], _def[3] + _def[4])).trim();
                    String m_declno = new String(subByteArray(bytes, _def[5], _def[5] + _def[6])).trim();
                    String m_decltype = "";
                    if(_def[8] != 0)
                        m_decltype = new String(subByteArray(bytes, _def[7], _def[7] + _def[8])).trim();//T3

                    System.out.println(m_ban + "#" + m_boxno + "#" + m_declno + "#" + m_decltype);

                    //�T�{�O�_���ֻ�����
                    if((!escAreaIgnore && _mtype.equals("5116")) || _mtype.equals("5116S")){
                        for (int i = 0; i < ESCAPE_AREA.length; i++) {
                            if (m_declno.substring(0, 2).equals(ESCAPE_AREA[i])) {
                                escape = true;
                                break;
                            }
                        }
                    }
                    //���O�_���Τ�q�\�A�g�X�ɮ�
                    //if (!escape && (m_ban.equals(_pub[2]) || m_boxno.equals(_pub[3]))) {
                    //2010.03.18 ���νs, �c��, �������O
                    //2015.01.15 �s�W�L�o�νs�P�_
                    boolean passFilter = checkSellBuyBan(_pub[6], _pub[7], _pub[8], bytes);

                    if(!escape && (isNullorEmpty(_pub[2])? true : _pub[2].equals(m_ban)) &&
                            (isNullorEmpty(_pub[3])? true : _pub[3].equals(m_boxno)) &&
                            (isNullorEmpty(_pub[5])? true : _pub[5].equals(m_decltype)) && passFilter) {
                        String ofile = _pub[0] + _pub[1] + "_" + m_declno.replaceAll(" ", "_") + "_" + _mtype + "_"
                                + getHHmmss() + ".txt";
                        System.out.println("write file to IMSG/" + ofile);
//                        fw.write(str);
//                        fw.close();
//                        fw = null;
                    }
                } else {//�B�z�h��

                    //2013.08.03 N�t�C����h�P�_T01
                    //2015.12.10 �s�W�P�_�C����׬O�_�p��̪��w�q by 6202
                    if ((str.startsWith("T1") || str.startsWith("T01")) && str.length() >= getMaxDefNum(_mtype)) {//�W���T�������P�U���T���}�l���B�z
                        if (fw != null) {
                            fw.close();
                            fw = null;
                        }
                        keepWriten = false;
                        String m_ban = new String(subByteArray(bytes, _def[1], _def[1] + _def[2])).trim();
                        String m_boxno = new String(subByteArray(bytes, _def[3], _def[3] + _def[4])).trim();
                        String m_declno = new String(subByteArray(bytes, _def[5], _def[5] + _def[6])).trim();
                        String m_decltype = "";
                        if(_def[8] != 0)
                            m_decltype = new String(subByteArray(bytes, _def[7], _def[7] + _def[8])).trim();//T3
                        System.out.println(m_ban + "#" + m_boxno + "#" + m_declno + "#" + m_decltype);

                        //�T�{�O�_���ֻ�����
                        //2013.08.03 N�t�C����h�P�_N5116��N5204
                        if (_mtype.equals("5116") || _mtype.equals("5204") ||
                                (!escAreaIgnore && _mtype.equals("N5116")) || (!escAreaIgnore && _mtype.equals("N5204"))) {
                            for (int i = 0; i < ESCAPE_AREA.length; i++) {
                                if (m_declno.substring(0, 2).equals(ESCAPE_AREA[i])) {
                                    escape = true;
                                    break;
                                }
                            }
                        }
                        //���O�_���Τ�q�\�A�g�X�ɮ�
                        //if (!escape && (m_ban.equals(_pub[2]) || m_boxno.equals(_pub[3]))) {
                        //2010.03.18 ���νs, �c��, �������O
                        //2015.01.15 �s�W�L�o�νs�P�_
                        boolean passFilter = checkSellBuyBan(_pub[6], _pub[7], _pub[8], bytes);
                        boolean isExporterBan = isNullorEmpty(_pub[2]) ? true : _pub[2].equals(m_ban);

                        isExporterBan = chkOppBan(isExporterBan, hasOppBan, _def, bytes, _mtype, _pub, m_decltype);

                        if(!escape && (isExporterBan) &&
                                (isNullorEmpty(_pub[3])? true : _pub[3].equals(m_boxno)) &&
                                (isNullorEmpty(_pub[5])? true : _pub[5].equals(m_decltype)) && passFilter) {  // ���νs, �c��, �������O, �L�o�νs�P�_
                            String ofile = _pub[0] + _pub[1] + "_" + m_declno.replaceAll(" ", "_") + "_" + _mtype + "_"
                                    + getHHmmss() + ".txt";
                            System.out.println("write file to IMSG/" + ofile);
//                            fw = new FileWriter( CommonLib.INDIR + CommonLib.FILE_SEPARATOR + ofile);
//                            fw.write(str);
//                            fw.write("\r\n");
                            keepWriten = true;
                        }
                    } else {
                        if (keepWriten) {
                            System.out.println("in keepWriten " + str);
//                            fw.write(str);
//                            fw.write("\r\n");
                        }
                    }
                }
            }
            if (fw != null) {
                fw.close();
                fw = null;
            }
        } finally {
            if (buf != null)
                buf.close();
        }
    }

    public static byte[] subByteArray(byte[] data, int s, int e) {
        if (s < 0) return null;
        if (e > data.length) return null;
        if (s >= e) return null;

        byte[] sub = new byte[e-s];
        System.arraycopy(data,s,sub,0,sub.length);
        return sub;
    }

    private static boolean checkSellBuyBan(String chkBan, String loc, String len, byte[] bytes) {
        String f_ban = ""; //�n�B�~�ˬd���νs
        int f_loc = 0; //�n�B�~���o���νs�}�l��m
        int f_len = 0; //�n�B�~���o���νs����
        if (!isNullorEmpty(chkBan) && !isNullorEmpty(loc) && !isNullorEmpty(len)) {
            if (numPattern.matcher(loc).matches() && numPattern.matcher(len).matches()) {
                f_loc = Integer.valueOf(loc);
                f_len = Integer.valueOf(len);
                f_ban = new String(subByteArray(bytes, f_loc, f_loc + f_len)).trim();
                if (!f_ban.equals(chkBan)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNullorEmpty(String str){
        if(str == null || str.trim().length() == 0) return true;
        return false;
    }


    public static String getHHmmss() {
        return getFormatDateTime("HHmmss");
    }

    public static String getFormatDateTime(String format) {
        //get date time stamp from system
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateTimeStamp = formatter.format(new java.util.Date());
        return dateTimeStamp;
    }

    private static int getMaxDefNum(String _mtype){
        int[] def = (int[])PubDef.get(_mtype);
        int max = def[0];
        for(int i=0; i<def.length ;i++){
            if (def[i] > max){
                max = def[i];
            }
        }
        return max;
    }

    /**
     * 2015.12.09
     * ���CHK_BUYER_BAN�PCHK_SELLER_BAN �P�_���νs���޿�
     * �ק�  by 6202
     */
    private static boolean chkOppBan(boolean isExporterBan, boolean hasOppBan, int[] _def, byte[] bytes, String _mtype, String[] _pub, String m_decltype){
        if (!isExporterBan && hasOppBan && _def.length >= 11) {
            String OppBan = new String(subByteArray(bytes, _def[9], _def[9] + _def[10])).trim();
            if (_mtype.equals("5105A")||_mtype.equals("5105S")||_mtype.equals("NX5105")){
                if (OppBan.equals(_pub[2]) && (("G2".equals(m_decltype) || "B6".equals(m_decltype)
                        || "B7".equals(m_decltype) || "D7".equals(m_decltype)))) {
                    isExporterBan = true; //�Y�R��νs���ŦX�A�h�i�欣�e
                }
            }
            else if (_mtype.equals("5203")||_mtype.equals("5203A")||_mtype.equals("N5203")){
                if (OppBan.equals(_pub[2]) && (("B1".equals(m_decltype) || "B2".equals(m_decltype)))) {
                    isExporterBan = true; //�Y���νs���ŦX�A�h�i�欣�e
                }
            }
        }
        return isExporterBan;
    }
}
