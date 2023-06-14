package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;

import java.io.Serializable;

public class VanServiceRoutingExt extends DataObject implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3356517761941866034L;
	public static final String TABLE_NAME ="VAN_SERVICE_ROUTING_EXT";
	public static final String RTG_SEQ_NO = "RTG_SEQ_NO";
    public static final String OBJECT_ID = "OBJECT_ID";
    public static final String ARG_ID = "ARG_ID";
    public static final String ARG_VALUE = "ARG_VALUE";
    public static final String NOTE1 = "NOTE1";
    public static final String CT_ID = "CT_ID";
    public static final String CT_DTS = "CT_DTS";
    public static final String OP_ID = "OP_ID";
    public static final String OP_DTS = "OP_DTS";

    public VanServiceRoutingExt() {
        super();
    }


    /**
     * set RTG_SEQ_NO
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

    /**
     * set OBJECT_ID
     * @param objectId - String
     */ 
    public void setObjectId(String objectId) {
        setValue(OBJECT_ID, objectId);
    }

    /**
     * @return String - the OBJECT_ID field
     */ 
    public String getObjectId() {
        return getString(OBJECT_ID);
    }

    /**
     * set ARG_ID
     * @param argId - String
     */ 
    public void setArgId(String argId) {
        setValue(ARG_ID, argId);
    }

    /**
     * @return String - the ARG_ID field
     */ 
    public String getArgId() {
        return getString(ARG_ID);
    }

    /**
     * set ARG_VALUE
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
     * set NOTE1
     * @param note1 - String
     */ 
    public void setNote1(String note1) {
        setValue(NOTE1, note1);
    }

    /**
     * @return String - the NOTE1 field
     */ 
    public String getNote1() {
        return getString(NOTE1);
    }

    /**
     * set CT_ID
     * @param ctId - String
     */ 
    public void setCtId(String ctId) {
        setValue(CT_ID, ctId);
    }

    /**
     * @return String - the CT_ID field
     */ 
    public String getCtId() {
        return getString(CT_ID);
    }

    /**
     * set CT_DTS
     * @param ctDts - String
     */ 
    public void setCtDts(String ctDts) {
        setValue(CT_DTS, ctDts);
    }

    /**
     * @return String - the CT_DTS field
     */ 
    public String getCtDts() {
        return getString(CT_DTS);
    }

    /**
     * set OP_ID
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
     * @param opDts - String
     */ 
    public void setOpDts(String opDts) {
        setValue(OP_DTS, opDts);
    }

    /**
     * @return String - the OP_DTS field
     */ 
    public String getOpDts() {
        return getString(OP_DTS);
    }

}