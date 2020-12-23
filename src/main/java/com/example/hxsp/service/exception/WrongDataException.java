package com.example.hxsp.service.exception;


/**
 *数据错误异常的基类
 * @author 
 *
 */
public class WrongDataException extends RuntimeException{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongDataException() {
		super();
	}

	public WrongDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WrongDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongDataException(String message) {
		super(message);
	}

	public WrongDataException(Throwable cause) {
		super(cause);
	}
	
	
	

}

