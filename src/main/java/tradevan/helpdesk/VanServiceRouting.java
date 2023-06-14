package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;

import java.io.Serializable;

public class VanServiceRouting extends DataObject implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8254523900934320748L;
	public static final String TABLE_NAME ="VAN_SERVICE_ROUTING";
	public static final String RTG_SEQ_NO = "RTG_SEQ_NO";
    public static final String PARTY_ID = "PARTY_ID";
    public static final String PARTY_ID_TYPE = "PARTY_ID_TYPE";
    public static final String PROCESS_ID = "PROCESS_ID";
    public static final String STEP = "STEP";
    public static final String PARTNER_ID = "PARTNER_ID";
    public static final String PARTNER_ENABLED = "PARTNER_ENABLED";
    public static final String MESSAGE_TYPE = "MESSAGE_TYPE";
    public static final String MESSAGE_VERSION = "MESSAGE_VERSION";
    public static final String MESSAGE_FORMAT = "MESSAGE_FORMAT";
    public static final String SERVICE_ID = "SERVICE_ID";
    public static final String ACTION_ID = "ACTION_ID";
    public static final String CONN_SRC_ID = "CONN_SRC_ID";
    public static final String CONN_DES_ID = "CONN_DES_ID";
    public static final String ENABLED = "ENABLED";
    public static final String BILLING_CODE = "BILLING_CODE";
    public static final String ACK_MARK = "ACK_MARK";
    public static final String NOTE1 = "NOTE1";
    public static final String CT_ID = "CT_ID";
    public static final String CT_DTS = "CT_DTS";
    public static final String OP_ID = "OP_ID";
    public static final String OP_DTS = "OP_DTS";
    public static final String SRC_SYS_TYPE = "SRC_SYS_TYPE";

    public VanServiceRouting() {
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
     * set PARTY_ID_TYPE
     * @param partyIdType - String
     */ 
    public void setPartyIdType(String partyIdType) {
        setValue(PARTY_ID_TYPE, partyIdType);
    }

    /**
     * @return String - the PARTY_ID_TYPE field
     */ 
    public String getPartyIdType() {
        return getString(PARTY_ID_TYPE);
    }

    /**
     * set PROCESS_ID
     * @param processId - String
     */ 
    public void setProcessId(String processId) {
        setValue(PROCESS_ID, processId);
    }

    /**
     * @return String - the PROCESS_ID field
     */ 
    public String getProcessId() {
        return getString(PROCESS_ID);
    }

    /**
     * set STEP
     * @param step - String
     */ 
    public void setStep(String step) {
        setValue(STEP, step);
    }

    /**
     * @return String - the STEP field
     */ 
    public String getStep() {
        return getString(STEP);
    }

    /**
     * set PARTNER_ID
     * @param partnerId - String
     */ 
    public void setPartnerId(String partnerId) {
        setValue(PARTNER_ID, partnerId);
    }

    /**
     * @return String - the PARTNER_ID field
     */ 
    public String getPartnerId() {
        return getString(PARTNER_ID);
    }

    /**
     * set PARTNER_ENABLED
     * @param partnerEnabled - String
     */ 
    public void setPartnerEnabled(String partnerEnabled) {
        setValue(PARTNER_ENABLED, partnerEnabled);
    }

    /**
     * @return String - the PARTNER_ENABLED field
     */ 
    public String getPartnerEnabled() {
        return getString(PARTNER_ENABLED);
    }

    /**
     * set MESSAGE_TYPE
     * @param messageType - String
     */ 
    public void setMessageType(String messageType) {
        setValue(MESSAGE_TYPE, messageType);
    }

    /**
     * @return String - the MESSAGE_TYPE field
     */ 
    public String getMessageType() {
        return getString(MESSAGE_TYPE);
    }

    /**
     * set MESSAGE_VERSION
     * @param messageVersion - String
     */ 
    public void setMessageVersion(String messageVersion) {
        setValue(MESSAGE_VERSION, messageVersion);
    }

    /**
     * @return String - the MESSAGE_VERSION field
     */ 
    public String getMessageVersion() {
        return getString(MESSAGE_VERSION);
    }

    /**
     * set MESSAGE_FORMAT
     * @param messageFormat - String
     */ 
    public void setMessageFormat(String messageFormat) {
        setValue(MESSAGE_FORMAT, messageFormat);
    }

    /**
     * @return String - the MESSAGE_FORMAT field
     */ 
    public String getMessageFormat() {
        return getString(MESSAGE_FORMAT);
    }

    /**
     * set SERVICE_ID
     * @param serviceId - String
     */ 
    public void setServiceId(String serviceId) {
        setValue(SERVICE_ID, serviceId);
    }

    /**
     * @return String - the SERVICE_ID field
     */ 
    public String getServiceId() {
        return getString(SERVICE_ID);
    }

    /**
     * set ACTION_ID
     * @param actionId - String
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
     * set CONN_SRC_ID
     * @param connSrcId - String
     */ 
    public void setConnSrcId(String connSrcId) {
        setValue(CONN_SRC_ID, connSrcId);
    }

    /**
     * @return String - the CONN_SRC_ID field
     */ 
    public String getConnSrcId() {
        return getString(CONN_SRC_ID);
    }

    /**
     * set CONN_DES_ID
     * @param connDesId - String
     */ 
    public void setConnDesId(String connDesId) {
        setValue(CONN_DES_ID, connDesId);
    }

    /**
     * @return String - the CONN_DES_ID field
     */ 
    public String getConnDesId() {
        return getString(CONN_DES_ID);
    }

    /**
     * set ENABLED
     * @param enabled - String
     */ 
    public void setEnabled(String enabled) {
        setValue(ENABLED, enabled);
    }

    /**
     * @return String - the ENABLED field
     */ 
    public String getEnabled() {
        return getString(ENABLED);
    }

    /**
     * set BILLING_CODE
     * @param billingCode - String
     */ 
    public void setBillingCode(String billingCode) {
        setValue(BILLING_CODE, billingCode);
    }

    /**
     * @return String - the BILLING_CODE field
     */ 
    public String getBillingCode() {
        return getString(BILLING_CODE);
    }

    /**
     * set ACK_MARK
     * @param ackMark - String
     */ 
    public void setAckMark(String ackMark) {
        setValue(ACK_MARK, ackMark);
    }

    /**
     * @return String - the ACK_MARK field
     */ 
    public String getAckMark() {
        return getString(ACK_MARK);
    }
    

    /**
     * set ACK_MARK
     * @param ackMark - boolean
     */ 
    public void setBooleanAckMark(boolean ackMark) {
    	if (ackMark)
    		setValue(ACK_MARK, "Y");
    	else
    		setValue(ACK_MARK, "N");
    }

    /**
     * @return boolean - the ACK_MARK field
     */ 
    public boolean getBooleanAckMark() {
    	if (CommonLib.isNullOrEmpty(getString(ACK_MARK)))
    		return false;
    	else if ("N".equals(getString(ACK_MARK)))
    		return false;
    	else
    		return true;
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

    /**
     * set SRC_SYS_TYPE
     * @param opDts - String
     */ 
    public void setSrcSysType(String srcSysType) {
        setValue(SRC_SYS_TYPE, srcSysType);
    }

    /**
     * @return String - the SRC_SYS_TYPE field
     */ 
    public String getSrcSysType() {
        return getString(SRC_SYS_TYPE);
    }

}