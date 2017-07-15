package com.showka.MyBatisDemo.system.exception;

public class OptimistickLockException extends RuntimeException {

	public OptimistickLockException(String message) {
		super(message);
	}

	/**
	 * SID.
	 */
	private static final long serialVersionUID = 3537524411462091524L;

}
