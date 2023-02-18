package tradevan.helpdesk.event;

public class MessageId implements Cloneable {

	private String id;
	private String subID;
	
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubId() {
		return subID;
	}
	public void setSubId(String subId) {
		this.subID = subId;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
