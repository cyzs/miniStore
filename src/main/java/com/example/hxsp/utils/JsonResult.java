package com.example.hxsp.utils;

import java.io.Serializable;

/**
 * 封装响应的JSON结果的类
 *
 * @param <T>
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResult<T> implements Serializable{
	
	private static final long serialVersionUID = 2905865357175826940L;
	private Integer state; //响应码
	private String message; // 响应信息
	private T data; //响应数据
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
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
	
	public JsonResult() {
	}
	
	public JsonResult(Throwable e) {
		this.message = e.getMessage();
	}
	public JsonResult(Integer state) {
		this.state = state;
	}
	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}
	
	
	
	
	
	
	
}

