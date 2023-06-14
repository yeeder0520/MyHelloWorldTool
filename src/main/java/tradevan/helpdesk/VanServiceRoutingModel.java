package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.*;

import java.util.List;

/**
 * Title: VanServiceRoutingModel<br>
 * Description: 提供VanServiceRoutingService新增、刪除、修改、查詢DB。<br>
 * Company: Tradevan Co.<br>
 * 
 * @author I-Chun Huang
 * @since 1.0.0
 */
public class VanServiceRoutingModel extends DefaultModel {

    public VanServiceRoutingModel() {
        super(VanServiceRouting.TABLE_NAME);
        // TODO Auto-generated constructor stub
    }

    /**
     * 取得多筆VanServiceRouting資料
     * @param where
     * @return
     * @throws XdaoException 
     */
    public List<VanServiceRouting> query(SqlWhere where) throws XdaoException {
        XdaoSession session = getXdaoSession();
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanServiceRouting.class);
        param.where(where);
        param.setMaxRow(-1);
        
        return session.executeQuery(param).toList();
    }
    
    /**
     * 取得VanServiceRouting資料
     * @param where
     * @param String
     * @param String
     * @param String
     * @param maxRow 
     * @return
     * @throws XdaoException
     */
    public List<MainVanCustCCSLine> query(SqlWhere where, String selectField, String from, String orderBy, int maxRow) throws XdaoException {
        XdaoSession session = getXdaoSession();
        QueryParameter param = session.getQueryParameter();
        param.orderBy(orderBy);
        param.setResultClass(MainVanCustCCSLine.class);
        param.where(where);
        if (maxRow != 0)
        	param.setMaxRow(maxRow);
        param.select(selectField);
        param.from(from);
        return session.executeQuery(param).toList();
    }

    /**
     * 取得一筆VanServiceRouting資料
     * @param vanServiceRouting
     * @return
     * @throws XdaoException 
     */
    public VanServiceRouting queryOne(VanServiceRouting vanServiceRouting) throws XdaoException {
        XdaoSession session = getXdaoSession();
        
        SqlWhere where = new SqlWhere();
        where.add(VanServiceRouting.RTG_SEQ_NO, vanServiceRouting.getRtgSeqNo());
        
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanServiceRouting.class);
        param.where(where);
        
        return (VanServiceRouting) session.selectOne(param);
    }

    /**
     * 新增一筆VanServiceRouting資料
     * @param vanServiceRouting
     * @return
     * @throws XdaoException 
     */
    public int insert(VanServiceRouting vanServiceRouting) throws XdaoException {
    	CommonLib.trimSpace(vanServiceRouting);

        XdaoSession session = getXdaoSession();       
        return session.insert(vanServiceRouting);
    }

    /**
     * 更新一筆VanServiceRouting資料
     * @param vanServiceRouting
     * @return
     * @throws XdaoException 
     */
    public int update(VanServiceRouting vanServiceRouting) throws XdaoException {
    	CommonLib.trimSpace(vanServiceRouting);
    	SqlWhere where = new SqlWhere();
        where.add(VanServiceRouting.RTG_SEQ_NO, vanServiceRouting.getRtgSeqNo());     
        XdaoSession session = getXdaoSession();
               
        return session.update(vanServiceRouting, where);
    }

    /**
     * 刪除一筆VanServiceRouting資料
     * @param vanServiceRouting
     * @return
     * @throws XdaoException 
     */
    public int delete(VanServiceRouting vanServiceRouting) throws XdaoException {
    	XdaoSession session = getXdaoSession();      
        SqlWhere where = new SqlWhere();
        where.add(VanServiceRouting.RTG_SEQ_NO, vanServiceRouting.getRtgSeqNo());
        
        return session.delete(where);
    }
    
    /**
     * 依照傳入的where條件刪除VanServiceRouting資料
     * @param SqlWhere
     * @return
     * @throws XdaoException 
     */
    public int delete(SqlWhere where) throws XdaoException {
    	XdaoSession session = getXdaoSession();  
        return session.delete(where);
    }

    /**
     * 根據templateName跟predicate來取得多筆VanServiceRouting資料
     * @param templateName
     * @param predicate
     * @return
     * @throws XdaoException 
     */
    public List<VanServiceRouting> queryTemplate(String templateName, DataObject predicate) throws XdaoException {
        XdaoTemplate template = getXdaoTemplate();
        TemplateResult result = template.executeQuery(templateName, predicate);
        
        return result.getResult().toList();
    }

}
