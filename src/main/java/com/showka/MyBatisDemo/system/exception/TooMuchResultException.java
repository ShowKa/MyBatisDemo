package com.showka.MyBatisDemo.system.exception;

public class TooMuchResultException extends RuntimeException {

	public TooMuchResultException() {
		super("検索結果が多すぎます。");
	}

	/**
	 * SID.
	 */
	private static final long serialVersionUID = -984270802384387741L;

}
