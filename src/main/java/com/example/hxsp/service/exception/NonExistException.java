package com.example.hxsp.service.exception;


/**
 * 不存在异常的基类
 * @author 
 *
 */
public class NonExistException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonExistException() {
		super();
	}

	public NonExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NonExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonExistException(String message) {
		super(message);
	}

	public NonExistException(Throwable cause) {
		super(cause);
	}
	
	
	

}

