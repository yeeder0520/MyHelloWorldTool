package com;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

/**
 * @author YeeDer
 * @since 2023/5/5 PM 01:51
 **/
public class TestBouncycastle {
    public static void main(String[] args) {
        // 載入 BC Provider
        Security.addProvider(new BouncyCastleProvider());
        TestBouncycastle testBouncycastle = new TestBouncycastle();
        testBouncycastle.generatePrivateKey();
    }

    /**
     * 將憑證鏈存入作業系統
     */
    public void saveCertToSystem() {
        try {
            // 打開 Windows 憑證存儲區
            KeyStore ks = KeyStore.getInstance("Windows-MY");
            ks.load(null, null);
            List<String> aliasList = Collections.list(ks.aliases());
            System.out.println("size() = " + aliasList.size());
            // 取得所有憑證的別名
            for (String alias : aliasList) {
                // 根據別名取得該憑證
                Certificate cert = ks.getCertificate(alias);
                // 判斷該憑證是否為X509憑證
                if (cert instanceof X509Certificate) {
                    // 將憑證強制轉型為X509Certificate物件
                    X509Certificate x509Cert = (X509Certificate) cert;
                    // 輸出憑證的資訊
                    System.out.println("Alias: " + alias);
                    System.out.println("Expiration Date: " + x509Cert.getNotAfter());
                    System.out.println("============================");
                }
            }

            // 讀取憑證
            InputStream certStream = Files.newInputStream(Paths.get("src/main/java/com/testfile/12763925_26_000.cer"));
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(certStream);

            // 將憑證註冊到存儲區中
            ks.setCertificateEntry(cert.getSubjectDN().getName(), cert);

            // 儲存存儲區
            ks.store(null, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 產生CSR
     */
    public void generateCSR() {
        try {
            // 產生RSA金鑰對
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
            kpGen.initialize(2048);
            KeyPair keyPair = kpGen.generateKeyPair();

            // 加入 Extensions
            ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
            // 新增 Authority Key Identifier Extension
            byte[] authorityKeyIdentifier = new byte[0]; // 設定 Authority Key Identifier
            extensionsGenerator.addExtension(Extension.authorityKeyIdentifier, false, authorityKeyIdentifier);

            // 新增 Subject Key Identifier Extension
            byte[] subjectKeyIdentifier = new byte[0]; // 設定 Subject Key Identifier
            extensionsGenerator.addExtension(Extension.subjectKeyIdentifier, false, subjectKeyIdentifier);

            // 新增 Basic Constraints Extension
            BasicConstraints basicConstraints = new BasicConstraints(true);
            extensionsGenerator.addExtension(Extension.basicConstraints, true, basicConstraints.getEncoded());

            // 新增 Key Usage Extension
            KeyUsage keyUsage = new KeyUsage(KeyUsage.keyCertSign | KeyUsage.cRLSign | KeyUsage.keyEncipherment);
            extensionsGenerator.addExtension(Extension.keyUsage, true, keyUsage.getEncoded());

            Extensions extensions = extensionsGenerator.generate();

            // 產生CSR
            JcaPKCS10CertificationRequestBuilder csrBuilder = new JcaPKCS10CertificationRequestBuilder(
                    new X500Name("CN=12763925-26-000,OU=TST,OU=97162640-RA-INFO168,OU=Chunghwa Telecom Information Public CA,O=Information,C=TW"),
                    keyPair.getPublic()
            );

            // Set the extensions on the builder
            csrBuilder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, extensions);

            ContentSigner csrContentSigner = new JcaContentSignerBuilder("SHA256withRSA").build(keyPair.getPrivate());
            PKCS10CertificationRequest csr = csrBuilder.build(csrContentSigner);


            // Save the CSR to a file
            try (OutputStream out = Files.newOutputStream(Paths.get("src/main/java/com/testfile/csr.pem"))) {
                out.write(csr.getEncoded());
            }
        } catch (NoSuchAlgorithmException | OperatorCreationException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 產生私鑰
     */
    public void generatePrivateKey(){
        try {
            // 產生一對 RSA 金鑰
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // 取得私鑰
            PrivateKey privateKey = keyPair.getPrivate();

            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            try (OutputStream out = Files.newOutputStream(Paths.get("src/main/java/com/testfile/private.pem"))) {
                out.write(pkcs8EncodedKeySpec.getEncoded());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


