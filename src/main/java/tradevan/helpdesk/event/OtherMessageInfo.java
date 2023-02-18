package tradevan.helpdesk.event;

public class OtherMessageInfo implements Cloneable {
	private String messageType;
	private String messageSubType;
	private String controlNO;
	private String instruction;
	private String filename;
	private String cliFilename;
	private String vasSeqNO;
	private String unzipFileSize;
	private String flowType;
	private String connectionID;
	
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageSubType() {
		return messageSubType;
	}
	public void setMessageSubType(String messageSubType) {
		this.messageSubType = messageSubType;
	}
	public String getControlNO() {
		return controlNO;
	}
	public void setControlNO(String controlNO) {
		this.controlNO = controlNO;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getCliFilename() {
		return cliFilename;
	}
	public void setCliFilename(String cliFilename) {
		this.cliFilename = cliFilename;
	}
	public String getVasSeqNO() {
		return vasSeqNO;
	}
	public void setVasSeqNO(String vasSeqNO) {
		this.vasSeqNO = vasSeqNO;
	}
	public String getUnzipFileSize() {
		return unzipFileSize;
	}
	public void setUnzipFileSize(String unzipFileSize) {
		this.unzipFileSize = unzipFileSize;
	}
	public String getFlowType() {
		return flowType;
	}
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	public String getConnectionID() {
		return connectionID;
	}
	public void setConnectionID(String connectionID) {
		this.connectionID = connectionID;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
