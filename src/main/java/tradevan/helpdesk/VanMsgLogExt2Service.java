package tradevan.helpdesk;

import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: VanMsgLogExtService<br>
 * Description: 提供QryVanMsgLogExtAction查詢DB。<br>
 * Company: Tradevan Co.<br>
 *
 * @author I-Chun Huang
 * @since 1.0.0
 */
public class VanMsgLogExt2Service {
    public static final VanMsgLogExt2Service INSTANCE = new VanMsgLogExt2Service();
    private VanMsgLogExt2Model vanMsgLogExt2Model = new VanMsgLogExt2Model();
    private CommonModel commonModel = new CommonModel();

    /**
     * 取得VanMsgLogExt的相關物件
     *
     * @param query
     * @return
     * @throws XdaoException
     */
    public List<VanMsgLogExt2> qryByDef(Map query) throws XdaoException {
        int queryCount = -1;
        // if(!CommonLib.isNullOrEmpty(query, CommonConstant.QRY_COUNT))
        // queryCount =
        // Integer.parseInt((String)query.get(CommonConstant.QRY_COUNT));
        //
        SqlWhere where = new SqlWhere();
        // if(!CommonLib.isNullOrEmpty(query, VanMsgLogExt.MESSAGE_ID))
        // where.add(VanMsgLogExt.MESSAGE_ID,
        // query.get(VanMsgLogExt.MESSAGE_ID));
        // if(!CommonLib.isNullOrEmpty(query, VanMsgLogExt.MESSAGE_SUB_ID))
        // where.add(VanMsgLogExt.MESSAGE_SUB_ID,
        // query.get(VanMsgLogExt.MESSAGE_SUB_ID));
        // if(!CommonLib.isNullOrEmpty(query, VanMsgLogExt.EXT_ARG_VAL1))
        // where.add(VanMsgLogExt.EXT_ARG_VAL1,
        // query.get(VanMsgLogExt.EXT_ARG_VAL1));
        // if(!CommonLib.isNullOrEmpty(query, VanMsgLogExt.EXT_ARG_VAL2))
        // where.add(VanMsgLogExt.EXT_ARG_VAL2,
        // query.get(VanMsgLogExt.EXT_ARG_VAL2));
        // if(!CommonLib.isNullOrEmpty(query, VanMsgLogExt.EXT_ARG_VAL3))
        // where.add(VanMsgLogExt.EXT_ARG_VAL3,
        // query.get(VanMsgLogExt.EXT_ARG_VAL3));
        // if(!CommonLib.isNullOrEmpty(query, VanMsgLogExt.EXT_ARG_VAL4))
        // where.add(VanMsgLogExt.EXT_ARG_VAL4,
        // query.get(VanMsgLogExt.EXT_ARG_VAL4));
        // if(!CommonLib.isNullOrEmpty(query, VanMsgLogExt.EXT_ARG_VAL5))
        // where.add(VanMsgLogExt.EXT_ARG_VAL5,
        // query.get(VanMsgLogExt.EXT_ARG_VAL5));
        // if(!CommonLib.isNullOrEmpty(query, VanMsgLogExt.EXT_ARG_VAL6))
        // where.add(VanMsgLogExt.EXT_ARG_VAL6,
        // query.get(VanMsgLogExt.EXT_ARG_VAL6));

        return this.vanMsgLogExt2Model.query(where, queryCount);
    }

    /**
     * 根據messageID,messageSubId查詢VanMsgLogExt2
     *
     * @param messageId
     * @param messageSubId
     * @return
     * @throws XdaoException
     */
    public List<Map> qryByMsgsToMaps(String messageId, String messageSubId)
            throws XdaoException {
        List<Map> mapList = new ArrayList<Map>();
        SqlWhere where = new SqlWhere();
        where.add(VanMsgLogExt.MESSAGE_ID, messageId);
        if (!CommonLib.isNullOrEmpty(messageSubId))
            where.add(VanMsgLogExt.MESSAGE_SUB_ID, messageSubId);

        List<VanMsgLogExt2> vaExt2 = this.vanMsgLogExt2Model.query(where, -1);

        //將夾檔資料撈出須另外整理，ex 假設有3筆檔案 就會取出list大小為8的資料(含檔案總數總大小)下面程式會將list整理成大小只有4 好讓畫面輸出方便

        Map map = null;
        String extId = "default";

        if (vaExt2 != null && vaExt2.size() > 0) {
            for (int i = 0; i < vaExt2.size(); i++) {

                if (!extId.equals(vaExt2.get(i).getExtId())) {
                    extId = vaExt2.get(i).getExtId();
                    map = new HashMap();

                    mapList.add(map);
                }

                map.put(vaExt2.get(i).getArgId(), vaExt2.get(i).getArgValue());


            }
        }

        // return vaExt2;
        return mapList;
    }

    // /**
    // * 根據messageID,messageSubId查詢VanMsgLogExt單筆
    // * @param messageId
    // * @param messageSubId
    // * @return
    // * @throws XdaoException
    // */
    // public VanMsgLogExt2 qryOne(String messageId, String messageSubId) throws
    // XdaoException {
    // SqlWhere where = new SqlWhere();
    // where.add(VanMsgLogExt.MESSAGE_ID, messageId);
    // // if(!CommonLib.isNullOrEmpty(messageSubId))
    // where.add(VanMsgLogExt.MESSAGE_SUB_ID, messageSubId);
    //
    // return this.vanMsgLogExt2Model.queryOne(where);
    // }

    public static void main(String args[]) {
        try {

//            SqlWhere where = new SqlWhere();
//            where.add(VanMsgLogExt.MESSAGE_ID, "N241NYDK6");
//            where.add(VanMsgLogExt.MESSAGE_ID, "001");
            String CMT_ATT_TOTAL_NUM = null;

            int ATTACHMENT_PRICE = 25;

            List<Map> mapList = VanMsgLogExt2Service.INSTANCE.qryByMsgsToMaps("N1J1NXVMW", "001");
            Integer cmtAttTotalNum = null;
            for (Map VanMsgLogExt2Map : mapList) {
                if (VanMsgLogExt2Map.containsKey("CMT_ATT_TOTAL_NUM")) {
                    cmtAttTotalNum = Integer.valueOf(CMT_ATT_TOTAL_NUM = VanMsgLogExt2Map.get("CMT_ATT_TOTAL_NUM").toString());
                }
            }

            System.out.println("CMT_ATT_TOTAL_NUM = " + cmtAttTotalNum * ATTACHMENT_PRICE);

        } catch (XdaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //
}
