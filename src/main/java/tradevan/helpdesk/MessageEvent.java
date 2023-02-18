package tradevan.helpdesk;


import tradevan.helpdesk.event.*;

public class MessageEvent implements Cloneable {

	private MessageId messageID;
	private String acceptDTS;
	private String deliveredDTS;
	private Party sender;
	private Party actualSender;
	private Party receiver;
	private String status;
	private MessageContent input;
	private MessageContent output;
	private MessageId parentMessageID;
	private MessageId childMessageID;
	private String operatorID;
	private boolean isResent;
	private RoutingInfo routingInfo;
	private OtherMessageInfo messageInfo;
	private String billingStatus;
	private String billingCode;
	
	public MessageId getMessageID() {
		return messageID;
	}
	public void setMessageID(MessageId messageID) {
		this.messageID = messageID;
	}
	public String getAcceptDTS() {
		return acceptDTS;
	}
	public void setAcceptDTS(String acceptDTS) {
		this.acceptDTS = acceptDTS;
	}
	public String getDeliveredDTS() {
		return deliveredDTS;
	}
	public void setDeliveredDTS(String deliveredDTS) {
		this.deliveredDTS = deliveredDTS;
	}
	public Party getSender() {
		return sender;
	}
	public void setSender(Party sender) {
		this.sender = sender;
	}
	public Party getActualSender() {
		return actualSender;
	}
	public void setActualSender(Party actualSender) {
		this.actualSender = actualSender;
	}
	public Party getReceiver() {
		return receiver;
	}
	public void setReceiver(Party receiver) {
		this.receiver = receiver;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MessageContent getInput() {
		return input;
	}
	public void setInput(MessageContent input) {
		this.input = input;
	}
	public MessageContent getOutput() {
		return output;
	}
	public void setOutput(MessageContent output) {
		this.output = output;
	}
	public MessageId getParentMessageID() {
		return parentMessageID;
	}
	public void setParentMessageID(MessageId parentMessageID) {
		this.parentMessageID = parentMessageID;
	}
	public MessageId getChildMessageID() {
		return childMessageID;
	}
	public void setChildMessageID(MessageId childMessageID) {
		this.childMessageID = childMessageID;
	}
	public String getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}
	public boolean isResent() {
		return isResent;
	}
	public void setIsResent(boolean isResent) {
		this.isResent = isResent;
	}
	public RoutingInfo getRoutingInfo() {
		return routingInfo;
	}
	public void setRoutingInfo(RoutingInfo routingInfo) {
		this.routingInfo = routingInfo;
	}
	public OtherMessageInfo getMessageInfo() {
		return messageInfo;
	}
	public void setMessageInfo(OtherMessageInfo messageInfo) {
		this.messageInfo = messageInfo;
	}
	public String getBillingStatus() {
		return billingStatus;
	}
	public void setBillingStatus(String billingStatus) {
		this.billingStatus = billingStatus;
	}
	public String getBillingCode() {
		return billingCode;
	}
	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
