package com.example.hxsp.service.exception;

/*/*
 * 库存不足异常
 */
public class CouponAlreadyRevException extends ServiceException{
	private static final long serialVersionUID = 1L;
	
	public CouponAlreadyRevException() {
		super();
	}

	public CouponAlreadyRevException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CouponAlreadyRevException(String message, Throwable cause) {
		super(message, cause);
	}

	public CouponAlreadyRevException(String message) {
		super(message);
	}

	public CouponAlreadyRevException(Throwable cause) {
		super(cause);
	}

}
