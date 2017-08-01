package com.showka.MyBatisDemo.common;

/**
 * 検索タイプ
 * 
 * @author ShowKa
 *
 */
public enum SearchType {

	SCREEN, REPORT;

	/**
	 * 最大検索件数
	 */
	int maxCont = 0;

	/**
	 * 最大検索件数設定の値を上書き
	 * 
	 * @param maxCount
	 */
	public void overrideMaxCount(int maxCount) {
		this.maxCont = maxCount;
	}

	/**
	 * 最大検索件数取得
	 * 
	 * @return
	 */
	protected int getMaxCount() {
		return this.maxCont;
	}

	public void setMaxCountDefault() {
		this.maxCont = 0;
	}
}
