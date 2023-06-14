package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.*;

import java.util.List;

/**
 * Title: VanSysCodeModel<br>
 * Description: 提供VanSysCodeService新增、刪除、修改、查詢DB。<br>
 * Company: Tradevan Co.<br>
 * 
 * @author I-Chun Huang
 * @since 1.0.0
 */
public class VanSysCodeModel extends DefaultModel {

    public VanSysCodeModel( ) {
        super(VanSysCode.TABLE_NAME);
    }

    
    /**
     * 查詢多筆MdcMsgDbMap資料
     * @param where
     * @param maxRow
     * @return
     * @throws XdaoException
     */
    public List<VanSysCode> query(SqlWhere where, int maxRow) throws XdaoException {
        XdaoSession session = getXdaoSession();
        
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanSysCode.class);
        param.where(where);
        param.orderBy("TYPE_ID, CODE_ID");
        if(maxRow > 0 || maxRow == -1)
            param.setMaxRow(maxRow);
        
        return session.executeQuery(param).toList();
    }
    
    public List queryMax(String selectStr, String table, SqlWhere where, int maxRow) throws XdaoException{
      XdaoSession session = getXdaoSession();
      QueryParameter param = session.getQueryParameter();
      param.setResultClass(VanSysCode.class);
      param.select(selectStr);
      param.from(table);
      param.where(where);
      param.setMaxRow(maxRow);
      
      return session.executeQuery(param).toList();
    }

    /**
     * 查詢多筆MdcMsgDbMap資料
     * @param where
     * @param maxRow
     * @return
     * @throws XdaoException
     */
    public List<VanSysCode> queryDistinct(SqlWhere where, int maxRow) throws XdaoException {
        XdaoSession session = getXdaoSession();
        
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanSysCode.class);
        param.where(where);
        param.orderBy("TYPE_ID, CODE_ID");
        param.setDistinct(true);
        if(maxRow > 0 || maxRow == -1)
            param.setMaxRow(maxRow);
        
        return session.executeQuery(param).toList();
    }
    
    /**
     * 查詢一筆VanSysCode資料
     * @param vanSysCode
     * @return
     * @throws XdaoException 
     */
    public VanSysCode queryOne(VanSysCode vanSysCode) throws XdaoException {
        XdaoSession session = getXdaoSession();
        
        SqlWhere where = new SqlWhere();
        where.add(VanSysCode.TYPE_ID, vanSysCode.getTypeId());
        where.add(VanSysCode.CODE_ID, vanSysCode.getCodeId());
        
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanSysCode.class);
        param.where(where);
        
        return (VanSysCode)session.selectOne(param);
    }

    /**
     * 插入VanSysCode資料
     * @param vanSysCode
     * @return
     * @throws XdaoException 
     */
    public int insert(VanSysCode vanSysCode) throws XdaoException {
    	
    	CommonLib.trimSpace(vanSysCode);

        int rtnCode = 0;
        XdaoSession session = getXdaoSession();
        session.beginTransaction();
        try {
            rtnCode = session.insert(vanSysCode);
            session.commit();
        } catch (XdaoException e) {
            session.rollback();
            throw e;
        }
        
        return rtnCode;
        
        
    }

    /**
     * 更新VanSysCode資料
     * @param vanSysCode
     * @return
     * @throws XdaoException 
     */
    public int update(VanSysCode vanSysCode) throws XdaoException {
    	CommonLib.trimSpace(vanSysCode);
        XdaoSession session = getXdaoSession();
        
        SqlWhere where = new SqlWhere();
        where.add(VanSysCode.TYPE_ID, vanSysCode.getTypeId());
        where.add(VanSysCode.CODE_ID, vanSysCode.getCodeId());
            
        return session.update(vanSysCode, where);
    }

    /**
     * 刪除VanSysCode資料
     * @param vanSysCode
     * @return
     * @throws XdaoException 
     */
    public int delete(VanSysCode vanSysCode) throws XdaoException {
      XdaoSession session = getXdaoSession();
      
      SqlWhere where = new SqlWhere();
      where.add(VanSysCode.TYPE_ID, vanSysCode.getTypeId());
      where.add(VanSysCode.CODE_ID, vanSysCode.getCodeId());
      
      return session.delete(where);
  }
    
    public int deleteByPKey(String key) throws XdaoException {
      XdaoSession session = getXdaoSession();
      
      SqlWhere where = new SqlWhere();
      where.add(VanSysCode.TYPE_ID, "S00");
      where.add(VanSysCode.CODE_ID, key);
      
      return session.delete(where);
  }
    
    public List<VanSysCode> querySysCodeDataByTypeId(String selectStr,SqlWhere where,int maxRow) throws XdaoException {
        XdaoSession session = getXdaoSession();
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanSysCode.class);
        param.select(selectStr).from(VanSysCode.TABLE_NAME).where(where);
        param.setMaxRow(maxRow);
        param.orderBy(VanSysCode.CODE_DATA4);
        
        return session.executeQuery(param).toList();
    }
    //20150522 2938 配合計費指示修改
    public List<VanSysCode> querySysCodeByCodedata4(String selectStr,SqlWhere where,int maxRow) throws XdaoException {
        XdaoSession session = getXdaoSession();
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanSysCode.class);
        param.select(selectStr).from(VanSysCode.TABLE_NAME).where(where);
        param.setMaxRow(maxRow);
        param.orderBy(VanSysCode.CODE_DATA4+"  ASC");
        
        return session.executeQuery(param).toList();
    }
    /**
     * 利用template查詢多筆資料
     * @param templateName
     * @param predicate
     * @return
     * @throws XdaoException
     */
    public List<VanSysCode> queryTemplate(String templateName, DataObject predicate) throws XdaoException {
        XdaoTemplate template = getXdaoTemplate();
        TemplateResult result = template.executeQuery(templateName, predicate);
        return result.getResult().toList();
    }
    
}
