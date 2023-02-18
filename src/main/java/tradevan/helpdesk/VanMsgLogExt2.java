package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;

import java.io.Serializable;

public class VanMsgLogExt2 extends DataObject implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4010035000592000566L;
	public static final String TABLE_NAME ="VAN_MSG_LOG_EXT2";
	public static final String MESSAGE_ID = "MESSAGE_ID";
    public static final String MESSAGE_SUB_ID = "MESSAGE_SUB_ID";

    public static final String PROC_INFO = "PROC_INFO";
    public static final String ACPT_DTS="ACPT_DTS";
    public static final String EXT_ID = "EXT_ID";
    public static final String ARG_ID = "ARG_ID";
    public static final String ARG_VALUE= "ARG_VALUE";
    public VanMsgLogExt2() {
        super();
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
     * set PROC_INFO
     * @param procInfo - String
     */ 
    public void setProcInfo(String procInfo) {
        setValue(PROC_INFO, procInfo);
    }

    /**
     * @return String - the PROC_INFO field
     */ 
    public String getProcInfo() {
        return getString(PROC_INFO);
    }
    
    
    
    
    
    /**
     * set EXT_ID
     * @param procInfo - String
     */ 
    public void setExtId(String extId) {
        setValue(EXT_ID, extId);
    }

    /**
     * @return String - the EXT_ID field
     */ 
    public String getExtId() {
        return getString(EXT_ID);
    }
    
    
    
    /**
     * set ARG_ID
     * @param procInfo - String
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
     * @param procInfo - String
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
    
    
    


	public static String getAcptDts() {
		return ACPT_DTS;
	}
    public String getFormatAcptDts(){
        return DateTimeUtil.formatStr2DTSToMin(getString(ACPT_DTS));
    }

}