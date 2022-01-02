package com.icommerce.product.restapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponseBody<T> implements Serializable {

	private static final long serialVersionUID = -1596817705143637433L;
	private String status;
	private String code;
	private String message;
	private T data;

	public CustomResponseBody() {
		super();
	}

	public CustomResponseBody(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public CustomResponseBody(String status, String code, T data) {
		this.status = status;
		this.code = code;
		this.data = data;
	}

	public CustomResponseBody(String status, String code, String message, T data) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
