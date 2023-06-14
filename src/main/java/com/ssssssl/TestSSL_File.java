package com.ssssssl;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;

/**
 * @author YeeDer
 * @since 2023/2/18 下午 05:37
 **/
public class TestSSL_File {
    private static final String KEYSTORE_FILE = "C:\\Users\\6620\\AppData\\Roaming\\tradevan\\SB628008\\Auth_SB628008.pfx";
    private static final String KEYSTORE_PASSWORD = "111111";
    private static final String KEY_PASSWORD = "111111";

    public static void main(String[] args) throws Exception {
        // 載入 pfx 憑證檔案
        KeyStore pfx = KeyStore.getInstance("pkcs12");
        FileInputStream fis = new FileInputStream(KEYSTORE_FILE);
        pfx.load(fis, KEYSTORE_PASSWORD.toCharArray());

        // 取得憑證的私鑰
        String alias = pfx.aliases().nextElement();
        PrivateKey privateKey = (PrivateKey) pfx.getKey(alias, KEY_PASSWORD.toCharArray());

        // 建立簽章物件
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);

        // 簽章
        byte[] data = "Hello, World!".getBytes();
        signature.update(data);
        byte[] sign = signature.sign();

        // 印出簽章值
        System.out.println("Signature Value: " + bytesToHex(sign));
    }

    // 將 byte[] 轉成十六進位字串
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
