package com.ghy.answer.model;

/*
 * ResponseWrapper
 * ��װǰ��˵�������Ϣ
 * */
public class ResponseWrapper {
	private boolean isSuccessful;
	private String ErrorMessage;
	private Object body;

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
}
