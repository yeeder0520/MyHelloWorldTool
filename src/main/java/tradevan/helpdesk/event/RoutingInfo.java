package tradevan.helpdesk.event;

import java.util.ArrayList;
import java.util.List;



public class RoutingInfo implements Cloneable {
	private String rtgSeqNO;
	private List arguments = new ArrayList();
	private String processID;
	private String serviceID;
	private String actionID;
	private String connSrcID;
	private String connDesID;
	private String ackMark;
	private boolean beenSplitted;
	
	public String getRtgSeqNO() {
		return rtgSeqNO;
	}
	public void setRtgSeqNO(String rtgSeqNO) {
		this.rtgSeqNO = rtgSeqNO;
	}
	public List getArguments() {
		return arguments;
	}
	public void setArguments(List arguments) {
		this.arguments = arguments;
	}
	public void addArguments(Arguments arg) {
		arguments.add(arg);
	}
	public String getProcessID() {
		return processID;
	}
	public void setProcessID(String processID) {
		this.processID = processID;
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
	public String getActionID() {
		return actionID;
	}
	public void setActionID(String actionID) {
		this.actionID = actionID;
	}
	public String getConnSrcID() {
		return connSrcID;
	}
	public void setConnSrcID(String connSrcID) {
		this.connSrcID = connSrcID;
	}
	public String getConnDesID() {
		return connDesID;
	}
	public void setConnDesID(String connDesID) {
		this.connDesID = connDesID;
	}
	public String getAckMark() {
		return ackMark;
	}
	public void setAckMark(String ackMark) {
		this.ackMark = ackMark;
	}
	public boolean isBeenSplitted() {
		return beenSplitted;
	}
	public void setBeenSplitted(boolean beenSplitted) {
		this.beenSplitted = beenSplitted;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
