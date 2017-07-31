package com.showka.MyBatisDemo.system.exception;

public class OptimistickLockException extends RuntimeException {

	public OptimistickLockException() {
		super("対象でデータは他のユーザーによってすでに更新されています。");
	}

	/**
	 * SID.
	 */
	private static final long serialVersionUID = 3537524411462091524L;

}
