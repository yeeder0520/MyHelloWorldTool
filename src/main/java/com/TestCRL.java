package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.cert.CRL;
import java.security.cert.CertificateFactory;

public class TestCRL {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\6620\\Desktop\\MOEACA1.crl");
        CRL x509 = CertificateFactory.getInstance("X509").generateCRL(fis);
        System.out.println(x509.toString());
    }
}
