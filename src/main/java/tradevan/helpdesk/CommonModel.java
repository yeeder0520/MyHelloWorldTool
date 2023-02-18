/**
 * APNVAN_V3 com.tradevan.helpdesk.model

 */
package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.QueryParameter;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;
import com.tradevan.taurus.xdao.XdaoSession;

import java.util.List;

/**
 * Title: QryMdcIdxLogModel<br>
 * Description: 提供QryMdcIdxLogService查詢DB、顯示詳細內容<br>
 * Company: Tradevan Co.<br>
 * 
 * @author Li-Chen Chen
 * @since 1.0.0
 */
public class CommonModel extends DefaultModel {

    public CommonModel() {
        super("");
    }
    
    
    public List<DataObject> query(SqlWhere where, String selectField , String tableName , String orderBy , int maxRow , String keepTypeField) throws XdaoException {
    	super.tableName = tableName;
        XdaoSession session = getXdaoSession();
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(DataObject.class);
        param.where(where);
        if (!CommonLib.isNullOrEmpty(orderBy))
        	param.orderBy(orderBy);
        if (!CommonLib.isNullOrEmpty(keepTypeField))
        	param.setKeepTypeField(keepTypeField);
        if (maxRow != 0)
        	param.setMaxRow(maxRow);
        if (!CommonLib.isNullOrEmpty(selectField))
        	param.select(selectField);
        return session.executeQuery(param).toList();
    }
    

    /**
     * 取得APKey多項Table資料
     * @param where
     * @param maxRow 
     * @return
     * @throws XdaoException
     */
    public List<VanMsgLogExt> queryMsgLogExt(SqlWhere where, String selectField , String tableName , String orderBy , int maxRow) throws XdaoException {
    	super.tableName = tableName;
        XdaoSession session = getXdaoSession();
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanMsgLogExt.class);
        param.orderBy(orderBy);
        param.where(where);
        if (maxRow != 0)
        	param.setMaxRow(maxRow);
        param.select(selectField);
        return session.executeQuery(param).toList();
    }


    
    
    /**
     * 取得VanDsmsMailBox多項Table資料
     * @param where
     * @param maxRow 
     * @return
     * @throws XdaoException
     */
    public List<VanDsmsMailbox> queryDsmsMailboxForExt2(SqlWhere where, String selectField , String tableName , String orderBy , int maxRow) throws XdaoException {
        super.tableName = tableName;
        XdaoSession session = getXdaoSession();
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanDsmsMailbox.class);
        
        param.orderBy(orderBy);
        param.where(where);
        param.setDistinct(true);

        if (maxRow != 0)
            param.setMaxRow(maxRow);
        param.select(selectField);
        return session.executeQuery(param).toList();
    }
}
