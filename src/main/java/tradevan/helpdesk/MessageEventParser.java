package tradevan.helpdesk;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.commons.validator.GenericValidator;
import tradevan.helpdesk.event.Arguments;
import tradevan.helpdesk.event.RoutingInfo;

public class MessageEventParser implements ParserInterface {
    
    XStream xstream = new XStream(new DomDriver());
    
    public static final String TITLE = "message";
    public static final String ALIAS = "MessageEvent";
    public static final String NAME_SPACE = "http://NGSCLibrary/evt";
    public MessageEventParser(){
        initial();
    }
    
    public void initial() {
        xstream.alias(ALIAS, MessageEvent.class);
        xstream.alias("arguments", Arguments.class);
        /*參數一:包在哪個class下
         *參數二:class為何，須先訂義別名
         *參數三:xml欄位叫什麼
         *參數四:參數二所使用的class
         *
         *範例一:xstream.addImplicitCollection(RoutingInfo.class, "arguments", "argument12s", Object.class);
         *結果:
         *<argument12s class="arguments">
         *  <name>CPA_ID</name>
         *  <value>TV-03748403-X-03732205-CPA.xml</value>
         *</argument12s>
         *
         *範例二:xstream.addImplicitCollection(RoutingInfo.class, "arguments", "argument123s", Arguments.class);
         *結果:
         *<argument123s>
         *  <name>CPA_ID</name>
         *  <value>TV-03748403-X-03732205-CPA.xml</value>
         *</argument123s>
         * 
         */
        xstream.addImplicitCollection(RoutingInfo.class, "arguments", "arguments", Arguments.class);
    }

    public String marshal(Object bo) {
        if (!canParse(bo))
            throw new IllegalArgumentException("bo can not be parse");
        
        return xstream.toXML(bo);
    }

    public boolean canParse(Object bo) {
        if (bo == null)
            throw new IllegalArgumentException("bo can not be null");
        return (bo instanceof MessageEvent);
    }

    public Object unmarshal(String xml) {
        if (GenericValidator.isBlankOrNull(xml))
            throw new IllegalArgumentException("xml can not be null");
        
        
        return (MessageEvent) xstream.fromXML(xml);
    }

    public String getMessageAlias() {
        return ALIAS;
    }

    public String getNameSpace() {
        return NAME_SPACE;
    }

    public String getTitle() {

        return TITLE;
    }
}
