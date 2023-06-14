package tradevan.helpdesk;

import com.tradevan.taurus.xdao.*;
import org.apache.commons.validator.GenericValidator;

import java.util.List;

/**
 * Title: VanPartyAltnModel<br>
 * Description: 提供VanPartyAltnService新增、刪除、修改、查詢DB、顯示詳細。<br>
 * Company: Tradevan Co.<br>
 * 
 * @author I-Chun Huang & Li-Chen Chen
 * @since 1.0.0
 */
public class VanPartyAltnModel extends DefaultModel {

	protected static XdaoFactory factory = XdaoFactory.getInstance();

	public VanPartyAltnModel() {
		super(VanPartyAltn.TABLE_NAME);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 取得多筆VanPartyAltn資料
	 * @param where
	 * @param qryCount
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyAltn> query(SqlWhere where, int qryCount) throws XdaoException {
		XdaoSession session = getXdaoSession();

		QueryParameter param = session.getQueryParameter();
		param.setResultClass(VanPartyAltn.class);
		param.where(where);
		if(qryCount >0)
			param.setMaxRow(qryCount);      

		return session.executeQuery(param).toList();
	}

	public List<VanPartyAltn> querybydef(String selectStr,String fromTable,SqlWhere where,String orderBy,int maxRow) throws XdaoException {
		XdaoSession session = getXdaoSession();
		QueryParameter param = session.getQueryParameter();
		param.setResultClass(VanPartyAltn.class);
		param.select(selectStr).from(fromTable).where(where);
		param.setMaxRow(maxRow);
		param.orderBy(orderBy);
		//return null;
		return session.executeQuery(param).toList();
	}

	/**
	 * 取得多筆VanPartyAltn資料
	 * @param where
	 * @param qryCount
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyAltn> queryNoCntLimit(SqlWhere where, int qryCount) throws XdaoException {
		XdaoSession session = getXdaoSession();

		QueryParameter param = session.getQueryParameter();
		param.setResultClass(VanPartyAltn.class);
		param.where(where);
		param.setMaxRow(qryCount);      

		return session.executeQuery(param).toList();
	}
    /**
     * 取得多筆VanPartyAltn資料
     * @param where
     * @param qryCount
     * @return
     * @throws XdaoException
     */
    public List<VanPartyAltn> queryNoCntLimit(SqlWhere where, int qryCount, String orderBy) throws XdaoException {
        XdaoSession session = getXdaoSession();

        QueryParameter param = session.getQueryParameter();
        param.setResultClass(VanPartyAltn.class);
        param.where(where);
        param.setMaxRow(qryCount);
        if(!GenericValidator.isBlankOrNull(orderBy)) {
            param.orderBy(orderBy);
        }
        return session.executeQuery(param).toList();
    }
	
	
	/**
	 * 查詢一筆VanPartyAltn資料
	 * @param vanPartyAltn
	 * @return
	 * @throws XdaoException 
	 */
	public VanPartyAltn queryOne(VanPartyAltn vanPartyAltn) throws XdaoException {
		XdaoSession session = getXdaoSession();

		SqlWhere where = new SqlWhere();
		where.add(vanPartyAltn.ID, vanPartyAltn.getId());

		QueryParameter param = session.getQueryParameter();
		param.setResultClass(VanPartyAltn.class);
		param.where(where);

		return (VanPartyAltn) session.selectOne(param);
	}

	/**
	 * 插入VanPartyAltn資料
	 * @param vanPartyAltn
	 * @return
	 * @throws XdaoException 
	 */
	public int insert(VanPartyAltn vanPartyAltn) throws XdaoException {
		CommonLib.trimSpace(vanPartyAltn);

		int rtnCode = 0;        
		XdaoSession session = getXdaoSession();

		try {
			session.beginTransaction();
			rtnCode = session.insert(vanPartyAltn);
			session.commit();
		} catch (XdaoException e) {
			session.rollback();
			throw e;
		}

		return rtnCode;
	}

	/**
	 * 更新VanPartyAltn資料
	 * @param vanPartyAltn
	 * @return
	 * @throws XdaoException 
	 */
	public int update(VanPartyAltn vanPartyAltn) throws XdaoException {
		
		CommonLib.trimSpace(vanPartyAltn);
		XdaoSession session = getXdaoSession();

		SqlWhere where = new SqlWhere();
		where.add(VanPartyAltn.ID, vanPartyAltn.getId());

		return session.update(vanPartyAltn, where);
	}

	/**
	 * 刪除VanPartyAltn資料
	 * @param vanPartyAltn
	 * @return
	 * @throws XdaoException 
	 */
	public int delete(VanPartyAltn vanPartyAltn) throws XdaoException {
		XdaoSession session =getXdaoSession();
		SqlWhere where = new SqlWhere();
		where.add(VanPartyAltn.ID, vanPartyAltn.getId());

		return session.delete(where);
	}


}
