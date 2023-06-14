package tradevan.helpdesk;

import com.tradevan.taurus.xdao.QueryParameter;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;
import com.tradevan.taurus.xdao.XdaoSession;

import java.util.List;

public class VanServiceRoutingExtModel extends DefaultModel {

    public VanServiceRoutingExtModel() {
        super(VanServiceRoutingExt.TABLE_NAME);
        // TODO Auto-generated constructor stub
    }

    /**
     * 新增一筆VanServiceRoutingExt資料
     * @param vanServiceRoutingExt
     * @return
     * @throws XdaoException 
     */
    public int insert(VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
        
    	CommonLib.trimSpace(vanServiceRoutingExt);
    	XdaoSession session = getXdaoSession();
        
        return session.insert(vanServiceRoutingExt);
    }

    /**
     * 查詢一筆資料
     * @param vanServiceRoutingExt
     * @return
     * @throws XdaoException 
     */
    public VanServiceRoutingExt queryOne(VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
        XdaoSession session = getXdaoSession();
        
        SqlWhere where = new SqlWhere();
        where.add(VanServiceRoutingExt.RTG_SEQ_NO, vanServiceRoutingExt.getRtgSeqNo());
        where.add(VanServiceRoutingExt.OBJECT_ID, vanServiceRoutingExt.getObjectId());
        where.add(VanServiceRoutingExt.ARG_ID, vanServiceRoutingExt.getArgId());
        
        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanServiceRoutingExt.class);
        param.where(where);
        
        
        return (VanServiceRoutingExt) session.selectOne(param);
    }

    /**
     * 根據PK刪除一筆資料
     * @param vanServiceRoutingExt
     * @return
     * @throws XdaoException 
     */
    public int delete(VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
        SqlWhere where = new SqlWhere();
        where.add(VanServiceRoutingExt.RTG_SEQ_NO, vanServiceRoutingExt.getRtgSeqNo());
        where.add(VanServiceRoutingExt.OBJECT_ID, vanServiceRoutingExt.getObjectId());
        where.add(VanServiceRoutingExt.ARG_ID, vanServiceRoutingExt.getArgId());
        
        XdaoSession session = getXdaoSession();
        return session.delete(where);
    }

    /**
     * 根據PK來更新資料
     * @param vanServiceRoutingExt
     * @return
     * @throws XdaoException 
     */
    public int update(VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
    	CommonLib.trimSpace(vanServiceRoutingExt);

        SqlWhere where = new SqlWhere();
        where.add(VanServiceRoutingExt.RTG_SEQ_NO, vanServiceRoutingExt.getRtgSeqNo());
        where.add(VanServiceRoutingExt.OBJECT_ID, vanServiceRoutingExt.getObjectId());
        where.add(VanServiceRoutingExt.ARG_ID, vanServiceRoutingExt.getArgId());
        
        XdaoSession session = getXdaoSession();
        return session.update(vanServiceRoutingExt, where);
    }
    

	/**
	 * 取得多筆VanPartyExt資料
	 * @param where
	 * @param qryCount
	 * @return
	 * @throws XdaoException
	 */
	public List<VanServiceRoutingExt> query(SqlWhere where, int qryCount) throws XdaoException
	{

		XdaoSession session = getXdaoSession();

		QueryParameter param = session.getQueryParameter();
		param.setResultClass(VanServiceRoutingExt.class);
		param.where(where);
		if(qryCount >0)
			param.setMaxRow(qryCount);      

		return session.executeQuery(param).toList();
	}

}
