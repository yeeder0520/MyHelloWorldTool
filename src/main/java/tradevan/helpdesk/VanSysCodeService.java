package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.SqlPredicate;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Title: VanSysCodeService<br>
 * Description: 提供VanSysCodeAction新增、刪除、修改、查詢DB。<br>
 * Company: Tradevan Co.<br>
 * 
 * @author I-Chun Huang
 * @since 1.0.0
 */
public class VanSysCodeService {
    public static final VanSysCodeService INSTANCE = new VanSysCodeService();
    private VanSysCodeModel vanSysCodeModel = new VanSysCodeModel();
    
    
    /**
     * 取得VanSysCode的相關物件
     * @param query
     * @return
     * @throws XdaoException 
     */
    public List<VanSysCode> queryByDef(Map query) throws XdaoException {
        int queryCount = 0;
        if(!CommonLib.isNullOrEmpty(query, CommonConstant.QRY_COUNT))
            queryCount = Integer.parseInt((String)query.get(CommonConstant.QRY_COUNT));
        
        SqlWhere where = new SqlWhere();
        where.add(VanSysCode.TYPE_ID, query.get(VanSysCode.TYPE_ID));
        if(!CommonLib.isNullOrEmpty(query, VanSysCode.CODE_ID))
            where.add(new SqlPredicate(VanSysCode.CODE_ID, "LIKE", "%"+query.get(VanSysCode.CODE_ID)+"%"));
        
        if(!CommonLib.isNullOrEmpty(query, VanSysCode.CODE_DATA1))
            where.add(new SqlPredicate(VanSysCode.CODE_DATA1, "LIKE", "%"+query.get(VanSysCode.CODE_DATA1)+"%"));
        
        if(!CommonLib.isNullOrEmpty(query, VanSysCode.CODE_DATA2))
            where.add(new SqlPredicate(VanSysCode.CODE_DATA2, "LIKE", "%"+query.get(VanSysCode.CODE_DATA2)+"%"));
        
        if(!CommonLib.isNullOrEmpty(query, VanSysCode.CODE_DATA3))
            where.add(new SqlPredicate(VanSysCode.CODE_DATA3, "LIKE", "%"+query.get(VanSysCode.CODE_DATA3)+"%"));
        
        if(!CommonLib.isNullOrEmpty(query, VanSysCode.CODE_DATA4))
            where.add(new SqlPredicate(VanSysCode.CODE_DATA4, "LIKE", "%"+query.get(VanSysCode.CODE_DATA4)+"%"));
        return this.vanSysCodeModel.query(where, queryCount);
    }
    public List<VanSysCode> queryByKeys(String qryTypeId,String qryCodeId,String count) throws XdaoException {
    	   int queryCount = 0;
           if(!CommonLib.isNullOrEmpty(count))
               queryCount = Integer.parseInt(count);
      
        SqlWhere where = new SqlWhere();
        where.add(VanSysCode.TYPE_ID, qryTypeId);
        if(!CommonLib.isNullOrEmpty(qryCodeId))
            where.add(new SqlPredicate(VanSysCode.CODE_ID, "LIKE", "%"+qryCodeId+"%"));
        
        return this.vanSysCodeModel.queryDistinct(where, queryCount);
    }
    
    public String queryForMax() throws XdaoException{
      String selectStr = "substr(MAX(" + VanSysCode.CODE_ID + "),0,2) as SEQ";
      String table = VanSysCode.TABLE_NAME;
      SqlWhere where = new SqlWhere();
      where.add(VanSysCode.TYPE_ID, "S00");
      int maxRow = -1 ;
      
      List dataObjects = this.vanSysCodeModel.queryMax(selectStr, table, where, maxRow);
      if(dataObjects.toString().equals("[{}]"))
        return "0";
      if(dataObjects.size() > 0){
        DataObject dataObject = (DataObject)dataObjects.get( 0);
        return dataObject.getValue("SEQ").toString();
      }
      return dataObjects.toString();
    }
    
    public VanSysCode qryByPKey(VanSysCode vanSysCode) throws XdaoException {
      
      return this.vanSysCodeModel.queryOne(vanSysCode);
   }
    
    public List<VanSysCode> queryForAjax(String qryTypeId,String qryCodeId,String count) throws XdaoException {
 	   int queryCount = 0;
        if(!CommonLib.isNullOrEmpty(count))
            queryCount = Integer.parseInt(count);
   
     SqlWhere where = new SqlWhere();
     where.add(VanSysCode.TYPE_ID, qryTypeId);
     if(!CommonLib.isNullOrEmpty(qryCodeId))
         where.add(new SqlPredicate(VanSysCode.CODE_ID, "LIKE", qryCodeId+"%"));
     
     return this.vanSysCodeModel.queryDistinct(where, queryCount);
 }
    /**
     * 根據PK取得VanSysCode的相關物件
     * @param vanSysCode
     * @return
     * @throws XdaoException
     */
    public VanSysCode qryVanSysCodeByPkey(VanSysCode vanSysCode) throws XdaoException {
        
        return this.vanSysCodeModel.queryOne(vanSysCode);
    }


    /**
     * 插入VanSysCode
     * @param vanSysCode
     * @return
     * @throws XdaoException 
     */
    public int insVanSysCode(VanSysCode vanSysCode) throws XdaoException {
        vanSysCode.setValue(VanSysCode.CT_DTS, new Timestamp(new Date().getTime()));
        vanSysCode.setValue(VanSysCode.OP_DTS, new Timestamp(new Date().getTime()));
        
        //刪去前後空白
    	trimValue(vanSysCode); 
    	
        return this.vanSysCodeModel.insert(vanSysCode);
    }
    
    /**
     * 更新VanSysCode list
     * @param vanSysCodeList
     * @param opId
     * @return
     * @throws XdaoException 
     */
    public List<VanSysCode> updVanSysCode(List<VanSysCode> vanSysCodeList, String opId) throws XdaoException {
        List<VanSysCode> result = null;
        VanSysCode vanSysCode ;
        DefaultModel.beginTransaction();
        try{
            result = new ArrayList<VanSysCode>();
            for(int i=0; i<vanSysCodeList.size(); ++i){
                vanSysCode = vanSysCodeList.get(i);
                if(vanSysCode.isChecked()){
                	//刪去前後空白
                	trimValue(vanSysCode);  
                    vanSysCode.setOpId(opId);
                    vanSysCode.setValue(VanSysCode.OP_DTS, new Timestamp(new Date().getTime()));
                    this.vanSysCodeModel.update(vanSysCode);
                    result.add(qryVanSysCodeByPkey(vanSysCode));
                }
            }
            DefaultModel.commit();
        }catch(XdaoException e){
            DefaultModel.rollback();
            throw e;
        }
        return result;
    }
    
	//trim value以去除前後空白部分
	private void trimValue(VanSysCode vsc) {
		vsc.setCodeId(vsc.getCodeId() == null? "" : vsc.getCodeId().trim());
		vsc.setCodeData1(vsc.getCodeData1() == null? "" : vsc.getCodeData1().trim());
		vsc.setCodeData2(vsc.getCodeData2() == null? "" : vsc.getCodeData2().trim());
		vsc.setCodeData3(vsc.getCodeData3() == null? "" : vsc.getCodeData3().trim());
		vsc.setCodeData4(vsc.getCodeData4() == null? "" : vsc.getCodeData4().trim());
	}

    /**
     * 根據PK刪除VanSysCode的相關物件 
     * @param vanSysCodeList
     * @return
     * @throws XdaoException
     */
    public int delVanSysCode(List<VanSysCode> vanSysCodeList) throws XdaoException {
        int rtnCount = 0;
        VanSysCode vanSysCode ;
        DefaultModel.beginTransaction();
        try{
            for(int i=0; i<vanSysCodeList.size(); ++i){
                vanSysCode = vanSysCodeList.get(i);
                if(vanSysCode.isChecked()){
                    rtnCount += this.vanSysCodeModel.delete(vanSysCode);            
                }
            }
            DefaultModel.commit();
        }catch(XdaoException e){
            DefaultModel.rollback();
            throw e;
        }
        return rtnCount;
    }

    /**
     * 根據參數取得VanSysCode的相關物件
     * @param typeId
     * @param codeId
     * @return
     * @throws XdaoException
     */
    public List<VanSysCode> queryByPerUpdate(String typeId, String codeId) throws XdaoException {
        SqlWhere where = new SqlWhere();
        where.add(VanSysCode.TYPE_ID, typeId);
        if(!CommonLib.isNullOrEmpty(codeId))
            where.add(VanSysCode.CODE_ID, codeId);
        
        return this.vanSysCodeModel.query(where, -1);
    }

    /**
     * 取得VanSysCode的相關物件
     * @param query
     * @return
     * @throws XdaoException 
     */
    public List<VanSysCode> queryForSysCodeList(String typeId) throws XdaoException {
        int queryCount = 300;
        SqlWhere where = new SqlWhere();
        where.add(VanSysCode.TYPE_ID, typeId);
        if(typeId!="000")
        	where.add(VanSysCode.CODE_DATA4, "*");
        return this.vanSysCodeModel.queryDistinct(where, queryCount);
    }

    /**
     * 取得VanSysCode之Code_ID,Code_Data3
     */
    public List<VanSysCode> getSysCodeDataByTypeId(String typeId) throws XdaoException {
        int queryCount = -1;
        String param = VanSysCode.CODE_ID + "," + VanSysCode.CODE_DATA3;
        SqlWhere where = new SqlWhere();
        where.add(VanSysCode.TYPE_ID, typeId);
        where.add(VanSysCode.CODE_DATA4, "*");
        
        return this.vanSysCodeModel.querySysCodeDataByTypeId(param,where,queryCount);
    }
   
    /**20150522 2938 配合計費指示修改
     * 取得VanSysCode之Code_ID,orderByCode_Data4
     */
    public List<VanSysCode> getSysCodeByCodeData4(String typeId) throws XdaoException {
        int queryCount = -1;
        String param = VanSysCode.CODE_ID + "," + VanSysCode.CODE_DATA1+ "," + VanSysCode.CODE_DATA2+ "," + VanSysCode.CODE_DATA3+ "," + VanSysCode.CODE_DATA4;
        SqlWhere where = new SqlWhere();
        where.add(VanSysCode.TYPE_ID, typeId);
     
        
        return this.vanSysCodeModel.querySysCodeByCodedata4(param,where,queryCount);
    }
    public List<VanSysCode> queryNotification() throws XdaoException
    {
      String selectStr = "*";
      SqlWhere where = new SqlWhere();
      where.add(VanSysCode.TYPE_ID,"S00");
      int maxRow = -1;
      
      return this.vanSysCodeModel.querySysCodeDataByTypeId(selectStr, where, maxRow);
    }
    
    /**
     * 取得延伸參數設定欄位名稱為dropdownlist的下拉式選單的值
     * 
     * @param query
     * @return
     * @throws XdaoException
     */
    public List<VanSysCode> getTypeIdByCodeData2(String codeData2) throws XdaoException {
        DataObject dataObj = new DataObject();
        dataObj.setValue(VanSysCode.CODE_DATA2, codeData2);
        return this.vanSysCodeModel.queryTemplate("VanSysCode.queryTypeIdByCodeData2",dataObj);
    }
}
