package com.showka.MyBatisDemo.common;

import java.util.HashMap;

import com.showka.MyBatisDemo.system.exception.SystemException;

/**
 * 検査パラメータ
 * 
 * @author ShowKa
 *
 */
public class SearchParam extends HashMap<String, String> {

	/**
	 * SID.
	 */
	private static final long serialVersionUID = -1728013564819704506L;

	/**
	 * パターン一致検索用ワイルドカード
	 */
	private static final String anyPatter = "%";

	/**
	 * パラメータ設定
	 */
	@Override
	public String put(String key, String value) {
		if (value == null) {
			throw new SystemException("検索パラメータにnullを設定してはいけません。");
		}
		return super.put(key, value);
	}

	/**
	 * 部分一致検索用パラメータ設定.
	 * 
	 * @param key
	 *            パラメータ名
	 * @param value
	 *            パラメータの値
	 * @return %value%
	 */
	public String putForPartialMatch(String key, String value) {
		if (value == null) {
			throw new SystemException("検索パラメータにnullを設定してはいけません。");
		}
		return put(key, anyPatter + value + anyPatter);
	}

	/**
	 * 前方一致検索用パラメータ設定.
	 * 
	 * @param key
	 *            パラメータ名
	 * @param value
	 *            パラメータの値
	 * @return value%
	 */
	public String putForPrefixMatch(String key, String value) {
		if (value == null) {
			throw new SystemException("検索パラメータにnullを設定してはいけません。");
		}
		return put(key, value + anyPatter);
	}

	/**
	 * 後方一致検索用パラメータ設定.
	 * 
	 * @param key
	 *            パラメータ名
	 * @param value
	 *            パラメータの値
	 * @return %value
	 */
	public String putForBackwardMatch(String key, String value) {
		if (value == null) {
			throw new SystemException("検索パラメータにnullを設定してはいけません。");
		}
		return put(key, anyPatter + value);
	}
}
