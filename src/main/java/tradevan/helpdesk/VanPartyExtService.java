package tradevan.helpdesk;

import com.tradevan.taurus.xdao.SqlPredicate;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;
import org.apache.commons.collections.MapUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VanPartyExtService {
	public static final VanPartyExtService INSTANCE = new VanPartyExtService();
	private VanPartyExtModel vanPartyExtModel = new VanPartyExtModel();
	

	/**
	 * 查詢ARG_VALUE
	 * @param ARG_VALUE
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyExt> queryByArgValue(String argValue) throws XdaoException{
		
		SqlWhere where =new SqlWhere();
		where.add(VanPartyExt.ARG_VALUE,  argValue);
		where.add(VanPartyExt.OBJECT_ID,"CCS_CUSTPROF");

		return vanPartyExtModel.query(where,0);
	}
	
	/**
	 * 查詢ARG_VALUE
	 * @param ARG_VALUE
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyExt> queryByArgValueByPIMAAddress(String argValue) throws XdaoException{
		
		SqlWhere where =new SqlWhere();
		where.add(VanPartyExt.ARG_VALUE,  argValue);
		where.add(VanPartyExt.OBJECT_ID,"CCS_CUSTPROF");
		where.add(VanPartyExt.ARG_ID,"PIMA_ADDRESS");

		return vanPartyExtModel.query(where,0);
	}
	
	/**
	 * 查詢ARG_VALUE
	 * @param ARG_VALUE
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyExt> queryByArgValueByTypeB(String argValue) throws XdaoException{
		
		SqlWhere where =new SqlWhere();
		where.add(VanPartyExt.ARG_VALUE,  argValue);
		where.add(VanPartyExt.OBJECT_ID,"CCS_CUSTPROF");
		where.add(VanPartyExt.ARG_ID,"TYPEB_ADDRESS");

		return vanPartyExtModel.query(where,0);
	}


	
	/**
	 * 查詢相同的PARTY_ID, ARG_ID
	 * @param PARTY_ID
	 * @param ARG_ID
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyExt> queryByPartyId(String partyId) throws XdaoException{
		VanPartyExt predicate = new VanPartyExt();
		predicate.setPartyId(partyId);
		SqlWhere where =new SqlWhere();
		where.add(VanPartyExt.PARTY_ID,  partyId);
		where.add(VanPartyExt.OBJECT_ID,"CCS_CUSTPROF");

		return vanPartyExtModel.query(where,0);
	}
	
	/**
	 * 查詢相同的PARTY_ID
	 * @param PARTY_ID
	 * @return
	 * @throws XdaoException
	 */
	public VanPartyExt queryByPartyIdbyOne(String partyId) throws XdaoException{ VanPartyExt predicate = new VanPartyExt();
	VanPartyExt vanPartyExt =new VanPartyExt();
	vanPartyExt.setPartyId(partyId);
	vanPartyExt.setArgId(partyId);
	vanPartyExt.setObjectId(partyId);
	vanPartyExt.setExtId("01");
	vanPartyExt.setExtType("S");
	return vanPartyExtModel.queryOne(vanPartyExt);
	}

	/**
	 * 查詢用戶延伸設定檔
	 * @param Map
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyExt> queryByDef(Map query, List<Map> idList) throws XdaoException{
		VanPartyExt predicate = new VanPartyExt();
		String partyId = MapUtils.getString(query, VanPartyExt.PARTY_ID, "");
		String extId = MapUtils.getString(query, VanPartyExt.EXT_ID, "");
		String objectId = MapUtils.getString(query, VanPartyExt.OBJECT_ID, "");
		String argId = MapUtils.getString(query, VanPartyExt.ARG_ID, "");

		predicate.setPartyId(partyId);
		SqlWhere where = new SqlWhere();
		if (!"".equals(partyId)) {
			where.add(VanPartyExt.PARTY_ID,  partyId);
		}
		if (!"".equals(extId)) {
			where.add(VanPartyExt.EXT_ID,  extId);
		}
		if (!"".equals(argId)) {
			where.add(VanPartyExt.ARG_ID,  argId);
		}
		if (!"".equals(objectId)) {
			where.add(VanPartyExt.OBJECT_ID,  objectId);
		}
		
		//排除不為此參與者代碼的資料
    	StringBuffer type = new StringBuffer();
    	for (int i = 0; i < idList.size(); i++) {
    		Map tmap = idList.get(i);
    		String codeId = MapUtils.getString(tmap, VanPartyExt.PARTY_ID);
    		if (i == 0) {
    			type.append("(").append("'").append(codeId).append("'");
    		} else {
    			type.append(",'").append(codeId).append("'");
    		}        		
    		if (i == idList.size()-1) {
    			type.append(")");
    		} 
    	}   
		where.add(new SqlPredicate(VanPartyExt.PARTY_ID, "IN", type.toString(), false).setPreparedMode(false));

		int queryCount = -1;
		if(!CommonLib.isNullOrEmpty(query, CommonConstant.QRY_COUNT))
			queryCount = Integer.parseInt((String)query.get(CommonConstant.QRY_COUNT));

		return vanPartyExtModel.query(where, queryCount);
	}
	
	/**
	 * 查詢用戶延伸設定檔ByPK
	 * @param VanPartyExt
	 * @return
	 * @throws XdaoException
	 */
	public VanPartyExt queryByPK(VanPartyExt vanPartyExt) throws XdaoException{
		return vanPartyExtModel.queryOne(vanPartyExt);
	}

	/**
	 * 插入VanPartyExt
	 * 
	 * @param VanPartyExt
	 * @return
	 * @throws XdaoException
	 */
	public int insVanPartyExt(VanPartyExt vanPartyExt) throws XdaoException {
		vanPartyExt.setValue(vanPartyExt.OP_DTS, new Timestamp(new Date().getTime()));
		vanPartyExt.setValue(vanPartyExt.CT_DTS, new Timestamp(new Date().getTime()));
		vanPartyExt.setExtId("0001");
		vanPartyExt.setExtType("C");
		vanPartyExt.setObjectId("CCS_CUSTPROF");

		return this.vanPartyExtModel.insert(vanPartyExt);
	}

	/**
	 * 修改VanPartyExt
	 * 
	 * @param VanPartyExt
	 * @return
	 * @throws XdaoException
	 */
	public int updVanPartyExt(VanPartyExt vanPartyExt) throws XdaoException {
		int rtnCode = 0;
		DefaultModel.beginTransaction();
		vanPartyExt.setValue(vanPartyExt.OP_DTS, new Timestamp(new Date().getTime()));
		rtnCode = this.vanPartyExtModel.update(vanPartyExt);

		DefaultModel.commit();
		return rtnCode;
	}
	
	/**
	 * 插入VanPartyExtN
	 * 
	 * @param VanPartyExt
	 * @return int
	 * @throws XdaoException
	 */
	public int insVanPartyExtN(VanPartyExt vanPartyExt) throws XdaoException {
		vanPartyExt.setValue(vanPartyExt.OP_DTS, new Timestamp(new Date().getTime()));
		vanPartyExt.setValue(vanPartyExt.CT_DTS, new Timestamp(new Date().getTime()));

		return this.vanPartyExtModel.insert(vanPartyExt);
	}
	
	/**
	 * 修改VanPartyExt
	 * 
	 * @param VanPartyExt
	 * @return
	 * @throws XdaoException
	 */
	public int updVanPartyExtN(VanPartyExt vanPartyExt) throws XdaoException {
		int rtnCode = 0;
		DefaultModel.beginTransaction();
		vanPartyExt.setValue(vanPartyExt.OP_DTS, new Timestamp(new Date().getTime()));
		rtnCode = this.vanPartyExtModel.updByPK(vanPartyExt);

		DefaultModel.commit();
		return rtnCode;
	}
	
	/**
	 * 刪除VanPartyExt
	 * 
	 * @param VanPartyExt
	 * @return
	 * @throws XdaoException
	 */
	public int delVanPartyExtN(VanPartyExt vanPartyExt) throws XdaoException {
		int rtnCode = 0;
		DefaultModel.beginTransaction();
		rtnCode = this.vanPartyExtModel.delByPK(vanPartyExt);

		DefaultModel.commit();
		return rtnCode;
	}
	
	
	/**
	 * 查詢VanPartyExt的資料by PartyId
	 * @param VanPartyExt
	 * @return
	 * @throws XdaoException
	 */
	public List<VanPartyExt> queryByPartyId(VanPartyExt vanPartyExt) throws XdaoException{
		SqlWhere where =new SqlWhere();
		where.add(VanPartyExt.PARTY_ID,  vanPartyExt.getPartyId());
		return vanPartyExtModel.query(where,0);
	}
	
	/**
	 * 刪除VanPartyExt的資料by PartyId
	 * @param VanPartyExt
	 * @return
	 * @throws XdaoException
	 */
	public int delByPartyId(VanPartyAltn vanPartyAltn) throws XdaoException{
		int returnCode = 0;//Flag,用來判斷是vanPartyAltn刪除失敗還是vanPartyExt失敗
		try{
		    DefaultModel.beginTransaction();
		    VanPartyAltnModel vanPartyAltnModel = new VanPartyAltnModel();
		    int result = vanPartyAltnModel.delete(vanPartyAltn);
		    if (result <= 0){
		    	returnCode = 1;
		    } 
		    VanPartyExt vanPartyExt = new VanPartyExt();
            vanPartyExt.setPartyId(vanPartyAltn.getId());
		    List<VanPartyExt> vanPartyExtList = VanPartyExtService.INSTANCE.queryByPartyId(vanPartyExt);
            if(vanPartyExtList != null && vanPartyExtList.size() > 0){
            	int resultExt = vanPartyExtModel.delByPartyId(vanPartyExt);
			    if(resultExt <= 0){
			     	returnCode = 2;//vanPartyExt刪除失敗
			    }
            }
		    //判斷van_service_routing是否有值，若有，則van_service_routing也要刪除
		    Map map = new HashMap();
		    map.put(VanServiceRouting.PARTY_ID, vanPartyExt.getPartyId());
            List<VanServiceRouting> vanServiceRoutingList = VanServiceRoutingService.INSTANCE.queryByDef(map);
            if(vanServiceRoutingList != null && vanServiceRoutingList.size() > 0){
            	VanServiceRoutingModel vanServiceRoutingModel = new VanServiceRoutingModel();
            	VanServiceRouting vanServiceRouting = null;
            	String rtgSeqNo="";
            	for(int i=0 ; i<vanServiceRoutingList.size() ; i++ ){
            		vanServiceRouting = vanServiceRoutingList.get(i);
            		rtgSeqNo = vanServiceRouting.getRtgSeqNo();
            		int resultRouting =vanServiceRoutingModel.delete(vanServiceRouting);
            		if (resultRouting <= 0) { 
         		        returnCode = 3;//vanServiceRouting刪除失敗
         		    }
         		    //判斷van_service_routing_ext是否有值，若有，則van_service_routing_ext也要刪除
         		    List<VanServiceRoutingExt> vanServiceRoutingExtList = VanServiceRoutingExtService.INSTANCE.queryByRtgId(rtgSeqNo);
         		    if(vanServiceRoutingExtList != null && vanServiceRoutingExtList.size() > 0){
         		    	VanServiceRoutingExtModel vanServiceRoutingExtModel = new VanServiceRoutingExtModel();
         		    	VanServiceRoutingExt vanServiceRoutingExt = null;
         		    	for(int j=0 ; j<vanServiceRoutingExtList.size() ; j++ ){
         		    		vanServiceRoutingExt = vanServiceRoutingExtList.get(j);
         		    		int resultRoutingExt =vanServiceRoutingExtModel.delete(vanServiceRoutingExt);
         		    		if (resultRoutingExt <= 0) { 
         		    			returnCode = 4;//vanServiceRoutingExt刪除失敗
         		    		}
         		    	}
         		    }
            	}	
            	
            }
            
		   
            
		    if (returnCode == 0)
                DefaultModel.commit();
            else{
                DefaultModel.rollback();
            }
        } catch (XdaoException e) {
            DefaultModel.rollback();
            throw e;
        } finally{
            DefaultModel.commit();
        } 
		return returnCode;
	}
	
	
	public static void main(String[] args)  {
		VanPartyExtService test =new VanPartyExtService();
		try {
			test.queryByPartyId("TWTVNAGT90PFD03984");
			System.out.println( test.queryByPartyId("TWTVNAGT90PFD03984"));
		} catch (XdaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
