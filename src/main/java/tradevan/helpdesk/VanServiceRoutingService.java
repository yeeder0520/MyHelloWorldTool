package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.SqlPredicate;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Title: VanServiceRoutingService<br>
 * Description: 提供MainVanServiceRoutingAction新增、刪除、修改、查詢DB。<br>
 * Company: Tradevan Co.<br>
 * 
 * @author I-Chun Huang
 * @since 1.0.0
 */
public class VanServiceRoutingService {
    public static VanServiceRoutingService INSTANCE = new VanServiceRoutingService();
    private VanServiceRoutingModel vanServiceRoutingModel = new VanServiceRoutingModel();
    private VanServiceRoutingExtModel vanServiceRoutingExtModel = new VanServiceRoutingExtModel();
    
    /**
     * 取得VanServiceRouting的相關物件
     * @param query
     * @return
     * @throws XdaoException 
     */
    public List<VanServiceRouting> queryByDef(Map query) throws XdaoException {
        SqlWhere where = new SqlWhere();
        
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.RTG_SEQ_NO))
            where.add(VanServiceRouting.RTG_SEQ_NO, query.get(VanServiceRouting.RTG_SEQ_NO));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.PARTY_ID))
            where.add(VanServiceRouting.PARTY_ID, query.get(VanServiceRouting.PARTY_ID));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.PARTY_ID_TYPE))
            where.add(VanServiceRouting.PARTY_ID_TYPE, query.get(VanServiceRouting.PARTY_ID_TYPE));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.PROCESS_ID))
            where.add(VanServiceRouting.PROCESS_ID, query.get(VanServiceRouting.PROCESS_ID));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.STEP))
            where.add(VanServiceRouting.STEP, query.get(VanServiceRouting.STEP));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.PARTNER_ID))
            where.add(VanServiceRouting.PARTNER_ID, query.get(VanServiceRouting.PARTNER_ID));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.PARTNER_ENABLED))
            where.add(VanServiceRouting.PARTNER_ENABLED, query.get(VanServiceRouting.PARTNER_ENABLED));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.MESSAGE_TYPE))
            where.add(VanServiceRouting.MESSAGE_TYPE, query.get(VanServiceRouting.MESSAGE_TYPE));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.MESSAGE_VERSION))
            where.add(VanServiceRouting.MESSAGE_VERSION, query.get(VanServiceRouting.MESSAGE_VERSION));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.MESSAGE_FORMAT))
            where.add(VanServiceRouting.MESSAGE_FORMAT, query.get(VanServiceRouting.MESSAGE_FORMAT));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.SERVICE_ID))
            where.add(VanServiceRouting.SERVICE_ID, query.get(VanServiceRouting.SERVICE_ID));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.ACTION_ID))
            where.add(VanServiceRouting.ACTION_ID, query.get(VanServiceRouting.ACTION_ID));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.CONN_SRC_ID))
            where.add(VanServiceRouting.CONN_SRC_ID, query.get(VanServiceRouting.CONN_SRC_ID));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.CONN_DES_ID))
            where.add(VanServiceRouting.CONN_DES_ID, query.get(VanServiceRouting.CONN_DES_ID));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.ENABLED))
            where.add(VanServiceRouting.ENABLED, query.get(VanServiceRouting.ENABLED));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.BILLING_CODE))
            where.add(VanServiceRouting.BILLING_CODE, query.get(VanServiceRouting.BILLING_CODE));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.ACK_MARK) && "Y".equals((String) query.get(VanServiceRouting.ACK_MARK))){
            where.add(VanServiceRouting.ACK_MARK, query.get(VanServiceRouting.ACK_MARK));
        }
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.NOTE1))
            where.add(VanServiceRouting.NOTE1, query.get(VanServiceRouting.NOTE1));
        if(!CommonLib.isNullOrEmpty(query, VanServiceRouting.SRC_SYS_TYPE))
            where.add(VanServiceRouting.SRC_SYS_TYPE, query.get(VanServiceRouting.SRC_SYS_TYPE));
        
        return this.vanServiceRoutingModel.query(where);
    }
    
    /**
     * 查詢用戶代碼為not null，目的代碼為線路名稱的資料
     * @param String
     * @return
     * @throws XdaoException 
     */
    public List<VanServiceRouting> queryforCCSByObjId(String objId) throws XdaoException {
        SqlWhere where = new SqlWhere();
        where.add(VanServiceRouting.CONN_DES_ID, objId);      
        SqlPredicate pred = new SqlPredicate(VanServiceRouting.PARTY_ID, "IS", "NOT NULL", false, false);
        pred.setPreparedMode(false);
        where.add(pred);    
        
        return this.vanServiceRoutingModel.query(where);
    }

    
    /**
     * 查詢資料庫中是否有相同交易代碼、來源、目的線路名稱的資料
     * @param String
     * @return
     * @throws XdaoException 
     */
    public List<MainVanCustCCSLine> queryforCCS(String id) throws XdaoException { 	
        return this.queryforCCS(id, "", "");
    }
    
    /**
     * 查詢資料庫中是否有相同交易代碼、來源、目的線路名稱的資料
     * @param String
     * @param String
     * @return
     * @throws XdaoException 
     */
    public List<MainVanCustCCSLine> queryforCCS(String id, String srcObjId) throws XdaoException { 	
        return this.queryforCCS(id, srcObjId, "");
    }
    
    /**
     * 查詢資料庫中是否有相同交易代碼、來源、目的線路名稱的資料For CCS CustLine
     * @param String
     * @param String
     * @param String
     * @return
     * @throws XdaoException 
     */
    public List<MainVanCustCCSLine> queryforCCS(String id, String srcObjId, String desObjId) throws XdaoException {   	
    	String selectField = "v.*, e." + VanServiceRoutingExt.ARG_ID + ", e." + VanServiceRoutingExt.ARG_VALUE;
    	String from = VanServiceRouting.TABLE_NAME + " v," + VanServiceRoutingExt.TABLE_NAME + " e";
    	String orderBy = "v." + VanServiceRouting.PARTY_ID;
        SqlWhere where = new SqlWhere();
        
        if(!CommonLib.isNullOrEmpty(id)) {
        	where.add("v." + VanServiceRouting.PARTY_ID, id);
        }
        
        if(!CommonLib.isNullOrEmpty(srcObjId)) {
        	where.add("v." + VanServiceRouting.ACTION_ID, srcObjId);
        }
       
        if(!CommonLib.isNullOrEmpty(desObjId)) {        
        	where.add("e." + VanServiceRoutingExt.ARG_VALUE, desObjId);           	     	
        }
        
        //只允許查詢出ARG_ID為VIA_HUB_ID的資料
    	where.add("e." + VanServiceRoutingExt.ARG_ID, "VIA_HUB_ID"); 
        
        where.add(new SqlPredicate("v."+ VanServiceRouting.RTG_SEQ_NO , "=", "e."+ VanServiceRoutingExt.RTG_SEQ_NO , false).setPreparedMode(false));
        
        List<MainVanCustCCSLine> mvcList = this.vanServiceRoutingModel.query(where, selectField, from, orderBy, -1);
        
        //資料庫與畫面呈現的轉換
        for (MainVanCustCCSLine mvc : mvcList) {
        	if ("CIDB".equals(mvc.getArgValue())) {
        		mvc.setArgValue("加值系統資料庫");
        	} else if ("CIFP".equals(mvc.getArgValue())) {
        		mvc.setArgValue("加值系統FTP");
        	}
        }
        
        return mvcList;
    }
    
    /**
     * 根據PK取得VanServiceRouting的相關物件
     * @param vanServiceRouting
     * @return
     * @throws XdaoException 
     */
    public VanServiceRouting qryVanServiceRoutingByPkey(VanServiceRouting vanServiceRouting) throws XdaoException {
        return this.vanServiceRoutingModel.queryOne(vanServiceRouting);
    }

    /**
     * 新增VanServiceRouting,vanServiceRoutingExt
     * @param vanServiceRouting
     * @param vanServiceRoutingExt 
     * @return
     * @throws XdaoException 
     */
    public int insVanServiceRouting(VanServiceRouting vanServiceRouting, VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
        int rtnCode = 0;
        vanServiceRouting.setValue(VanServiceRouting.CT_DTS, new Timestamp(new Date().getTime()));
        vanServiceRouting.setValue(VanServiceRouting.OP_DTS, new Timestamp(new Date().getTime()));
        String rtgSeqNo = getNextRtgSeqNo();
        
        try {
            vanServiceRouting.setRtgSeqNo(rtgSeqNo);
            
            DefaultModel.beginTransaction();
            rtnCode += this.vanServiceRoutingModel.insert(vanServiceRouting);
            if("Y".equals(vanServiceRouting.getAckMark()) && !CommonLib.isNullOrEmpty(vanServiceRoutingExt.getArgValue())){
                vanServiceRoutingExt.setRtgSeqNo(rtgSeqNo);
                vanServiceRoutingExt.setValue(VanServiceRoutingExt.CT_DTS, new Timestamp(new Date().getTime()));
                vanServiceRoutingExt.setValue(VanServiceRoutingExt.OP_DTS, new Timestamp(new Date().getTime()));
                rtnCode += this.vanServiceRoutingExtModel.insert(vanServiceRoutingExt);
            }      
            DefaultModel.commit();
        } catch (XdaoException e) {
            DefaultModel.rollback();
            throw e;
        }
        
        return rtnCode; 
    }
    
    /**
     * 回傳下一個RTG_SEQ_NO
     * @return
     * @throws XdaoException
     */
    public String getNextRtgSeqNo() throws XdaoException{
        String LPAD = "000000000000000000";
        int rtgSeqNoLeng = 8;
        
        List<VanServiceRouting> templateResult = this.vanServiceRoutingModel.queryTemplate("MainVanServiceRoutingTemplate.getMaxRegSeqNo", null);
        int maxRtgSeqNo =  Integer.parseInt((String)templateResult.get(0).getRtgSeqNo());
        String nextSeq = String.valueOf(maxRtgSeqNo + 1);
        
        return LPAD.substring(0, rtgSeqNoLeng-nextSeq.length()) + nextSeq;
    }

    /**
     * 更新VanServiceRouting, vanServiceRoutingExt
     * @param vanServiceRouting
     * @param vanServiceRoutingExt 
     * @return
     * @throws XdaoException 
     */
    public int updVanPartyTransport(VanServiceRouting vanServiceRouting, VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
        int rtnCode = 0;
        vanServiceRouting.setValue(VanServiceRouting.OP_DTS, new Timestamp(new Date().getTime()));
        
        try {
            DefaultModel.beginTransaction();
            rtnCode += this.vanServiceRoutingModel.update(vanServiceRouting);
            if("N".equals(vanServiceRouting.getAckMark()) ){ // delete
                rtnCode += this.vanServiceRoutingExtModel.delete(vanServiceRoutingExt);
            }else if("Y".equals(vanServiceRouting.getAckMark()) && !CommonLib.isNullOrEmpty(vanServiceRoutingExt.getArgValue())){
                vanServiceRoutingExt.setValue(VanServiceRoutingExt.OP_DTS, new Timestamp(new Date().getTime()));
                
                VanServiceRoutingExt qryObj = this.vanServiceRoutingExtModel.queryOne(vanServiceRoutingExt);                
                if(qryObj == null){ // insert
                    vanServiceRoutingExt.setCtId(vanServiceRoutingExt.getOpId());
                    vanServiceRoutingExt.setValue(VanServiceRoutingExt.CT_DTS, new Timestamp(new Date().getTime()));
                    rtnCode += this.vanServiceRoutingExtModel.insert(vanServiceRoutingExt);
                }else{ //update
                    rtnCode += this.vanServiceRoutingExtModel.update(vanServiceRoutingExt);
                }
            }
            DefaultModel.commit();
        } catch (XdaoException e) {
            DefaultModel.rollback();
            throw e;
        }
        
        return rtnCode; 
    }

    /**
     * 根據PK刪除VanServiceRouting,vanServiceRoutingExt
     * @param vanServiceRouting
     * @param vanServiceRoutingExt 
     * @return
     * @throws XdaoException 
     */
    public int delVanServiceRouting(VanServiceRouting vanServiceRouting, VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
        int rtnCode = 0;
        
        try {
            DefaultModel.beginTransaction();
            rtnCode += this.vanServiceRoutingModel.delete(vanServiceRouting);
            rtnCode += this.vanServiceRoutingExtModel.delete(vanServiceRoutingExt);
            DefaultModel.commit();
        } catch (XdaoException e) {
            DefaultModel.rollback();
            throw e;
        }

        return rtnCode; 
    }
    
    /**
     * 根據PK刪除VanServiceRouting
     * @param vanServiceRouting
     * @param vanServiceRoutingExt 
     * @return
     * @throws XdaoException 
     */
    public int delVanServiceRoutingByActionId(String objId) throws XdaoException {
        int rtnCode = 0;
        SqlWhere where = new SqlWhere();
        where.add(VanServiceRouting.ACTION_ID, objId);
        SqlPredicate pred = new SqlPredicate(VanServiceRouting.PARTY_ID, "IS", "NULL", false, false);
        pred.setPreparedMode(false);
        where.add(pred);    
        
        try {
            DefaultModel.beginTransaction();
            rtnCode += this.vanServiceRoutingModel.delete(where);
            DefaultModel.commit();
        } catch (XdaoException e) {
            DefaultModel.rollback();
            throw e;
        }

        return rtnCode; 
    }
  
    /**
    *
    * @param String
    * @param String
    * @return
    * @throws XdaoException 
    */
   public List<VanServiceRouting> queryforJMSImport(String serviceId, String note1) throws XdaoException {
       DataObject predicate = new DataObject(); 
       
       if(serviceId == null) {
           predicate.setValue("SERVICE_ID", "%");
       } else { 
           predicate.setValue("SERVICE_ID", "%"+serviceId+"%");
       }
       if(note1 == null) {
           predicate.setValue("NOTE1", "%");
       } else {
           predicate.setValue("NOTE1", "%"+note1+"%");
       }
       return this.vanServiceRoutingModel.queryTemplate("JMSImport.query", predicate);
   }
}
