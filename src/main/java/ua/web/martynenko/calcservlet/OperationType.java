package ua.web.martynenko.calcservlet;

public enum OperationType {
	
	ADD("+"),
	SUBSTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/");
	
	private String stringValue;
	
	private OperationType(String s) {
		stringValue = s;
	}
	
	public String getStringValue() {
		return stringValue;
	}
}	
