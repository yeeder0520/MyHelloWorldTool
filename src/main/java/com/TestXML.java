package com;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class TestXML {
    public static void main(String[] args) throws Exception {
        /*初始化*/
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        /*參考下方的XML*/
        Document doc = docBuilder.parse(new File("src/main/java/com/transfer/test2.xml"));
        NodeList childNodes = doc.getChildNodes();
        System.out.println(childNodes.getLength());
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            System.out.println("bbb "+item.getNodeName());
            NodeList childNodes1 = item.getChildNodes();
            System.out.println("ccc "+childNodes1.item(i).getFirstChild());
            for (int j = 0; j <childNodes1.getLength() ; j++) {
                Node item1 = childNodes1.item(i);
                System.out.println("jjjj "+item1.getTextContent());
                System.out.println("kkkk "+item1.getNodeName());
            }
        }

    }




}
