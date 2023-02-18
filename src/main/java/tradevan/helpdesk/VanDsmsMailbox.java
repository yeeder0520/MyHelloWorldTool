package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;
import org.apache.commons.collections.map.LinkedMap;

import java.io.Serializable;

public class VanDsmsMailbox extends DataObject implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 3701954429290898402L;
    public static final String TABLE_NAME ="VAN_DSMS_MAILBOX";
	public static final String PARTY_ID = "PARTY_ID";
    public static final String MESSAGE_ID = "MESSAGE_ID";
    public static final String MESSAGE_SUB_ID = "MESSAGE_SUB_ID";
    public static final String ACPT_DTS = "ACPT_DTS";
    public static final String DLVR_DTS = "DLVR_DTS";
    public static final String ACPTED_PARTY_ID = "ACPTED_PARTY_ID";
    public static final String SENDER_ID = "SENDER_ID";
    public static final String DLVRED_PARTY_ID = "DLVRED_PARTY_ID";
    public static final String RECEIVER_ID = "RECEIVER_ID";
    public static final String STATUS = "STATUS";
    public static final String FLOW_TYPE = "FLOW_TYPE";
    public static final String DOC_FORMAT = "DOC_FORMAT";
    public static final String DOC_TYPE_ID = "DOC_TYPE_ID";
    public static final String DOC_TYPE_SUB_ID = "DOC_TYPE_SUB_ID";
    public static final String MESSAGE_TYPE = "MESSAGE_TYPE";
    public static final String MESSAGE_SUB_TYPE = "MESSAGE_SUB_TYPE";
    public static final String CONTROL_NUMBER = "CONTROL_NUMBER";
    public static final String PARENT_MESSAGE_ID = "PARENT_MESSAGE_ID";
    public static final String PARENT_MESSAGE_SUB_ID = "PARENT_MESSAGE_SUB_ID";
    public static final String CHILD_MESSAGE_ID = "CHILD_MESSAGE_ID";
    public static final String CHILD_MESSAGE_SUB_ID = "CHILD_MESSAGE_SUB_ID";
    public static final String INSTRUCTION = "INSTRUCTION";
    public static final String FILE_NAME = "FILE_NAME";
    public static final String SERVICE_ID = "SERVICE_ID";
    public static final String ARG_ID = "ARG_ID";
    public static final String PROCESS_ID = "PROCESS_ID";
    public static final String CLI_FILE_NAME = "CLI_FILE_NAME";
    public static final String ORI_CHAR_COUNT = "ORI_CHAR_COUNT";
    public static final String UNZIP_FILE_SIZE = "UNZIP_FILE_SIZE";
    public static final String OUT_CHAR_COUNT = "OUT_CHAR_COUNT";
    public static final String VAS_SEQ_NO = "VAS_SEQ_NO";
    public static final String RTG_SEQ_NO = "RTG_SEQ_NO";
    public static final String RESENT_FLAG = "RESENT_FLAG";
    public static final String EXT_ARG_ID1 = "EXT_ARG_ID1";
    public static final String EXT_ARG_VAL1 = "EXT_ARG_VAL1";
    public static final String EXT_ARG_ID2 = "EXT_ARG_ID2";
    public static final String EXT_ARG_VAL2 = "EXT_ARG_VAL2";
    public static final String EXT_ARG_ID3 = "EXT_ARG_ID3";
    public static final String EXT_ARG_VAL3 = "EXT_ARG_VAL3";
    public static final String EXT_ARG_ID4 = "EXT_ARG_ID4";
    public static final String EXT_ARG_VAL4 = "EXT_ARG_VAL4";
    public static final String EXT_ARG_ID5 = "EXT_ARG_ID5";
    public static final String EXT_ARG_VAL5 = "EXT_ARG_VAL5";
    public static final String EXT_ARG_ID6 = "EXT_ARG_ID6";
    public static final String EXT_ARG_VAL6 = "EXT_ARG_VAL6";
    public static final String EXT_ARG_ID15 = "EXT_ARG_ID15";
    public static final String EXT_ARG_VAL15 = "EXT_ARG_VAL15";
    public boolean checked = false;
    public String BillingCode;
	public static final String SUM = "SUM";
    
    //for通關訊息狀態查詢
    public static final String PACKAGE_PRICE = "PACKAGE_PRICE";
    
    public VanDsmsMailbox() {
        super();
    }

    //判斷檔案大小
    public String getIsOverSize(){
    	//先拿Unzipfilesize如果沒有再拿Charactercount
    	String tmp = this.getUnzipFileSize();
    	if(tmp==null || tmp.isEmpty()) {
    		tmp = this.getOriCharCount();
    	}
    	if(tmp==null || tmp.isEmpty()){
    		tmp = this.getOutCharCount();
    	}
    	long size=0;
    	try{
    		size = Long.parseLong(tmp);
    	}catch(Exception e){
    	}
    	//若檔案大小大於20MB或是0則回傳Y
    	if(size > CommonConstant.MAX_SIZE || size==0) {
    		return "Y";
    	}else{
    		return "N";
    	}    	
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
    public void setExtArgId1(String extArgId1) {
        setValue(EXT_ARG_ID1, extArgId1);
    }

    /**
     * @return String - the EXT_ARG_ID1 field
     */ 
    public String getExtArgId1() {
        return getString(EXT_ARG_ID1);
    }

    /**
     * set EXT_ARG_VAL1
     * @param extArgVal1 - String
     */ 
    public void setExtArgVal1(String extArgVal1) {
        setValue(EXT_ARG_VAL1, extArgVal1);
    }

    /**
     * @return String - the EXT_ARG_VAL1 field
     */ 
    public String getExtArgVal1() {
        return getString(EXT_ARG_VAL1);
    }

    /**
     * set EXT_ARG_ID2
     * @param extArgId2 - String
     */ 
    public void setExtArgId2(String extArgId2) {
        setValue(EXT_ARG_ID2, extArgId2);
    }

    /**
     * @return String - the EXT_ARG_ID2 field
     */ 
    public String getExtArgId2() {
        return getString(EXT_ARG_ID2);
    }

    /**
     * set EXT_ARG_VAL2
     * @param extArgVal2 - String
     */ 
    public void setExtArgVal2(String extArgVal2) {
        setValue(EXT_ARG_VAL2, extArgVal2);
    }

    /**
     * @return String - the EXT_ARG_VAL2 field
     */ 
    public String getExtArgVal2() {
        return getString(EXT_ARG_VAL2);
    }

    /**
     * set EXT_ARG_ID3
     * @param extArgId3 - String
     */ 
    public void setExtArgId3(String extArgId3) {
        setValue(EXT_ARG_ID3, extArgId3);
    }

    /**
     * @return String - the EXT_ARG_ID3 field
     */ 
    public String getExtArgId3() {
        return getString(EXT_ARG_ID3);
    }

    /**
     * set EXT_ARG_VAL3
     * @param extArgVal3 - String
     */ 
    public void setExtArgVal3(String extArgVal3) {
        setValue(EXT_ARG_VAL3, extArgVal3);
    }

    /**
     * @return String - the EXT_ARG_VAL3 field
     */ 
    public String getExtArgVal3() {
        return getString(EXT_ARG_VAL3);
    }

    /**
     * set EXT_ARG_ID4
     * @param extArgId4 - String
     */ 
    public void setExtArgId4(String extArgId4) {
        setValue(EXT_ARG_ID4, extArgId4);
    }

    /**
     * @return String - the EXT_ARG_ID4 field
     */ 
    public String getExtArgId4() {
        return getString(EXT_ARG_ID4);
    }

    /**
     * set EXT_ARG_VAL4
     * @param extArgVal4 - String
     */ 
    public void setExtArgVal4(String extArgVal4) {
        setValue(EXT_ARG_VAL4, extArgVal4);
    }

    /**
     * @return String - the EXT_ARG_VAL4 field
     */ 
    public String getExtArgVal4() {
        return getString(EXT_ARG_VAL4);
    }

    /**
     * set EXT_ARG_ID5
     * @param extArgId5 - String
     */ 
    public void setExtArgId5(String extArgId5) {
        setValue(EXT_ARG_ID5, extArgId5);
    }

    /**
     * @return String - the EXT_ARG_ID5 field
     */ 
    public String getExtArgId5() {
        return getString(EXT_ARG_ID5);
    }

    /**
     * set EXT_ARG_VAL5
     * @param extArgVal5 - String
     */ 
    public void setExtArgVal5(String extArgVal5) {
        setValue(EXT_ARG_VAL5, extArgVal5);
    }

    /**
     * @return String - the EXT_ARG_VAL5 field
     */ 
    public String getExtArgVal5() {
        return getString(EXT_ARG_VAL5);
    }

    /**
     * set EXT_ARG_ID6
     * @param extArgId6 - String
     */ 
    public void setExtArgId6(String extArgId6) {
        setValue(EXT_ARG_ID6, extArgId6);
    }

    /**
     * @return String - the EXT_ARG_ID6 field
     */ 
    public String getExtArgId6() {
        return getString(EXT_ARG_ID6);
    }

    /**
     * set EXT_ARG_VAL6
     * @param extArgVal6 - String
     */ 
    public void setExtArgVal6(String extArgVal6) {
        setValue(EXT_ARG_VAL6, extArgVal6);
    }

    /**
     * @return String - the EXT_ARG_VAL6 field
     */ 
    public String getExtArgVal6() {
        return getString(EXT_ARG_VAL6);
    }

    /**
     * set EXT_ARG_ID15
     * @param extArgId15 - String
     */ 
    public void setExtArgId15(String extArgId15) {
        setValue(EXT_ARG_ID15, extArgId15);
    }

    /**
     * @return String - the EXT_ARG_ID15 field
     */ 
    public String getExtArgId15() {
        return getString(EXT_ARG_ID15);
    }

    /**
     * set EXT_ARG_VAL15
     * @param extArgVal15 - String
     */ 
    public void setExtArgVal15(String extArgVal15) {
        setValue(EXT_ARG_VAL15, extArgVal15);
    }

    /**
     * @return String - the EXT_ARG_VAL15 field
     */ 
    public String getExtArgVal15() {
        return getString(EXT_ARG_VAL15);
    }
    
    /**
     * set MESSAGE_ID
     * @param messageId - String
     */ 
    public void setMessageId(String messageId) {
        setValue(MESSAGE_ID, messageId);
    }

    /**
     * @return String - the MESSAGE_ID field
     */ 
    public String getMessageId() {
        return getString(MESSAGE_ID);
    }

    /**
     * set MESSAGE_SUB_ID
     * @param messageSubId - String
     */ 
    public void setMessageSubId(String messageSubId) {
        setValue(MESSAGE_SUB_ID, messageSubId);
    }

    /**
     * @return String - the MESSAGE_SUB_ID field
     */ 
    public String getMessageSubId() {
        return getString(MESSAGE_SUB_ID);
    }

    /**
     * set ACPT_DTS
     * @param acptDts - String
     */ 
    public void setAcptDts(String acptDts) {
        setValue(ACPT_DTS, acptDts);
    }

    /**
     * @return String - the ACPT_DTS field
     */ 
    public String getAcptDts() {
        return getString(ACPT_DTS);
    }

    /**
     * set DLVR_DTS
     * @param dlvrDts - String
     */ 
    public void setDlvrDts(String dlvrDts) {
        setValue(DLVR_DTS, dlvrDts);
    }

    /**
     * @return String - the DLVR_DTS field
     */ 
    public String getDlvrDts() {
        return getString(DLVR_DTS);
    }

    /**
     * set ACPTED_PARTY_ID
     * @param acptedPartyId - String
     */ 
    public void setAcptedPartyId(String acptedPartyId) {
        setValue(ACPTED_PARTY_ID, acptedPartyId);
    }

    /**
     * @return String - the ACPTED_PARTY_ID field
     */ 
    public String getAcptedPartyId() {
        return getString(ACPTED_PARTY_ID);
    }

    /**
     * set SENDER_ID
     * @param senderId - String
     */ 
    public void setSenderId(String senderId) {
        setValue(SENDER_ID, senderId);
    }

    /**
     * @return String - the SENDER_ID field
     */ 
    public String getSenderId() {
        return getString(SENDER_ID);
    }

    /**
     * set DLVRED_PARTY_ID
     * @param dlvredPartyId - String
     */ 
    public void setDlvredPartyId(String dlvredPartyId) {
        setValue(DLVRED_PARTY_ID, dlvredPartyId);
    }

    /**
     * @return String - the DLVRED_PARTY_ID field
     */ 
    public String getDlvredPartyId() {
        return getString(DLVRED_PARTY_ID);
    }

    /**
     * set RECEIVER_ID
     * @param receiverId - String
     */ 
    public void setReceiverId(String receiverId) {
        setValue(RECEIVER_ID, receiverId);
    }

    /**
     * @return String - the RECEIVER_ID field
     */ 
    public String getReceiverId() {
        return getString(RECEIVER_ID);
    }

    /**
     * set STATUS
     * @param status - String
     */ 
    public void setStatus(String status) {
        setValue(STATUS, status);
    }

    /**
     * @return String - the STATUS field
     */ 
    public String getStatus() {
        return getString(STATUS);
    }

    /**
     * set FLOW_TYPE
     * @param flowType - String
     */ 
    public void setFlowType(String flowType) {
        setValue(FLOW_TYPE, flowType);
    }

    /**
     * @return String - the FLOW_TYPE field
     */ 
    public String getFlowType() {
        return getString(FLOW_TYPE);
    }

    /**
     * set DOC_FORMAT
     * @param docFormat - String
     */ 
    public void setDocFormat(String docFormat) {
        setValue(DOC_FORMAT, docFormat);
    }

    /**
     * @return String - the DOC_FORMAT field
     */ 
    public String getDocFormat() {
        return getString(DOC_FORMAT);
    }

    /**
     * set DOC_TYPE_ID
     * @param docTypeId - String
     */ 
    public void setDocTypeId(String docTypeId) {
        setValue(DOC_TYPE_ID, docTypeId);
    }

    /**
     * @return String - the DOC_TYPE_ID field
     */ 
    public String getDocTypeId() {
        return getString(DOC_TYPE_ID);
    }

    /**
     * set DOC_TYPE_SUB_ID
     * @param docTypeSubId - String
     */ 
    public void setDocTypeSubId(String docTypeSubId) {
        setValue(DOC_TYPE_SUB_ID, docTypeSubId);
    }

    /**
     * @return String - the DOC_TYPE_SUB_ID field
     */ 
    public String getDocTypeSubId() {
        return getString(DOC_TYPE_SUB_ID);
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
     * set MESSAGE_SUB_TYPE
     * @param messageSubType - String
     */ 
    public void setMessageSubType(String messageSubType) {
        setValue(MESSAGE_SUB_TYPE, messageSubType);
    }

    /**
     * @return String - the MESSAGE_SUB_TYPE field
     */ 
    public String getMessageSubType() {
        return getString(MESSAGE_SUB_TYPE);
    }

    /**
     * set CONTROL_NUMBER
     * @param controlNumber - String
     */ 
    public void setControlNumber(String controlNumber) {
        setValue(CONTROL_NUMBER, controlNumber);
    }

    /**
     * @return String - the CONTROL_NUMBER field
     */ 
    public String getControlNumber() {
        return getString(CONTROL_NUMBER);
    }

    /**
     * set PARENT_MESSAGE_ID
     * @param parentMessageId - String
     */ 
    public void setParentMessageId(String parentMessageId) {
        setValue(PARENT_MESSAGE_ID, parentMessageId);
    }

    /**
     * @return String - the PARENT_MESSAGE_ID field
     */ 
    public String getParentMessageId() {
        return getString(PARENT_MESSAGE_ID);
    }

    /**
     * set PARENT_MESSAGE_SUB_ID
     * @param parentMessageSubId - String
     */ 
    public void setParentMessageSubId(String parentMessageSubId) {
        setValue(PARENT_MESSAGE_SUB_ID, parentMessageSubId);
    }

    /**
     * @return String - the PARENT_MESSAGE_SUB_ID field
     */ 
    public String getParentMessageSubId() {
        return getString(PARENT_MESSAGE_SUB_ID);
    }

    /**
     * set CHILD_MESSAGE_ID
     * @param childMessageId - String
     */ 
    public void setChildMessageId(String childMessageId) {
        setValue(CHILD_MESSAGE_ID, childMessageId);
    }

    /**
     * @return String - the CHILD_MESSAGE_ID field
     */ 
    public String getChildMessageId() {
        return getString(CHILD_MESSAGE_ID);
    }

    /**
     * set CHILD_MESSAGE_SUB_ID
     * @param childMessageSubId - String
     */ 
    public void setChildMessageSubId(String childMessageSubId) {
        setValue(CHILD_MESSAGE_SUB_ID, childMessageSubId);
    }

    /**
     * @return String - the CHILD_MESSAGE_SUB_ID field
     */ 
    public String getChildMessageSubId() {
        return getString(CHILD_MESSAGE_SUB_ID);
    }

    /**
     * set INSTRUCTION
     * @param instruction - String
     */ 
    public void setInstruction(String instruction) {
        setValue(INSTRUCTION, instruction);
    }

    /**
     * @return String - the INSTRUCTION field
     */ 
    public String getInstruction() {
        return getString(INSTRUCTION);
    }

    /**
     * set FILE_NAME
     * @param fileName - String
     */ 
    public void setFileName(String fileName) {
        setValue(FILE_NAME, fileName);
    }

    /**
     * @return String - the FILE_NAME field
     */ 
    public String getFileName() {
        return getString(FILE_NAME);
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
     * set CLI_FILE_NAME
     * @param cliFileName - String
     */ 
    public void setCliFileName(String cliFileName) {
        setValue(CLI_FILE_NAME, cliFileName);
    }

    /**
     * @return String - the CLI_FILE_NAME field
     */ 
    public String getCliFileName() {
        return getString(CLI_FILE_NAME);
    }

    /**
     * set ORI_CHAR_COUNT
     * @param oriCharCount - String
     */ 
    public void setOriCharCount(String oriCharCount) {
        setValue(ORI_CHAR_COUNT, oriCharCount);
    }

    /**
     * @return String - the ORI_CHAR_COUNT field
     */ 
    public String getOriCharCount() {
        return getString(ORI_CHAR_COUNT);
    }

    /**
     * set UNZIP_FILE_SIZE
     * @param unzipFileSize - String
     */ 
    public void setUnzipFileSize(String unzipFileSize) {
        setValue(UNZIP_FILE_SIZE, unzipFileSize);
    }

    /**
     * @return String - the UNZIP_FILE_SIZE field
     */ 
    public String getUnzipFileSize() {
        return getString(UNZIP_FILE_SIZE);
    }

    /**
     * set OUT_CHAR_COUNT
     * @param outCharCount - String
     */ 
    public void setOutCharCount(String outCharCount) {
        setValue(OUT_CHAR_COUNT, outCharCount);
    }

    /**
     * @return String - the OUT_CHAR_COUNT field
     */ 
    public String getOutCharCount() {
        return getString(OUT_CHAR_COUNT);
    }

    /**
     * set VAS_SEQ_NO
     * @param vasSeqNo - String
     */ 
    public void setVasSeqNo(String vasSeqNo) {
        setValue(VAS_SEQ_NO, vasSeqNo);
    }

    /**
     * @return String - the VAS_SEQ_NO field
     */ 
    public String getVasSeqNo() {
        return getString(VAS_SEQ_NO);
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
     * set RESENT_FLAG
     * @param resentFlag - String
     */ 
    public void setResentFlag(String resentFlag) {
        setValue(RESENT_FLAG, resentFlag);
    }

    /**
     * @return String - the RESENT_FLAG field
     */ 
    public String getResentFlag() {
        return getString(RESENT_FLAG);
    }
    
    public String getFormatAcptDts(){
        return DateTimeUtil.formatStr2DTS(getString(ACPT_DTS));
    }
    
    public String getFormatDlvrDts(){
        return DateTimeUtil.formatStr2DTS(getString(DLVR_DTS));
    }
    /**
     * get checked
     * @return
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * set checked
     * @param checked
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    public String getTransControlNum(){
        if(getString(CONTROL_NUMBER)==null){
            return getString(CONTROL_NUMBER);
        }
        return CommonLib.transHTMLCode(getString(CONTROL_NUMBER));
    }


	public String getBillingCode() {
		return BillingCode;
	}
	
	public void setBillingCode(String billingCode) {
		BillingCode = billingCode;
	}
	
	public String getPackagePrice() {
		return getString(PACKAGE_PRICE);
	}

	public void setPackagePrice(String packagePrice) {
		setValue(PACKAGE_PRICE , packagePrice);
	}
	
    public LinkedMap getIdValSet()
    {
    	LinkedMap map = new LinkedMap();
    	if(!CommonLib.isNullOrEmpty(getExtArgVal1()))
    	{
    		map.put(getExtArgId1(), getExtArgVal1());
    	}

    	if(!CommonLib.isNullOrEmpty(getExtArgVal2()))
    	{
    		map.put(getExtArgId2(), getExtArgVal2());
    	}
    	
    	if(!CommonLib.isNullOrEmpty(getExtArgVal3()))
    	{
    		map.put(getExtArgId3(), getExtArgVal3());
    	}

    	if(!CommonLib.isNullOrEmpty(getExtArgVal4()))
    	{
    		map.put(getExtArgId4(), getExtArgVal4());
    	}

    	if(!CommonLib.isNullOrEmpty(getExtArgVal5()))
    	{
    		map.put(getExtArgId5(), getExtArgVal5());
    	}

    	if(!CommonLib.isNullOrEmpty(getExtArgVal6()))
    	{
    		map.put(getExtArgId6(), getExtArgVal6());
    	}
    	
    	for (Object key : map.keySet()) {
    		String tmp = (String)map.get(key);
    		tmp = tmp.replaceAll(" ","&nbsp;");
    		map.put(key, tmp);
    	}
    	
    	return map;
    }
	public String getSum() {
		return getString(SUM);
	}

	public void setSum(String sum) {
		setValue(SUM , sum);
	}

    
}