package tradevan.helpdesk;


public interface ParserInterface {

    public void initial();

    /**
     * BO轉成XML
     * 
     * @param bo
     * @return
     */
    public String marshal(Object bo) throws Exception;

    /**
     * XML轉成BO
     * 
     * @param clazz
     * @param xml
     * @return
     */
    public Object unmarshal(String xml) throws Exception;

    /**
     * 判斷是否可被Parser
     * 
     * @param clazz
     * @return
     */
    public boolean canParse(Object bo) throws Exception;
    
    public String getNameSpace();
    public String getMessageAlias();
    /**
     * 提供得知WPS使用的tilte
     * @return
     */
    public String getTitle();
}
