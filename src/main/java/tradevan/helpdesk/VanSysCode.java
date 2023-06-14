package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;

import java.io.Serializable;

public class VanSysCode extends DataObject implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7660328209580793066L;
	public static final String TABLE_NAME ="VAN_SYS_CODE";
	public static final String TYPE_ID = "TYPE_ID";
    public static final String CODE_ID = "CODE_ID";
    public static final String CODE_DATA1 = "CODE_DATA1";
    public static final String CODE_DATA2 = "CODE_DATA2";
    public static final String CODE_DATA3 = "CODE_DATA3";
    public static final String CODE_DATA4 = "CODE_DATA4";
    public static final String CT_ID = "CT_ID";
    public static final String CT_DTS = "CT_DTS";
    public static final String OP_ID = "OP_ID";
    public static final String OP_DTS = "OP_DTS";
    private boolean checked = false;

    public VanSysCode() {
        super();
    }


    /**
     * set TYPE_ID
     * @param typeId - String
     */ 
    public void setTypeId(String typeId) {
        setValue(TYPE_ID, typeId);
    }

    /**
     * @return String - the TYPE_ID field
     */ 
    public String getTypeId() {
        return getString(TYPE_ID);
    }

    /**
     * set CODE_ID
     * @param codeId - String
     */ 
    public void setCodeId(String codeId) {
        setValue(CODE_ID, codeId);
    }

    /**
     * @return String - the CODE_ID field
     */ 
    public String getCodeId() {
        return getString(CODE_ID);
    }

    /**
     * set CODE_DATA1
     * @param codeData1 - String
     */ 
    public void setCodeData1(String codeData1) {
        setValue(CODE_DATA1, codeData1);
    }

    /**
     * @return String - the CODE_DATA1 field
     */ 
    public String getCodeData1() {
        return getString(CODE_DATA1);
    }

    /**
     * set CODE_DATA2
     * @param codeData2 - String
     */ 
    public void setCodeData2(String codeData2) {
        setValue(CODE_DATA2, codeData2);
    }

    /**
     * @return String - the CODE_DATA2 field
     */ 
    public String getCodeData2() {
        return getString(CODE_DATA2);
    }

    /**
     * set CODE_DATA3
     * @param codeData3 - String
     */ 
    public void setCodeData3(String codeData3) {
        setValue(CODE_DATA3, codeData3);
    }

    /**
     * @return String - the CODE_DATA3 field
     */ 
    public String getCodeData3() {
        return getString(CODE_DATA3);
    }

    /**
     * set CODE_DATA4
     * @param codeData4 - String
     */ 
    public void setCodeData4(String codeData4) {
        setValue(CODE_DATA4, codeData4);
    }

    /**
     * @return String - the CODE_DATA4 field
     */ 
    public String getCodeData4() {
        return getString(CODE_DATA4);
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