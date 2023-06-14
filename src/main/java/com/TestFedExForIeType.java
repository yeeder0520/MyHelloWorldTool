package com;

import com.tradevan.commons.collection.DataObject;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.commons.collections.map.MultiKeyMap;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author YeeDer
 * @since 2023/2/8 下午 05:45
 **/
public class TestFedExForIeType {
    public static void main(String[] args) {
        MultiKeyMap rtnMap = new MultiKeyMap();
//      MultiKey[22099548, MXIC]
//      [[AR], [E], [DP], [E], [DL], [E], [PU], [E]]

//        rtnMap.put("22099548","MXIC",);

        TestFedExForIeType testAppdata = new TestFedExForIeType();

        List guiList = new ArrayList();
        DataObject dataObject = new DataObject();
        dataObject.setValue("GUI_NO", "123456");
        dataObject.setValue("GUI_ID", "ABCD");
        dataObject.setValue("IE_TYPE", "E");
        dataObject.setValue("STATUS", "111");
        guiList.add(dataObject);

        dataObject = new DataObject();
        dataObject.setValue("GUI_NO", "123456");
        dataObject.setValue("GUI_ID", "ABCD");
        dataObject.setValue("IE_TYPE", "E");
        dataObject.setValue("STATUS", "222");
        guiList.add(dataObject);

        dataObject = new DataObject();
        dataObject.setValue("GUI_NO", "22099548");
        dataObject.setValue("GUI_ID", "MXIC");
        dataObject.setValue("IE_TYPE", "E");
        dataObject.setValue("STATUS", "AR");
        guiList.add(dataObject);

        dataObject = new DataObject();
        dataObject.setValue("GUI_NO", "99991");
        dataObject.setValue("GUI_ID", "ZZZZXXXX");
        dataObject.setValue("IE_TYPE", "E");
        dataObject.setValue("STATUS", "ZZZ");
        guiList.add(dataObject);

        dataObject = new DataObject();
        dataObject.setValue("GUI_NO", "22099548");
        dataObject.setValue("GUI_ID", "MXIC");
        dataObject.setValue("IE_TYPE", "E");
        dataObject.setValue("STATUS", "DP");
        guiList.add(dataObject);

        dataObject = new DataObject();
        dataObject.setValue("GUI_NO", "22099548");
        dataObject.setValue("GUI_ID", "MXIC");
        dataObject.setValue("IE_TYPE", "E");
        dataObject.setValue("STATUS", "DL");
        guiList.add(dataObject);

        dataObject = new DataObject();
        dataObject.setValue("GUI_NO", "22099548");
        dataObject.setValue("GUI_ID", "MXIC");
        dataObject.setValue("IE_TYPE", "E");
        dataObject.setValue("STATUS", "PU");
        guiList.add(dataObject);

        dataObject = new DataObject();
        dataObject.setValue("GUI_NO", "123456");
        dataObject.setValue("GUI_ID", "ABCD");
        dataObject.setValue("IE_TYPE", "E");
        dataObject.setValue("STATUS", "333");
        guiList.add(dataObject);

        dataObject = new DataObject();
        dataObject.setValue("GUI_NO", "22099548");
        dataObject.setValue("GUI_ID", "MXIC");
        dataObject.setValue("IE_TYPE", "E");
        dataObject.setValue("STATUS", "PU");
        guiList.add(dataObject);

        MultiKeyMap customInformationMap = testAppdata.getCustomInformationMap(guiList);

        for (Object key : customInformationMap.keySet()) {
            System.out.println("ABC key = " + key + " | XYZ value = " + customInformationMap.get(key));
        }


        for (Object customInformationMapKeys : customInformationMap.keySet()) {

            MultiKey keys = (MultiKey) customInformationMapKeys;
            Object[] gui = keys.getKeys();
            String guiNo = String.valueOf(gui[0]);
            String guiId = String.valueOf(gui[1]);
            List<List<String>> customMapValue = (List<List<String>>) customInformationMap.get(guiNo, guiId);

            //貨主指定要處理的STATUS
            List<String> needStatus = customMapValue.get(0);

            //貨物進出口識別
            List<String> ieTypeList = customMapValue.get(1);
        }

    }

    private MultiKeyMap getCustomInformationMap(List guiList) {
        MultiKeyMap rtnMap = new MultiKeyMap();
        List<String> statusList;
        List<String> ieTypeList;
        List<List<String>> returnValueList;
        for (int i = 0; i < guiList.size(); i++) {
            DataObject guiInfo = (DataObject) guiList.get(i);
            String guiNo = guiInfo.getValue("GUI_NO") == null ? "" : (String) guiInfo.getValue("GUI_NO");
            String guiId = guiInfo.getValue("GUI_ID") == null ? "" : (String) guiInfo.getValue("GUI_ID");
            String status = guiInfo.getValue("STATUS") == null ? "" : (String) guiInfo.getValue("STATUS");
            String ieType = guiInfo.getValue("IE_TYPE") == null ? "" : (String) guiInfo.getValue("IE_TYPE");
            if (!rtnMap.containsKey(guiNo, guiId)) {
                returnValueList = new ArrayList<>();
                statusList = new ArrayList<>();
                statusList.add(status);
                ieTypeList = new ArrayList<>();
                ieTypeList.add(ieType);
                returnValueList.add(statusList);
                returnValueList.add(ieTypeList);
                rtnMap.put(guiNo, guiId, returnValueList);
            }else {
                returnValueList = (List<List<String>>) rtnMap.get(guiNo, guiId);
                returnValueList.get(0).add(status);
                returnValueList.get(1).add(ieType);
            }

        }
        return rtnMap;
    }

}
