import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2021/7/23 �W�� 11:18
 **/
public class TestParser {


    private static String getSubBig5(String msg, int len) {
        byte[] msgBig5Byte = null;
        try {
            msgBig5Byte = msg.getBytes("Big5");
        } catch (UnsupportedEncodingException e) {
            msgBig5Byte = msg.getBytes();
        }
        final int subLen = len + 1; // �h���@��byte
        if ((msgBig5Byte.length) >= subLen) {
            // ��big5����
            byte[] tmpBig5Mag = new byte[subLen];
            System.arraycopy(msgBig5Byte, 0, tmpBig5Mag, 0, subLen);

            String tmpMsg = "";
            try {
                tmpMsg = new String(tmpBig5Mag, "Big5");
            } catch (UnsupportedEncodingException e) {
                tmpMsg = new String(tmpBig5Mag);
            }
            tmpMsg = tmpMsg.substring(0, tmpMsg.length() - 1); // �����h�����r
            msg = tmpMsg;
        }
        return msg;
    }


    public static void main(String[] args) throws Exception {

//        String getGoodsDesc1 = "'SBF3-ANTIMONY TRIFLUORIDE MAKE";
        String getGoodsDesc1 = "SBF3-ANTIMONY TRIFLUORIDE MAKE        ����";
        String getGoodsDesc2 = "R                             ";
        String getGoodsDesc3 = ":ALFA AES                     ";
        String getGoodsDesc4 = "IMP.0000180518-01-00001       ";
        String getGoodsDesc5 = "PO.0002341312-UPL1ZZF         ";
        String getGoodsDesc6 = "INV.OD406289                  ";
        String getGoodsDesc7 = "";
        String getGoodsDesc8 = "";
        String getGoodsDesc9 = "";
        String getGoodsDesc10 = "";
        String getGoodsDesc11 = "";
        String getGoodsDesc12 = "";
        String getGoodsDesc13 = "";


        List<String> allGoodsDesc = handleGoodsDesc(placeOutOfLine(getGoodsDesc1)
                + placeOutOfLine(getGoodsDesc2) + placeOutOfLine(getGoodsDesc3)
                + placeOutOfLine(getGoodsDesc4) + placeOutOfLine(getGoodsDesc5)
                + placeOutOfLine(getGoodsDesc6) + placeOutOfLine(getGoodsDesc7)
                + placeOutOfLine(getGoodsDesc8) + placeOutOfLine(getGoodsDesc9)
                + placeOutOfLine(getGoodsDesc10) + placeOutOfLine(getGoodsDesc11)
                + placeOutOfLine(getGoodsDesc12) + placeOutOfLine(getGoodsDesc13));

        for (String s : allGoodsDesc) {
            System.out.println("���G =" + s);
        }

    }

    /**
     * @param goodsDesc
     * @return
     * @throws Exception
     */
    private static String placeOutOfLine(String goodsDesc) throws Exception {
        if (goodsDesc.getBytes().length > 40) {
            return padRightSpace(goodsDesc, 80);
        }
        return padRightSpace(goodsDesc, 40);
    }

    /**
     * @param allGoodsDesc
     * @return
     */
    private static List<String> handleGoodsDesc(String allGoodsDesc) {
        List<String> goodsDescList = new ArrayList();
        String borrowing = ""; // �ɦ�
        int padLength = 40;
        for (int i = 0; i < 13; i++) {
            String tmp = getSubBig5(allGoodsDesc, 40, "msg950");
            System.out.println("���� :" + tmp.length());
            allGoodsDesc = allGoodsDesc.substring(tmp.length());
            goodsDescList.add(tmp);
        }
        if (allGoodsDesc.length() > (padLength * 13)) {
            borrowing = allGoodsDesc.substring(padLength * 13, allGoodsDesc.length());
            goodsDescList.add(borrowing);
        } else {
            goodsDescList.add("");
        }
        return goodsDescList;
    }

    protected static String padRightSpace(String str, int reallength) throws Exception {
        str = getSubMsg(str, reallength);
        if (str.getBytes().length < reallength) {
            StringBuffer buff = new StringBuffer(str);
            while (str.getBytes().length < reallength) {
                str = buff.toString();
                buff.append(" ");
            }
        } else if (str.getBytes().length == reallength) {
        } else {
            //str = str.substring(0, reallength);
            str = new String(subByteArray(str.getBytes(),0,reallength));
        }
        return str;
    }

    /**
     * �N�T�����Φ����w������
     * �]Big5�e���byte�A�ҥH���h��1��byte�A�̫�A��h�����r��subString��
     * @param msg �n���Ϊ��T��
     * @param msg �n���Ϊ��T��
     * @return
     */
    public static String getSubMsg(String msg, int reallength) {
        if (msg == null)
            return "";
        String msgField = msg;
        byte[] msgBig5Byte = msg.getBytes();
        int cnt = 0;
        final int subLen = reallength + 1; // �h���@��byte
        if ((msgBig5Byte.length - cnt) >= subLen) {
            // ��big5����
            byte[] tmpBig5Mag = new byte[subLen];
            System.arraycopy(msgBig5Byte, cnt, tmpBig5Mag, 0, subLen);

            String tmpMsg = new String(tmpBig5Mag);
            tmpMsg = tmpMsg.substring(0, tmpMsg.length()-1); // �����h�����r
            msgField = tmpMsg;
            cnt += tmpMsg.getBytes().length;
        }
        return msgField;
    }

    public static byte[] subByteArray(byte[] data, int s, int e) {
        if (s < 0) return null;
        if (e > data.length) return null;
        if (s >= e) return null;

        byte[] sub = new byte[e-s];
        System.arraycopy(data,s,sub,0,sub.length);
        return sub;
    }


    private static String getSubBig5(String msg, int len, String encoding) {
        byte[] msgBig5Byte = null;
        try {
            msgBig5Byte = msg.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            msgBig5Byte = msg.getBytes();
        }
        final int subLen = len + 1; // �h���@��byte
        if ((msgBig5Byte.length) >= subLen) {
            // ��big5����
            byte[] tmpBig5Mag = new byte[subLen];
            System.arraycopy(msgBig5Byte, 0, tmpBig5Mag, 0, subLen);
            String tmpMsg = "";
            try {
                tmpMsg = new String(tmpBig5Mag, encoding);
            } catch (UnsupportedEncodingException e) {
                tmpMsg = new String(tmpBig5Mag);
            }
            tmpMsg = tmpMsg.substring(0, tmpMsg.length() - 1); // �����h�����r
            msg = tmpMsg;
        }
        return msg;
    }
}
