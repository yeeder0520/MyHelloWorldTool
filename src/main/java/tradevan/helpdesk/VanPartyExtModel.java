package tradevan.helpdesk;

import com.tradevan.taurus.xdao.*;

import java.util.List;

public class VanPartyExtModel extends DefaultModel {
	protected static XdaoFactory factory = XdaoFactory.getInstance();
	public VanPartyExtModel() {
		super(VanPartyExt.TABLE_NAME);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 取得多筆VanPartyExt資料
	 * @param where
	 * @param qryCount
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyExt> query(SqlWhere where, int qryCount) throws XdaoException
	{

		XdaoSession session = getXdaoSession();

		QueryParameter param = session.getQueryParameter();
		param.setResultClass(VanPartyExt.class);
		param.where(where);
		if(qryCount >0)
			param.setMaxRow(qryCount);      

		return session.executeQuery(param).toList();
	}

	/**
	 * 查詢一筆VanPartyExt資料
	 * @param vanPartyExt
	 * @return
	 * @throws XdaoException 
	 */
	public VanPartyExt queryOne(VanPartyExt vanPartyExt) throws XdaoException {
		XdaoSession session = getXdaoSession();

		SqlWhere where = new SqlWhere();
		where.add(VanPartyExt.PARTY_ID, vanPartyExt.getPartyId());
		where.add(VanPartyExt.EXT_TYPE, vanPartyExt.getExtType());
		where.add(VanPartyExt.EXT_ID, vanPartyExt.getExtId());
		where.add(VanPartyExt.OBJECT_ID, vanPartyExt.getObjectId());
		where.add(VanPartyExt.ARG_ID, vanPartyExt.getArgId());

		QueryParameter param = session.getQueryParameter();
		param.setResultClass(VanPartyExt.class);
		param.where(where);

		return (VanPartyExt)session.selectOne(param);
	}

	/**
	 * 插入VanPartyExt資料
	 * @param vanPartyExt
	 * @return
	 * @throws XdaoException 
	 */
	public int insert(VanPartyExt vanPartyExt) throws XdaoException {
		CommonLib.trimSpace(vanPartyExt);

		int rtnCode = 0;        
		XdaoSession session = getXdaoSession();

		try {
			session.beginTransaction();
			rtnCode = session.insert(vanPartyExt);
			session.commit();
		} catch (XdaoException e) {
			session.rollback();
			throw e;
		}

		return rtnCode;
	}

	/**
	 * 更新VanPartyExt資料
	 * @param vanPartyExt
	 * @return
	 * @throws XdaoException 
	 */
	public int update(VanPartyExt vanPartyExt) throws XdaoException {
		CommonLib.trimSpace(vanPartyExt);
		XdaoSession session = getXdaoSession();

		SqlWhere where = new SqlWhere();
		where.add(VanPartyExt.PARTY_ID, vanPartyExt.getPartyId());
		where.add(VanPartyExt.ARG_ID, vanPartyExt.getArgId());

		return session.update(vanPartyExt, where);
	}
	
	/**
	 * 更新VanPartyExtN資料
	 * @param vanPartyExt
	 * @return
	 * @throws XdaoException 
	 */
	public int updByPK(VanPartyExt vanPartyExt) throws XdaoException {
		CommonLib.trimSpace(vanPartyExt);
		XdaoSession session = getXdaoSession();

		SqlWhere where = new SqlWhere();
		where.add(VanPartyExt.PARTY_ID, vanPartyExt.getPartyId());
		where.add(VanPartyExt.EXT_ID, vanPartyExt.getExtId());
		where.add(VanPartyExt.EXT_TYPE, vanPartyExt.getExtType());
		where.add(VanPartyExt.OBJECT_ID, vanPartyExt.getObjectId());
		where.add(VanPartyExt.ARG_ID, vanPartyExt.getArgId());

		return session.update(vanPartyExt, where);
	}

	/**
	 * 刪除VanPartyExt資料
	 * @param vanPartyExt
	 * @return
	 * @throws XdaoException 
	 */
	public int delByPK(VanPartyExt vanPartyExt) throws XdaoException {
		XdaoSession session = getXdaoSession();
		SqlWhere where = new SqlWhere();
		where.add(VanPartyExt.PARTY_ID, vanPartyExt.getPartyId());
		where.add(VanPartyExt.EXT_ID, vanPartyExt.getExtId());
		where.add(VanPartyExt.EXT_TYPE, vanPartyExt.getExtType());
		where.add(VanPartyExt.OBJECT_ID, vanPartyExt.getObjectId());
		where.add(VanPartyExt.ARG_ID, vanPartyExt.getArgId());

		return session.delete(where);
	}

	/**
	 * 刪除VanPartyExt資料
	 * @param vanPartyExt
	 * @return
	 * @throws XdaoException 
	 */
	public int delByPartyId(VanPartyExt vanPartyExt) throws XdaoException {
		XdaoSession session = getXdaoSession();
		SqlWhere where = new SqlWhere();
		where.add(VanPartyExt.PARTY_ID, vanPartyExt.getPartyId());

		return session.delete(where);
	}
}
