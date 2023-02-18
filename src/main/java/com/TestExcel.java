package com;

import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2023/1/13 下午 03:46
 **/
public class TestExcel {
    public static void main(String[] args) throws Exception {
        String src = "password_protected.xlsx";
        String dest = "decrypted.xlsx";
        String password = "password";

        FileInputStream fis = new FileInputStream(src);
        POIFSFileSystem fs = new POIFSFileSystem(fis);
        EncryptionInfo info = new EncryptionInfo(fs);
        Decryptor d = Decryptor.getInstance(info);
        d.verifyPassword(password);
    }
}
