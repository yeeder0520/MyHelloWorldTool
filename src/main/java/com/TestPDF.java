package com;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.ReaderProperties;

import java.io.FileOutputStream;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2023/1/13 下午 03:13
 **/
public class TestPDF {
    public static void main(String[] args) {
        String src = "C:\\Users\\6620\\Downloads\\國泰世華電子存摺.pdf";
        String dest = "C:\\Users\\6620\\Downloads\\123.pdf";
        String password = "L124857529";
        try {
            PdfReader reader = new PdfReader(src, new ReaderProperties().setPassword(password.getBytes()));
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(reader, writer);
            pdfDoc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
