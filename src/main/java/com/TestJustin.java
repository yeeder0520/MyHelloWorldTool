package com;

import com.sun.org.apache.xpath.internal.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/9/1 上午 11:43
 **/
public class TestJustin {
    public static void main(String[] args) throws Exception {
        getXPathValue(Files.readAllBytes(Paths.get("C:\\Users\\6620\\Downloads\\20230107140406235\\N5204.MCJ1A6WHS001")));

    }


    public static void getXPathValue(byte[] payload) throws Exception {
        Map<String, String> argMap = new HashMap<>();
        argMap.put("AP_KEY6", "//node()[local-name()='Consignment']/node()[local-name()='TransportContractDocument']/node()[local-name()='ID']/text()");
        argMap.put("AP_KEY6_REF1", "TypeCode");
        argMap.put("AP_KEY6_REF_VALUE1", "703,714");

        List<String> valueList = new ArrayList<String>();
        // 有REF case 2: AP_KEY3_REF1, AP_KEY3_REF_VALUE1, AP_KEY3_REF2, AP_KEY3_REF_VALUE2 ...
        String key = "AP_KEY6";
        String keyRef = key + "_REF";// 取APKEY_REF
        String keyValue = key + "_REF_VALUE";// 取APKEY_VALUE
        NodeIterator nodeIterator = getXPathNodeIterator(payload, argMap.get(key));

        // 2016.06.28 6182 調整成 按Iterator處理
        Node node = null;
        while (nodeIterator != null && (node = nodeIterator.nextNode()) != null) {
            int cnt = 1;
            boolean isMatch = false;
            while (argMap.containsKey(keyRef + cnt) && argMap.containsKey(keyValue + cnt)) {
                String nodeName = argMap.get(keyRef + cnt);

                String[] refValueAry = argMap.get(keyValue + cnt).split(",");// 將取得字串分存成ArrayList
                ArrayList<String> refValueList = new ArrayList<String>();
                // 有查到提單號碼並查詢其值對照
                if (refValueAry != null && refValueAry.length > 0) {
                    for (int j = 0; j < refValueAry.length; j++) {
                        refValueList.add(refValueAry[j]);
                    }
                }
                if (nodeName.startsWith("//")) {
                    // 例如
                    // //node()[local-name()='Declaration']/node()[local-name()='tw_TransportTypeCode']/text()
                    // 只能for出現一次的欄位
                    isMatch = refValueList.contains(getXPathValue(payload, nodeName));
                } else {
                    // 往前後找參考 node
                    isMatch = isMatchRefCondition(node, nodeName, refValueList);
                }

                if (!isMatch) {
                    // 不符合條件，表示找不到該 APkey
                    break;
                } else {
                    ++cnt;
                }
            }
            if (isMatch) {// 2016.06.28 6182 改成判斷isMatch
                // 沒有下一個參考值，
                valueList.add(node.getNodeValue());
            }
        }
        System.out.println("valueList = " + valueList);
    }


    public static String getXPathValue(byte[] payload, String xpath) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(payload);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document rdf = null;
        try {
            rdf = factory.newDocumentBuilder().parse(bis);
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().contains("An invalid XML character")) {
                // 2014-06-06 6032 加入trim掉特殊字元
                String s = new String(payload);
                s = s.replaceAll("\\p{Cc}", "");
                byte[] temp = s.getBytes();
                bis = new ByteArrayInputStream(temp);
                rdf = factory.newDocumentBuilder().parse(bis);
            }
        }
        if (XPathAPI.selectSingleNode(rdf, xpath) == null)
            return null;
        else {
            Node node = XPathAPI.selectSingleNode(rdf, xpath);
            if (node.getNodeValue() == null)
                return null;
            return node.getNodeValue().trim();
        }
    }
    public static NodeIterator getXPathNodeIterator(byte[] payload, String xpath) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(payload);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document rdf = null;
        try {
            rdf = factory.newDocumentBuilder().parse(bis);
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().contains("An invalid XML character")) {
                // 2014-06-06 6032 加入trim掉特殊字元
                String s = new String(payload);
                s = s.replaceAll("\\p{Cc}", "");
                byte[] temp = s.getBytes();
                bis = new ByteArrayInputStream(temp);
                rdf = factory.newDocumentBuilder().parse(bis);
            }
        }
        if (XPathAPI.selectSingleNode(rdf, xpath) == null)
            return null;
        else {
            NodeIterator iterator = XPathAPI.selectNodeIterator(rdf, xpath);
            return iterator;
        }
    }

    public static boolean isMatchRefCondition(Node node, String id, List<String> condNodeValue) throws Exception {
        if (node == null || node.getNodeValue() == null) {
            return false;
        }

        // 往前找不到就找後面
        Node sNode = getPreviousSibling(node.getParentNode(), id);
        if (sNode == null) {
            sNode = getNextSibling(node.getParentNode(), id);
        }

        if (sNode != null) {
            if (sNode.getFirstChild() != null)
                if (condNodeValue.contains(sNode.getFirstChild().getNodeValue())) {
                    return true;
                }
        }
        return false;
    }

    public static Node getPreviousSibling(Node node, String key) {
        if (node.getPreviousSibling() != null) {
            if (key.equals(node.getPreviousSibling().getNodeName())) {
                return node.getPreviousSibling();
            } else {
                return getPreviousSibling(node.getPreviousSibling(), key);
            }
        }
        return null;
    }

    public static Node getNextSibling(Node node, String key) {
        if (node.getNextSibling() != null) {
            if (key.equals(node.getNextSibling().getNodeName())) {
                return node.getNextSibling();
            } else {
                return getNextSibling(node.getNextSibling(), key);
            }
        }
        return null;
    }
}

