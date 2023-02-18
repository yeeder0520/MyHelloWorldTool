package tradevan.helpdesk;

import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.*;

import java.util.List;

public class VanMsgLogExt2Model extends DefaultModel {

    public VanMsgLogExt2Model() {
        super(VanMsgLogExt2.TABLE_NAME);
        // TODO Auto-generated constructor stub
    }

    /**
     * 查詢多筆VanMsgLogExt資料
     * @param where
     * @param maxRow
     * @return
     * @throws XdaoException 
     */
    public List<VanMsgLogExt2> query(SqlWhere where, int maxRow) throws XdaoException {
        XdaoSession session = getXdaoSession();
        
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanMsgLogExt2.class);
        param.orderBy(VanMsgLogExt2.ARG_ID);
        param.orderBy(VanMsgLogExt2.EXT_ID);

        param.where(where);
        if(maxRow > 0)
            param.setMaxRow(maxRow);
        
        return session.executeQuery(param).toList();
    }
    
    
    /**
    * 查詢單筆VanMsgLogExt資料
    * @param where
    * @param maxRow
    * @return
    * @throws XdaoException 
    */
   public VanMsgLogExt2 queryOne(SqlWhere where) throws XdaoException {
       XdaoSession session = getXdaoSession();
       
       QueryParameter param = session.getQueryParameter();
       param.setResultClass(VanMsgLogExt2.class);
       param.where(where);
//       if(maxRow > 0)
//           param.setMaxRow(maxRow);
       
       return (VanMsgLogExt2) session.selectOne(where);
   }
    
    public List<VanMsgLogExt2>queryTemplate(String templateName, DataObject predicate) throws XdaoException {
        XdaoTemplate template = getXdaoTemplate();
        TemplateResult result = template.executeQuery(templateName, predicate);
        
        return result.getResult().toList();
    }
}
