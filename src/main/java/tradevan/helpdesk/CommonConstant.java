/*
 * Created on 2005/1/20
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tradevan.helpdesk;

import java.util.Vector;


/**
 * @author Tear Chen
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommonConstant {

	public final static String ENVIRONMENT = "ENVIRONMENT";
	public final static String ENVIRONMENT_PRODUCTION = "P";
	public final static String ENVIRONMENT_VERIFY = "V";
	public final static String ENVIRONMENT_TEST = "T";
	

	public final static String SID_NVAN = "pnvanConn";
	public final static String SID_B2BI = "pb2biConn";
	public final static String SID_ARC = "parcConn";
	public final static String SID_PMSG = "ppmsgConn";
	//2012/02/22 增加MAX_SIZE 為 20MB
	public final static long MAX_SIZE = 20971520L;
	public final static long REDO_MAX_SIZE =  10485760L;
	//MessageEvent
	public final static String STATUS_PROCESS = "P";
	public final static String STATUS_QUEUE = "Q";
	public final static String STATUS_TERMINAL = "T";
	public final static String STATUS_CANCEL = "D";
	public final static String STATUS_ERROR = "E";
	public final static String STATUS_HOLD = "H";
	public final static String REDO_MESSAGE_SUB_ID = "001";
	public final static String REDO_DOC_FORMAT_E = "E";
	public final static String REDO_MESSAGE_TYPE_P = "P";
	public final static String REDO_MESSAGE_SUB_TYPE = "R";
	public final static String REDO_ARC_MESSAGE_SUB_TYPE = "5";
	public final static int ARG_MAX_NUM = 15;
	public final static String TARGET_FUN_NAME = "TargetFunctionName";
	public final static String TARGET_FUN_PROC = "proceed";
	public final static String CMT_PRODUCER_HEADER = "CMT_PRODUCER_HEADER";
	public final static String RM_ENV_HEADER = "RM_ENV_HEADER";
	public final static String UNPACK_HEADER = "UNPACK_HEADER";
	public final static String UNPACK_QUEUE = "UNPACK_QUEUE";
	public final static String PROC_QUEUE = "PROC_QUEUE";
	public final static String CMT_QUEUE = "CMT_QUEUE";
	public static final String EBMS_QUEUE_NAME = "EBMS_QUEUE_NAME";
    public final static String SFTP = "SFTP";
    public final static String CMT = "CMT";
    public final static String EDI = "EDI";
    public final static String PEDI = "PEDI";
    public final static String CCS = "CCS";
    public final static String BYPASS = "BYPASS";
	// Common Query Constant : StartDTS , EndDts , QryCount
	public final static String START_DTS = "START_DTS";
	public final static String END_DTS = "END_DTS";
	public final static String QRY_COUNT = "QRY_COUNT";
	public final static String ROWNUM = "ROWNUM";
	public final static String TABLENAME = "TABLENAME";
	public final static String TRANSACTION_ID = "TRANSACTION_ID";
	public final static String ORDER_BY = "ORDER_BY";
	// Session Constants
	public final static String QRY_PARTY_ID = "qrypartyid";
	public final static String QRY_START_DATE = "qrystartdate";
	public final static String QRY_START_TIME = "qrystarttime";
	public final static String QRY_END_DATE = "qryenddate";
	public final static String QRY_END_TIME = "qryendtime";
	
	//郵箱切換
	public static final String CUSTOM = "CUSTOM";

	//DSMsg stauts
	public static final String DS_MSG_STAT_HOLD = "HOLD";
	public static final String DS_MSG_STAT_CANCEL = "CANCEL";
	public static final String DS_MSG_STAT_QUEUE = "QUEUE";
	
	// XENI
	public static final String PARTNERID = "PARTNER_ID";
	
	/* query default count */
    public final static int MAX_ROWS = 5000;
    public final static String DEFAULT_ROWS = "MAX_ROWS";
    //Role number
    public final static String[] ARC_ROLE={"G0000001","G0000012","G0000013"};
    public final static String NVAN_ROLE="G0000021";
    public final static String IVCC_ROLE="G0000022";
	public final static String USER_ROLE="G0000004";
	public final static String SU_ROLE="G0000001";
    /* language */
    public final static String LANG = "lang";
    public final static String LANG_TW = "zh_TW";
    public final static String LANG_US = "en";
    public static final String LOCALE_KEY = "org.apache.struts.action.LOCALE";
    
    /* view mode */
    public final static String VIEW = "view";
    public final static String VIEW_PAGE = "page";
    public final static String VIEW_PRINT = "print";
    
    /* subfunc code */
    public final static String SUBFUNC_ALL_PERMIT = "AllPermit";
    public final static String SUBFUNC_ADD = "A";
    public final static String SUBFUNC_UPDATE = "U";
    public final static String SUBFUNC_DELETE = "D";
    public final static String SUBFUNC_QUERY = "Q";
    public final static String SUBFUNC_PRINT = "P";
    public final static String SUBFUNC_EDIT = "E";
    public final static String SUBFUNC_VIEW = "V";
    public final static String SUBFUNC_DOWNLOAD = "L";
    public final static String SUBFUNC_RESEND = "R";
    public final static String SUBFUNC_GETFILE = "G";
    public final static String SUBFUNC_NONE = "NONE";
    
    
    /* OP MSG return Code */
  public final static String OPRTNCODE_GOOD = "msg.dsopresultgood";
    public final static String OPRTNCODE_UPDATEFAILED = "msg.dsopresultupdatefailed";
    public final static String OPRTNCODE_PUBLISHFILAED = "msg.dsopresultpublishfailed";
    public final static String OPRTNCODE_DUPLICATE = "msg.dsopresultduplicate";
    public final static String OPRTNCODE_INFOERR = "msg.dsopresultinfoerr";
   
    /* for escape */
    public final static String ESCAPE_RESOURCE_INJECTION="[!$^&*(),%~\\.\\[\\]\\/|{}\'\";<>\\?\'\"\\\\]";
    public final static String ESCAPE_COMMAND_INECTION="[!$^&*(),%~\\.\\[\\]\\/|{}\'\";<>\\?\'\"\\\\]";
    
    public final static String[] SUBFUNC = {
    		SUBFUNC_ADD,
			SUBFUNC_UPDATE,
			SUBFUNC_DELETE,
			SUBFUNC_QUERY,
			SUBFUNC_PRINT,
			SUBFUNC_EDIT,
			SUBFUNC_VIEW,
			SUBFUNC_DOWNLOAD,
			SUBFUNC_RESEND,
			SUBFUNC_GETFILE
    };
    
    public final static String[] SUBFUNC_ADD_ACTIONS = { "Add", "New" };
    public final static String[] SUBFUNC_UPDATE_ACTIONS = { "Update", "Upd" };
    public final static String[] SUBFUNC_DELETE_ACTIONS = { "Delete", "Del", "Move" };
    public final static String[] SUBFUNC_QUERY_ACTIONS = { "Qry", "List", "preUpdate", "Detail", "Status", "SelectAll", "Next", "Back", "callWS"};
    public final static String[] SUBFUNC_PRINT_ACTIONS = { "Print" };
    public final static String[] SUBFUNC_EDIT_ACTIONS = { "Edit" };
    public final static String[] SUBFUNC_VIEW_ACTIONS = { "View" };
    public final static String[] SUBFUNC_DOWNLOAD_ACTIONS = { "Download", "Tojms" };
    public final static String[] SUBFUNC_RESEND_ACTIONS = { "Resend", "Redo" };
    public final static String[] SUBFUNC_VALIDATETEST_ACTIONS = { "ValidateTest" };
    public final static String[] SUBFUNC_GETFILE_ACTIONS = { "Get" };
    
    public final static Vector getSubFuncActions() {
	    Vector actions = new Vector();
	    actions.add(SUBFUNC_ADD_ACTIONS);
	    actions.add(SUBFUNC_UPDATE_ACTIONS);
	    actions.add(SUBFUNC_DELETE_ACTIONS);
	    actions.add(SUBFUNC_QUERY_ACTIONS);
	    actions.add(SUBFUNC_PRINT_ACTIONS);
	    actions.add(SUBFUNC_EDIT_ACTIONS);
	    actions.add(SUBFUNC_VIEW_ACTIONS);
	    actions.add(SUBFUNC_DOWNLOAD_ACTIONS);
	    actions.add(SUBFUNC_RESEND_ACTIONS);
	    actions.add(SUBFUNC_VALIDATETEST_ACTIONS);
	    actions.add(SUBFUNC_GETFILE_ACTIONS);
	    return actions;
    };
  /* for CCS?��?*/
    public final static String DOCTYPE_UNB = "U";        /** document type: UNB envelope. */
    public final static String DOCTYPE_EDI = "E";        /** document type: EDI，�??�到dsms_mailbox.documenttype. */
    public final static String DOCTYPE_TYPEB = "B";      /** document type: type B. */
    public final static String DOCTYPE_CARGOWING = "W";  /** document type: cargowing. */
    public final static String EDI_QUALIFIER_AL = "Z1";  /** ?�空?�司EDI qualifier. */
    
    /* for Vitria ?��? */
    public final static String VITRIA_EVT_MSG_LOG_DTL_EVT = "MsgLogDtlEvent";
    public final static String VITRIA_EVT_SFTP_INFO_EVT = "SftpInfoEvent"; 
    public final static String VITRIA_EVT_MSG_INFO_EVT = "MsgInfoEvent";
    public final static String VITRIA_CHL_DSVASCHECKCHANNEL = "DSVASCHECKCHANNEL"; 
    public final static String VITRIA_CHL_SFTPROUTECHANNEL = "SFTPROUTECHANNEL"; 
    public final static String VITRIA_CHL_PROCINCHANNEL = "PROCINCHANNEL"; 
    public final static String VITRIA_CHL_FILEINPUTCHANNEL = "FILEINPUTCHANNEL";
    public final static String VITRIA_CHL_INPUTCHANNEL = "INPUTCHANNEL";
    public final static String VITRIA_CHL_OUT2DVSCHANNEL = "OUT2DVSCHANNEL";
  
    /* for Redo Result */
    public final static String REDO_RESULT = "REDO_RESULT";
    public final static String REDO_SUCCESS = "0";
    public final static String REDO_FAIL = "-1";
    
    /* for arc impala query */
    public static final String KEY_QUERY_RESULT_LIST = "queryDataBySql";
    
    //info
    public final static String ERROR_CODE_ACTIVATE_SUCCESS = "IN001";
    public final static String ERROR_CODE_SEND_NOTIFY_MAIL = "IN002";
    public final static String ERROR_CODE_PERMISSION_CHECKED_SUCCESS = "IN003";
    public final static String ERROR_CODE_DO_SCRIPT_STRART = "IN004";
    public final static String ERROR_CODE_DO_SCRIPT_STEP_START = "IN005";
    public final static String ERROR_CODE_DO_SCRIPT_STEP_FINISH = "IN006";
    public final static String ERROR_CODE_DO_SCRIPT_FINISH = "IN007";
    public final static String ERROR_CODE_CANCEL_DO_SCRIPT = "IN008";
    public final static String ERROR_CODE_RETURN_AUTH = "IN009";
 

    //WARN
    public final static String ERROR_CODE_HAS_BEEN_ACTIVATED = "WA001";
    public final static String ERROR_CODE_PLEASE_REQUEST_AUTH_AGAIN = "WA002";


    //ERROR
    public final static String ERROR_CODE_SYSTEM_RUNTIME_ERROR = "ER001";
    public final static String ERROR_CODE_PARAMETER_ERROR = "ER002";
    public final static String ERROR_CODE_USERID_ILLEGAL = "ER003";
    public final static String ERROR_CODE_USERID_NOT_EXIST = "ER004";
    public final static String ERROR_CODE_ACTIVATE_FAIL_TRY_AGAIN = "ER005";
    public final static String ERROR_CODE_LINK_INVALID_RETRY_AUTHORIZE = "ER006";
    public final static String ERROR_CODE_CHECK_PERMISSION_ERROR = "ER007";
    public final static String ERROR_CODE_DO_SCRIPT_EXEC_ERROR = "ER008";
    
}
