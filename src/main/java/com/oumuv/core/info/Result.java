package com.oumuv.core.info;

public class Result {

	private String message;
	
	private String result;
	
	private int state ;
	
	

	public Result(String message, String result, int state) {
		super();
		this.message = message;
		this.result = result;
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
}
