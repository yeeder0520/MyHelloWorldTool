package tradevan.helpdesk;
import com.tradevan.framework.ApplicationConfig;
import com.tradevan.framework.BaseModel;
import com.tradevan.taurus.xdao.XdaoException;
import com.tradevan.taurus.xdao.XdaoSession;

/**
 * Title: DefaultModel<br>
 * Description: <br>
 * Company: Tradevan Co.<br>
 * 
 * @author Huang-Chih Hsieh
 * @since 1.0.0
 * 修改歷史 :     
 * 1.2017.07.04 新增設定xdao session方法
 */
public class DefaultModel extends BaseModel {
    private static ThreadLocal<XdaoSession> sessions = new ThreadLocal<XdaoSession>();
    
    public DefaultModel(String tableName) {
        super(tableName);
    }
  
    public static void beginTransaction() throws XdaoException {
        XdaoSession xsession = factory.getXdaoSession(connectionId);
        xsession.beginTransaction();
        sessions.set(xsession);
    }
    
    public static void beginTransaction(String connId) throws XdaoException {
        XdaoSession xsession = factory.getXdaoSession(connId);
        xsession.beginTransaction();
        sessions.set(xsession);
    }
    
    public static void beginUTSTransaction() throws XdaoException {
        String applicationId = "APNVAN_V3";
        String connId = "uts-conn-id";
        ApplicationConfig applicationConfig = new ApplicationConfig("conf/application.xml");
        XdaoSession xsession = factory.getXdaoSession(applicationConfig.getProperty(applicationId, connId));
        xsession.beginTransaction();
        sessions.set(xsession);        
    }
    
    public static void commit() throws XdaoException {
        XdaoSession xsession = (XdaoSession)sessions.get();
        if (xsession != null) {
            xsession.commit();
            sessions.remove();
        }
    }
    
    public static void rollback() {
        XdaoSession xsession = (XdaoSession)sessions.get();
        if (xsession != null) {
            xsession.rollback();
            sessions.remove();
        }
    }
    
    public XdaoSession getXdaoSession() {
        XdaoSession session = (XdaoSession)sessions.get();
        if (session == null) {
            session = super.getXdaoSession();
        } else {
            session.setTable(super.tableName);
        }
        return session;
    }
    
    //20140414
    //20141013 session從sessions get
    public XdaoSession getUTSSession() {
//        String applicationId = "APNVAN_V3";
//        String connId = "uts-conn-id";
//        ApplicationConfig applicationConfig = new ApplicationConfig("conf/application.xml");
//        XdaoFactory factory = XdaoFactory.getInstance();
//        XdaoSession session = factory.getXdaoSession(applicationConfig.getProperty(applicationId, connId));
//        session.setTable(super.tableName);
//        return session;
        XdaoSession session = (XdaoSession)sessions.get();
        if (session == null) {
            session = super.getXdaoSession();
        } else {
            session.setTable(super.tableName);
        }
        return session;
    }
}
