package com.cg.omts.Dto;

public class ErrorDto {
	private String type;
	private String message;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ErrorDto [type=" + type + ", message=" + message + "]";
	}
	
	public ErrorDto() {
		super();
	}
	
	public ErrorDto(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}
	
}
