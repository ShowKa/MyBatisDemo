package com.showka.MyBatisDemo.system.exception;

public class SystemException extends RuntimeException {

	/**
	 * SID.
	 */
	private static final long serialVersionUID = -5537628532784804220L;

	/**
	 * システム例外
	 * 
	 * @param message
	 *            エラーメッセージ
	 */
	public SystemException(String message) {
		super(message);
	}

	/**
	 * システム例外
	 * 
	 * @param message
	 *            エラーメッセージ
	 * @param cause
	 *            原因となった例外
	 */
	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

}
