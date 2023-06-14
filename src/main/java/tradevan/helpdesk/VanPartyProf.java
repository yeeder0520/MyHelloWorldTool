package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;

import java.io.Serializable;

public class VanPartyProf extends DataObject implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 107943662572976904L;
	public static final String TABLE_NAME ="VAN_PARTY_PROF";
	public static final String PARTY_ID = "PARTY_ID";
    public static final String COMPANY_ID = "COMPANY_ID";
    public static final String PARTY_CNAME = "PARTY_CNAME";
    public static final String PARTY_ENAME = "PARTY_ENAME";
    public static final String PARTY_TYPE = "PARTY_TYPE";
    public static final String PARTY_SUB_TYPE = "PARTY_SUB_TYPE";
    public static final String PARTY_STATUS = "PARTY_STATUS";
    public static final String ACCEPT_CONN_ID = "ACCEPT_CONN_ID";
    public static final String ACCEPT_CONN_TYPE = "ACCEPT_CONN_TYPE";
    public static final String ACCEPT_TYPE = "ACCEPT_TYPE";
    public static final String DELIVER_CONN_ID = "DELIVER_CONN_ID";
    public static final String DELIVER_CONN_TYPE = "DELIVER_CONN_TYPE";
    public static final String DELIVER_TYPE = "DELIVER_TYPE";
    public static final String PAY_FLAG = "PAY_FLAG";
    public static final String BILLING_ID = "BILLING_ID";
    public static final String BIL_REPLACE_FLAG = "BIL_REPLACE_FLAG";
    public static final String ARCHIVE_FLAG = "ARCHIVE_FLAG";
    public static final String PROTOCOL_TYPE = "PROTOCOL_TYPE";
    public static final String CUST = "CUST";
    public static final String BOX_NO = "BOX_NO";
    public static final String PAD_FLAG = "PAD_FLAG";
    public static final String NOTE1 = "NOTE1";
    public static final String NOTE2 = "NOTE2";
    public static final String COST_ID = "COST_ID";
    public static final String CT_ID = "CT_ID";
    public static final String CT_DTS = "CT_DTS";
    public static final String OP_ID = "OP_ID";
    public static final String OP_DTS = "OP_DTS";
    public static final String MAX_CONNECTIONS = "MAX_CONNECTIONS";
    public static final String ACTIVE_CONNECTIONS = "ACTIVE_CONNECTIONS";
    public static final String MAX_MESSAGES = "MAX_MESSAGES";

    private boolean checked = false;
    
    public VanPartyProf() {
        super();
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
     * set COMPANY_ID
     * @param companyId - String
     */ 
    public void setCompanyId(String companyId) {
        setValue(COMPANY_ID, companyId);
    }

    /**
     * @return String - the COMPANY_ID field
     */ 
    public String getCompanyId() {
        return getString(COMPANY_ID);
    }

    /**
     * set PARTY_CNAME
     * @param partyCname - String
     */ 
    public void setPartyCname(String partyCname) {
        setValue(PARTY_CNAME, partyCname);
    }

    /**
     * @return String - the PARTY_CNAME field
     */ 
    public String getPartyCname() {
        return getString(PARTY_CNAME);
    }

    /**
     * set PARTY_ENAME
     * @param partyEname - String
     */ 
    public void setPartyEname(String partyEname) {
        setValue(PARTY_ENAME, partyEname);
    }

    /**
     * @return String - the PARTY_ENAME field
     */ 
    public String getPartyEname() {
        return getString(PARTY_ENAME);
    }

    /**
     * set PARTY_TYPE
     * @param partyType - String
     */ 
    public void setPartyType(String partyType) {
        setValue(PARTY_TYPE, partyType);
    }

    /**
     * @return String - the PARTY_TYPE field
     */ 
    public String getPartyType() {
        return getString(PARTY_TYPE);
    }

    /**
     * set PARTY_SUB_TYPE
     * @param partySubType - String
     */ 
    public void setPartySubType(String partySubType) {
        setValue(PARTY_SUB_TYPE, partySubType);
    }

    /**
     * @return String - the PARTY_SUB_TYPE field
     */ 
    public String getPartySubType() {
        return getString(PARTY_SUB_TYPE);
    }

    /**
     * set PARTY_STATUS
     * @param partyStatus - String
     */ 
    public void setPartyStatus(String partyStatus) {
        setValue(PARTY_STATUS, partyStatus);
    }

    /**
     * @return String - the PARTY_STATUS field
     */ 
    public String getPartyStatus() {
        return getString(PARTY_STATUS);
    }

    /**
     * set ACCEPT_CONN_ID
     * @param acceptConnId - String
     */ 
    public void setAcceptConnId(String acceptConnId) {
        setValue(ACCEPT_CONN_ID, acceptConnId);
    }

    /**
     * @return String - the ACCEPT_CONN_ID field
     */ 
    public String getAcceptConnId() {
        return getString(ACCEPT_CONN_ID);
    }

    /**
     * set ACCEPT_CONN_TYPE
     * @param acceptConnType - String
     */ 
    public void setAcceptConnType(String acceptConnType) {
        setValue(ACCEPT_CONN_TYPE, acceptConnType);
    }

    /**
     * @return String - the ACCEPT_CONN_TYPE field
     */ 
    public String getAcceptConnType() {
        return getString(ACCEPT_CONN_TYPE);
    }

    /**
     * set ACCEPT_TYPE
     * @param acceptType - String
     */ 
    public void setAcceptType(String acceptType) {
        setValue(ACCEPT_TYPE, acceptType);
    }

    /**
     * @return String - the ACCEPT_TYPE field
     */ 
    public String getAcceptType() {
        return getString(ACCEPT_TYPE);
    }

    /**
     * set DELIVER_CONN_ID
     * @param deliverConnId - String
     */ 
    public void setDeliverConnId(String deliverConnId) {
        setValue(DELIVER_CONN_ID, deliverConnId);
    }

    /**
     * @return String - the DELIVER_CONN_ID field
     */ 
    public String getDeliverConnId() {
        return getString(DELIVER_CONN_ID);
    }

    /**
     * set DELIVER_CONN_TYPE
     * @param deliverConnType - String
     */ 
    public void setDeliverConnType(String deliverConnType) {
        setValue(DELIVER_CONN_TYPE, deliverConnType);
    }

    /**
     * @return String - the DELIVER_CONN_TYPE field
     */ 
    public String getDeliverConnType() {
        return getString(DELIVER_CONN_TYPE);
    }

    /**
     * set DELIVER_TYPE
     * @param deliverType - String
     */ 
    public void setDeliverType(String deliverType) {
        setValue(DELIVER_TYPE, deliverType);
    }

    /**
     * @return String - the DELIVER_TYPE field
     */ 
    public String getDeliverType() {
        return getString(DELIVER_TYPE);
    }

    /**
     * set PAY_FLAG
     * @param payFlag - String
     */ 
    public void setPayFlag(String payFlag) {
        setValue(PAY_FLAG, payFlag);
    }

    /**
     * @return String - the PAY_FLAG field
     */ 
    public String getPayFlag() {
        return getString(PAY_FLAG);
    }

    /**
     * set BILLING_ID
     * @param billingId - String
     */ 
    public void setBillingId(String billingId) {
        setValue(BILLING_ID, billingId);
    }

    /**
     * @return String - the BILLING_ID field
     */ 
    public String getBillingId() {
        return getString(BILLING_ID);
    }

    /**
     * set BIL_REPLACE_FLAG
     * @param bilReplaceFlag - String
     */ 
    public void setBilReplaceFlag(String bilReplaceFlag) {
        setValue(BIL_REPLACE_FLAG, bilReplaceFlag);
    }

    /**
     * @return String - the BIL_REPLACE_FLAG field
     */ 
    public String getBilReplaceFlag() {
        return getString(BIL_REPLACE_FLAG);
    }

    /**
     * set ARCHIVE_FLAG
     * @param archiveFlag - String
     */ 
    public void setArchiveFlag(String archiveFlag) {
        setValue(ARCHIVE_FLAG, archiveFlag);
    }

    /**
     * @return String - the ARCHIVE_FLAG field
     */ 
    public String getArchiveFlag() {
        return getString(ARCHIVE_FLAG);
    }

    /**
     * set PROTOCOL_TYPE
     * @param protocolType - String
     */ 
    public void setProtocolType(String protocolType) {
        setValue(PROTOCOL_TYPE, protocolType);
    }

    /**
     * @return String - the PROTOCOL_TYPE field
     */ 
    public String getProtocolType() {
        return getString(PROTOCOL_TYPE);
    }

    /**
     * set CUST
     * @param cust - String
     */ 
    public void setCust(String cust) {
        setValue(CUST, cust);
    }

    /**
     * @return String - the CUST field
     */ 
    public String getCust() {
        return getString(CUST);
    }

    /**
     * set BOX_NO
     * @param boxNo - String
     */ 
    public void setBoxNo(String boxNo) {
        setValue(BOX_NO, boxNo);
    }

    /**
     * @return String - the BOX_NO field
     */ 
    public String getBoxNo() {
        return getString(BOX_NO);
    }

    /**
     * set PAD_FLAG
     * @param padFlag - String
     */ 
    public void setPadFlag(String padFlag) {
        setValue(PAD_FLAG, padFlag);
    }

    /**
     * @return String - the PAD_FLAG field
     */ 
    public String getPadFlag() {
        return getString(PAD_FLAG);
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
     * set NOTE2
     * @param note2 - String
     */ 
    public void setNote2(String note2) {
        setValue(NOTE2, note2);
    }

    /**
     * @return String - the NOTE2 field
     */ 
    public String getNote2() {
        return getString(NOTE2);
    }

    /**
     * set COST_ID
     * @param costId - String
     */ 
    public void setCostId(String costId) {
        setValue(COST_ID, costId);
    }

    /**
     * @return String - the COST_ID field
     */ 
    public String getCostId() {
        return getString(COST_ID);
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
     * set MAX_CONNECTIONS
     * @param maxConnections - String
     */ 
    public void setMaxConnections(String maxConnections) {
        setValue(MAX_CONNECTIONS, maxConnections);
    }

    /**
     * @return String - the MAX_CONNECTIONS field
     */ 
    public String getMaxConnections() {
        return getString(MAX_CONNECTIONS);
    }

    /**
     * set ACTIVE_CONNECTIONS
     * @param activeConnections - String
     */ 
    public void setActiveConnections(String activeConnections) {
        setValue(ACTIVE_CONNECTIONS, activeConnections);
    }

    /**
     * @return String - the ACTIVE_CONNECTIONS field
     */ 
    public String getActiveConnections() {
        return getString(ACTIVE_CONNECTIONS);
    }
    
    /**
     * set MAX_MESSAGES
     * @param maxMessages - String
     */ 
    public void setMaxMessages(String maxMessages) {
        setValue(MAX_MESSAGES, maxMessages);
    }

    /**
     * @return String - the MAX_MESSAGES field
     */ 
    public String getMaxMessages() {
        return getString(MAX_MESSAGES);
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
}