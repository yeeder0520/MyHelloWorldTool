package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;

import java.io.Serializable;

public class VanPartyAltn extends DataObject implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7523096348799352128L;
	public static final String TABLE_NAME ="VAN_PARTY_ALTN";
	public static final String ID = "ID";
    public static final String PARTY_ID = "PARTY_ID";
    public static final String BILLING_STATUS = "BILLING_STATUS";
    public static final String BILLING_INDICATOR = "BILLING_INDICATOR";
    public static final String ARRIVAL_DATE_FLAG = "ARRIVAL_DATE_FLAG";
    public static final String PARTNER_ID = "PARTNER_ID";
    public static final String BILLING_ZIPPED = "BILLING_ZIPPED";
    public static final String HOLD_FLAG = "HOLD_FLAG";
    public static final String HOLD_TIME = "HOLD_TIME";
    public static final String COST_ID = "COST_ID";
    public static final String NOTE1 = "NOTE1";
    public static final String CT_ID = "CT_ID";
    public static final String CT_DTS = "CT_DTS";
    public static final String OP_ID = "OP_ID";
    public static final String OP_DTS = "OP_DTS";
    public static final String VIA_HUB_ID = "VIA_HUB_ID";
    
    
    private boolean checked = false;

    public VanPartyAltn() {
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
     * set BILLING_STATUS
     * @param billingStatus - String
     */ 
    public void setBillingStatus(String billingStatus) {
        setValue(BILLING_STATUS, billingStatus);
    }

    /**
     * @return String - the BILLING_STATUS field
     */ 
    public String getBillingStatus() {
        return getString(BILLING_STATUS);
    }

    /**
     * set BILLING_INDICATOR
     * @param billingIndicator - String
     */ 
    public void setBillingIndicator(String billingIndicator) {
        setValue(BILLING_INDICATOR, billingIndicator);
    }

    /**
     * @return String - the BILLING_INDICATOR field
     */ 
    public String getBillingIndicator() {
        return getString(BILLING_INDICATOR);
    }

    /**
     * set ARRIVAL_DATE_FLAG
     * @param arrivalDateFlag - String
     */ 
    public void setArrivalDateFlag(String arrivalDateFlag) {
        setValue(ARRIVAL_DATE_FLAG, arrivalDateFlag);
    }

    /**
     * @return String - the ARRIVAL_DATE_FLAG field
     */ 
    public String getArrivalDateFlag() {
        return getString(ARRIVAL_DATE_FLAG);
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
     * set BILLING_ZIPPED
     * @param billingZipped - String
     */ 
    public void setBillingZipped(String billingZipped) {
        setValue(BILLING_ZIPPED, billingZipped);
    }

    /**
     * @return String - the BILLING_ZIPPED field
     */ 
    public String getBillingZipped() {
        return getString(BILLING_ZIPPED);
    }

    /**
     * set HOLD_FLAG
     * @param holdFlag - String
     */ 
    public void setHoldFlag(String holdFlag) {
        setValue(HOLD_FLAG, holdFlag);
    }

    /**
     * @return String - the HOLD_FLAG field
     */ 
    public String getHoldFlag() {
        return getString(HOLD_FLAG);
    }

    /**
     * set HOLD_TIME
     * @param holdTime - String
     */ 
    public void setHoldTime(String holdTime) {
        setValue(HOLD_TIME, holdTime);
    }

    /**
     * @return String - the HOLD_TIME field
     */ 
    public String getHoldTime() {
        return getString(HOLD_TIME);
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
     * set VIA_HUB_ID
     * @param viaHubId - String
     */ 
    public void setViaHubId(String viaHubId) {
        setValue(VIA_HUB_ID, viaHubId);
    }

    /**
     * @return String - the VIA_HUB_ID field
     */ 
    public String getViaHubId() {
        return getString(VIA_HUB_ID);
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