package tradevan.helpdesk;

import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;
import org.apache.commons.collections.MapUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class VanServiceRoutingExtService {
    public static VanServiceRoutingExtService INSTANCE = new VanServiceRoutingExtService();
    private VanServiceRoutingExtModel vanServiceRoutingExtModel = new VanServiceRoutingExtModel();
    
    /**
     * 根據PK 取得一筆資料
     * @param rtgSeqNo
     * @param objectId
     * @param argId
     * @return
     * @throws XdaoException 
     */
    public VanServiceRoutingExt qryByPkey(VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
        // TODO Auto-generated method stub
        return this.vanServiceRoutingExtModel.queryOne(vanServiceRoutingExt);
    }

    /**
     * 根據PK 取得一筆資料
     * @param rtgSeqNo
     * @param objectId
     * @param argId
     * @return
     * @throws XdaoException 
     */
    public VanServiceRoutingExt qryVanServiceRoutingExtByPkey(VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
        // TODO Auto-generated method stub
        return this.vanServiceRoutingExtModel.queryOne(vanServiceRoutingExt);
    }
	public int insVanServiceRoutingExt(VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
		vanServiceRoutingExt.setValue(vanServiceRoutingExt.OP_DTS, new Timestamp(new Date().getTime()));
		vanServiceRoutingExt.setValue(vanServiceRoutingExt.CT_DTS, new Timestamp(new Date().getTime()));
		return this.vanServiceRoutingExtModel.insert(vanServiceRoutingExt);
	}


	/**
	 * 查詢相同的RTGSEQNO, ARG_ID
	 * @param PARTY_ID
	 * @param ARG_ID
	 * @return
	 * @throws XdaoException
	 */
	public List<VanServiceRoutingExt> queryByRtgId(String rtgSeqNo) throws XdaoException{
		VanServiceRoutingExt predicate = new VanServiceRoutingExt();
		predicate.setRtgSeqNo(rtgSeqNo);
		SqlWhere where =new SqlWhere();
		where.add(VanServiceRoutingExt.RTG_SEQ_NO,  rtgSeqNo);
	

		return vanServiceRoutingExtModel.query(where, 0);
		}
	
	

	public List<VanServiceRoutingExt> queryByDef(Map query) throws XdaoException {
		VanServiceRoutingExt predicate = new VanServiceRoutingExt();
		String rtgNo = MapUtils.getString(query, VanServiceRoutingExt.RTG_SEQ_NO, "");
				
				String objectId = MapUtils.getString(query, VanServiceRoutingExt.OBJECT_ID, "");
				String argId = MapUtils.getString(query, VanServiceRoutingExt.ARG_ID, "");

				predicate.setRtgSeqNo(rtgNo);
				SqlWhere where = new SqlWhere();
				if (!"".equals(rtgNo)) {
					where.add(VanServiceRoutingExt.RTG_SEQ_NO,  rtgNo);
				}
			
				if (!"".equals(argId)) {
					where.add(VanServiceRoutingExt.ARG_ID,  argId);
				}
				if (!"".equals(objectId)) {
					where.add(VanServiceRoutingExt.OBJECT_ID,  objectId);
				}
//				
//	
				int queryCount = -1;
				if(!CommonLib.isNullOrEmpty(query, CommonConstant.QRY_COUNT))
					queryCount = Integer.parseInt((String)query.get(CommonConstant.QRY_COUNT));

				return vanServiceRoutingExtModel.query(where, queryCount);
	}

	public int updVanServiceRoutingExt(VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
		int rtnCode = 0;
		DefaultModel.beginTransaction();
		vanServiceRoutingExt.setValue(vanServiceRoutingExt.OP_DTS, new Timestamp(new Date().getTime()));
		
		rtnCode = this.vanServiceRoutingExtModel.update(vanServiceRoutingExt);

		DefaultModel.commit();
	

		return rtnCode;
	}

	public int delVanServiceRoutingExt(VanServiceRoutingExt vanServiceRoutingExt) throws XdaoException {
		int rtnCode = 0;
		DefaultModel.beginTransaction();
		rtnCode = this.vanServiceRoutingExtModel.delete(vanServiceRoutingExt);

		DefaultModel.commit();
		return rtnCode;
	}


	
    
    

}
