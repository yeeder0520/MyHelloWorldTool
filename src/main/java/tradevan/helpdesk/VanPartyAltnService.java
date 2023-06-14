package tradevan.helpdesk;

import com.tradevan.taurus.xdao.SqlPredicate;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;

import java.sql.Timestamp;
import java.util.*;

/**
 * Title: VanPartyAltnService<br>
 * Description: 提供MainVanPartyAltnAction新增、刪除、修改、查詢DB、顯示詳細內容。<br>
 * Company: Tradevan Co.<br>
 * 
 * @author I-Chun Huang & Li-Chen Chen
 * @since 1.0.0
 */
public class VanPartyAltnService {
	public static final VanPartyAltnService INSTANCE = new VanPartyAltnService();
	private VanPartyAltnModel vanPartyAltnModel = new VanPartyAltnModel();

	/**
	 * 取得VaPartyAltn的相關物件
	 *
	 * @param query
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyAltn> queryByDef(Map query) throws XdaoException {
		SqlWhere where = new SqlWhere();

		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.ID))
			//            where.add(VanPartyAltn.ID, (String) query.get(VanPartyAltn.ID));
			where.add(new SqlPredicate(VanPartyAltn.ID,"like", "%"+query.get(VanPartyAltn.ID)+"%"));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.PARTY_ID))
			where.add(VanPartyAltn.PARTY_ID, (String) query.get(VanPartyAltn.PARTY_ID));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.BILLING_STATUS))
			where.add(VanPartyAltn.BILLING_STATUS, (String) query.get(VanPartyAltn.BILLING_STATUS));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.BILLING_INDICATOR))
			where.add(VanPartyAltn.BILLING_INDICATOR, (String) query.get(VanPartyAltn.BILLING_INDICATOR));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.ARRIVAL_DATE_FLAG))
			where.add(VanPartyAltn.ARRIVAL_DATE_FLAG, (String) query.get(VanPartyAltn.ARRIVAL_DATE_FLAG));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.PARTNER_ID))
			where.add(VanPartyAltn.PARTNER_ID, (String) query.get(VanPartyAltn.PARTNER_ID));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.BILLING_ZIPPED))
			where.add(VanPartyAltn.BILLING_ZIPPED, (String) query.get(VanPartyAltn.BILLING_ZIPPED));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.HOLD_FLAG))
			where.add(VanPartyAltn.HOLD_FLAG, (String) query.get(VanPartyAltn.HOLD_FLAG));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.HOLD_TIME))
			where.add(VanPartyAltn.HOLD_TIME, (String) query.get(VanPartyAltn.HOLD_TIME));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.COST_ID))
			where.add(VanPartyAltn.COST_ID, (String) query.get(VanPartyAltn.COST_ID));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.NOTE1))
			where.add(VanPartyAltn.NOTE1, (String) query.get(VanPartyAltn.NOTE1));
		if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.VIA_HUB_ID))
			where.add(VanPartyAltn.VIA_HUB_ID, (String) query.get(VanPartyAltn.VIA_HUB_ID));

		int qryCount = -1;
		if (!CommonLib.isNullOrEmpty(query, "QRY_COUNT"))
			qryCount = (Integer.parseInt((String) query.get("QRY_COUNT")));

		return this.vanPartyAltnModel.query(where, qryCount);
	}

	/**
	 * 根據PK取得VanPartyAltn的相關物件
	 *
	 * @param vanPartyAltn
	 * @return
	 * @throws XdaoException
	 */
	public VanPartyAltn getVanPartyAltnbyPkey(VanPartyAltn vanPartyAltn)
	throws XdaoException {

		return this.vanPartyAltnModel.queryOne(vanPartyAltn);
	}

	/**
	 * 插入VanPartyAltn
	 *
	 * @param vanPartyAltn
	 * @return
	 * @throws XdaoException
	 */
	public int insVanPartyAltn(VanPartyAltn vanPartyAltn) throws XdaoException {
		vanPartyAltn.setValue(VanPartyAltn.CT_DTS, new Timestamp(new Date().getTime()));
		vanPartyAltn.setValue(VanPartyAltn.OP_DTS, new Timestamp(new Date().getTime()));

		return this.vanPartyAltnModel.insert(vanPartyAltn);
	}

	/**
	 * 更新VanPartyAltn
	 *
	 * @param vanPartyAltnList
	 * @param opId
	 * @param newCustomerId
	 * @return
	 * @throws XdaoException
	 */
	public List<List> updVanPartyAltn(List<VanPartyAltn> vanPartyAltnList, String newCustomerId, String opId) throws XdaoException {
		List<VanPartyAltn> oldVanPartyAltnList = null;
		List <VanPartyAltn> newVanPartyAltnList = null;
		List <List> result = null;
		VanPartyAltn vanPartyAltn;
		VanPartyAltn oldVanPartyAltn;
		DefaultModel.beginTransaction();
		try{
			oldVanPartyAltnList = new ArrayList<VanPartyAltn>();
			newVanPartyAltnList = new ArrayList<VanPartyAltn>();
			result = new ArrayList<List>();
			for(int i=0; i<vanPartyAltnList.size(); ++i){
				vanPartyAltn = vanPartyAltnList.get(i);
				oldVanPartyAltn = new  VanPartyAltn();
				if(vanPartyAltn.isChecked()){
					oldVanPartyAltn.setPartyId(vanPartyAltn.getPartyId());
					oldVanPartyAltnList.add(oldVanPartyAltn);
					vanPartyAltn.setPartyId(newCustomerId);
					vanPartyAltn.setOpId(opId);
					vanPartyAltn.setValue(VanPartyAltn.OP_DTS, new Timestamp(new Date().getTime()));
					this.vanPartyAltnModel.update(vanPartyAltn);
					newVanPartyAltnList.add(this.getVanPartyAltnbyPkey(vanPartyAltn));
				}
			}
			DefaultModel.commit();
		}catch(XdaoException e){
			DefaultModel.rollback();
			throw e;
		}

		result.add(oldVanPartyAltnList);
		result.add(newVanPartyAltnList);

		return result;
	}

	/**
	 * 根據PK刪除VanPartyAltn的相關物件
	 *
	 * @param vanPartyAltn
	 * @return
	 * @throws XdaoException
	 */
	public int delVanPartyAltn(VanPartyAltn vanPartyAltn) throws XdaoException {
		// TODO Auto-generated method stub
		return this.vanPartyAltnModel.delete(vanPartyAltn);
	}

	/**
	 * 根據partyID(&ID)取得VanPartyAltn的相關物件。
	 *
	 * @param partyId
	 * @param id
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyAltn> queryByIds(String partyId, String id,String qryCount)
	throws XdaoException {
		SqlWhere where = new SqlWhere();
		int count;
		where.add(VanPartyAltn.PARTY_ID, partyId);
		if (!CommonLib.isNullOrEmpty(id))
			where.add(VanPartyAltn.ID, id);
		if(!CommonLib.isNullOrEmpty( qryCount))
			count=Integer.parseInt(qryCount);
		else
			count = -1;
		System.out.println("~~~~~~~~~~~~~~~~~~~~"+count);
		return this.vanPartyAltnModel.query(where, count);
	}

	/**
	 * 跟據qryPartyId取得VanPartyProf的相關物件
	 * @param qryPartyId
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyAltn> queryByPartyId(String qryPartyId) throws XdaoException {
		SqlWhere where = new SqlWhere();
		where.add(VanPartyProf.PARTY_ID, qryPartyId);

		return this.vanPartyAltnModel.queryNoCntLimit(where, -1);
	}

	/**
	 * 更新VanPartyAltn
	 * @param vanPartyAltn
	 * @return
	 * @throws XdaoException
	 */
	public int updVanPartyAltn(VanPartyAltn vanPartyAltn) throws XdaoException {
		int rtnCode = -1;
		vanPartyAltn.setValue(VanPartyAltn.OP_DTS, new Timestamp(new Date().getTime()));
		DefaultModel.beginTransaction();
		try{
			rtnCode = this.vanPartyAltnModel.update(vanPartyAltn);
			DefaultModel.commit();
		}catch(XdaoException e){
			DefaultModel.rollback();
			throw e;
		}
		return rtnCode;
	}

	/**
	 * 取得包含用戶代碼的下拉選單
	 * @param partyId
	 * @return List<Map>
	 * @throws XdaoException
	 */
	public List<Map> getIds(String partyId) throws XdaoException {
		List<Map> idList = new ArrayList<Map>();
		
		//新增該筆用戶代碼
		Map map = new HashMap();
		map.put(VanPartyAltn.PARTY_ID, partyId);
		idList.add(map);
		
		//新增該筆用戶代碼下的交易代碼
		List<VanPartyAltn> vanPartyAltnList = VanPartyAltnService.INSTANCE.queryByPartyId(partyId);
		for (VanPartyAltn tmpvpa : vanPartyAltnList) {
			map = new HashMap();
			map.put(VanPartyAltn.PARTY_ID, tmpvpa.getId());
			idList.add(map);
		}

		return idList;
	}

    /**
     * 跟據系統代碼的PartyId清單取得VanPartyAltn的相關物件
     * @param query
     * @return List<VanPartyProf>
     * @throws XdaoException
     */
    public List<VanPartyAltn> queryByCustomPartyId(Map query) throws XdaoException {

        //從van_sys_code取得海關清單
        List<VanSysCode> vanSysCodeList = VanSysCodeService.INSTANCE.queryForAjax("C07", null, "-1");
        //回傳資料
        List<VanPartyAltn> vpaList = new ArrayList<VanPartyAltn>();

        //只有當海關清單上有資料才開始查詢
        if (vanSysCodeList != null && vanSysCodeList.size() != 0) {
            int vanSysCodeListSize = vanSysCodeList.size();
            SqlWhere where = new SqlWhere();
            if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.ID))
                where.add(new SqlPredicate(VanPartyAltn.ID, "LIKE", "%"+query.get(VanPartyAltn.ID)+"%"));
            if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.HOLD_FLAG))
                where.add(VanPartyAltn.HOLD_FLAG, query.get(VanPartyAltn.HOLD_FLAG));
            if (!CommonLib.isNullOrEmpty(query, VanPartyAltn.PARTY_ID))
                where.add(new SqlPredicate(VanPartyAltn.PARTY_ID, "LIKE", "%"+query.get(VanPartyAltn.PARTY_ID)+"%"));

            StringBuffer sb = new StringBuffer();
            sb.append("(");
            for ( int i = 0; i < vanSysCodeListSize; i++ ) {
                VanSysCode vanSysCode = vanSysCodeList.get(i);
//              if (CommonConstant.CUSTOM.equals(vanSysCode.getCodeData1())){
                    sb.append("'");
                    sb.append(vanSysCode.getCodeData2());
                    sb.append("'");
                    if ( i != vanSysCodeListSize - 1)
                        sb.append(",");
//              }
            }
            sb.append(")");
            SqlPredicate pred = new SqlPredicate(VanPartyAltn.PARTY_ID , "IN" , sb , false);
            pred.setPreparedMode(false);
            where.add(pred);

            String orderBy = VanPartyAltn.HOLD_FLAG +" DESC, "+ VanPartyAltn.PARTY_ID;

            vpaList = this.vanPartyAltnModel.queryNoCntLimit(where, 5000, orderBy);
        }

        return vpaList;
    }

	public static void main(String[] args) throws XdaoException {
		VanPartyExt vanPartyExt = new VanPartyExt();
		vanPartyExt.setPartyId("tv2938test");
		VanPartyExt qryObj = VanPartyExtService.INSTANCE.queryByPK(vanPartyExt);
		System.out.println("qryObj = " + qryObj);
	}

}