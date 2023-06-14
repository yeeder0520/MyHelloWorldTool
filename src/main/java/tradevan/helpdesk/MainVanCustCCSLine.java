package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;

import java.io.Serializable;

/** 
 * @id:MainVanCustCCSLine.java
 * @function:CCS線路設定
 * @author:陳政佑
 * @date:2013/08/01
 */

public class MainVanCustCCSLine extends DataObject implements Serializable {

	private static final long serialVersionUID = -3598168024666564996L;
	public static final String ID = "ID";
    public static final String VIA_HUB_ID = "VIA_HUB_ID";
    public static final String SRC_OBJ_ID = "SRC_OBJ_ID";
    public static final String DES_OBJ_ID = "DES_OBJ_ID";
    public static final String OP_ID = "OP_ID";
    public static final String OP_DTS = "OP_DTS";
    
    //查詢顯示使用
    public static final String PARTY_ID = "PARTY_ID";
    public static final String ACTION_ID = "ACTION_ID";
    public static final String ARG_VALUE = "ARG_VALUE";
    public static final String RTG_SEQ_NO = "RTG_SEQ_NO";
    
    public MainVanCustCCSLine() {
        super();
    }

    /**
     * set ID
     * @param id - String
     */ 
    public void setId(String id) {
        setValue(ID, id);
    }

    /**
     * @return String - the ID field
     */ 
    public String getId() {
        return getString(ID);
    }

    /**
     * set ViaHubId
     * @param viaHubId - String
     */ 
    public void setViaHubId(String viaHubId) {
        setValue(VIA_HUB_ID, viaHubId);
    }

    /**
     * @return String - the ViaHubId field
     */ 
    public String getViaHubId() {
        return getString(VIA_HUB_ID);
    }

    /**
     * set SRC_OBJ_ID
     * @param issubdir - String
     */ 
    public void setSrcObjId(String srcObjId) {
        setValue(SRC_OBJ_ID, srcObjId);
    }

    /**
     * @return String - the SRC_OBJ_ID field
     */ 
    public String getSrcObjId() {
        return getString(SRC_OBJ_ID);
    }

    /**
     * set DES_OBJ_ID
     * @param issubdir - String
     */ 
    public void setDesObjId(String desObjId) {
        setValue(DES_OBJ_ID, desObjId);
    }

    /**
     * @return String - the DES_OBJ_ID field
     */ 
    public String getDesObjId() {
        return getString(DES_OBJ_ID);
    }

    /**
     *  set OP_ID
     * @param opId - String
     */ 
    public void setOpId(String opId) {
        setValue(OP_ID, opId);
    }
    
    /**
     * @return String - the OP_ID field
     */ 
    public String getOpId() {
		return getString(OP_ID);
	}
    
    /**
     * set OP_DTS
     * @param opDts - Date
     */ 
    public void setOpDts(String opDts) {
        setValue(OP_DTS, opDts);
    }

    /**
     * @return Date - the OP_DTS field
     */ 
    public String getOpDts() {
        return getString(OP_DTS);
    }
    
    /**
     * set PARTY_ID
     * @param partyId - String
     */ 
    public void setPartyId(String partyId) {
        setValue(PARTY_ID, partyId);
    }

    /**
     * @return String - the PARTY_ID field
     */ 
    public String getPartyId() {
        return getString(PARTY_ID);
    }
    
    /**
     * set ACTION_ID
     * @param issubdir - String
     */ 
    public void setActionId(String actionId) {
        setValue(ACTION_ID, actionId);
    }

    /**
     * @return String - the ACTION_ID field
     */ 
    public String getActionId() {
        return getString(ACTION_ID);
    }

    /**
     *  set ARG_VALUE
     * @param argValue - String
     */ 
    public void setArgValue(String argValue) {
        setValue(ARG_VALUE, argValue);
    }
    
    /**
     * @return String - the ARG_VALUE field
     */ 
    public String getArgValue() {
		return getString(ARG_VALUE);
	}
    
    /**
     *  set RTG_SEQ_NO
     * @param rtgSeqNo - String
     */ 
    public void setRtgSeqNo(String rtgSeqNo) {
        setValue(RTG_SEQ_NO, rtgSeqNo);
    }
    
    /**
     * @return String - the RTG_SEQ_NO field
     */ 
    public String getRtgSeqNo() {
		return getString(RTG_SEQ_NO);
	}
    

}