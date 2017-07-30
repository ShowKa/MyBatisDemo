package com.showka.MyBatisDemo.common;

import java.util.HashMap;

import com.showka.MyBatisDemo.system.exception.SystemException;

import lombok.Getter;

/**
 * 検査パラメータ
 * 
 * @author ShowKa
 *
 */
@Getter
public class SearchParam extends HashMap<String, String> {

	/**
	 * 検索タイプ
	 * 
	 * @author ShowKa
	 *
	 */
	private enum SearchMode {
		Screen, Report
	}

	/**
	 * SID.
	 */
	private static final long serialVersionUID = -1728013564819704506L;

	/**
	 * パターン一致検索用ワイルドカード
	 */
	private static final String anyPatter = "%";

	/**
	 * 取得制限
	 */
	private SearchMode mode;

	/**
	 * 画面検索モード
	 */
	public void setScreenMode() {
		mode = SearchMode.Screen;
	}

	/**
	 * 画面モード判定
	 * 
	 * @return 画面モードならtrue
	 */
	public boolean isScreenMode() {
		return mode == SearchMode.Screen;
	}

	/**
	 * 帳票検索モード
	 */
	public void setReportMode() {
		mode = SearchMode.Report;
	}

	/**
	 * 帳票モード判定
	 * 
	 * @return 帳票モードならtrue
	 */
	public boolean isReportMode() {
		return mode == SearchMode.Report;
	}

	/**
	 * パラメータ設定
	 */
	@Override
	public String put(String key, String value) {
		checkValueStrictly(value);
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
		checkValueStrictly(value);
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
		checkValueStrictly(value);
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
		checkValueStrictly(value);
		return put(key, anyPatter + value);
	}

	/**
	 * valueチェック
	 * 
	 * <pre>
	 * nullのパラメータを渡したらエラー
	 * </pre>
	 */
	private void checkValueStrictly(String value) {
		if (value == null) {
			throw new SystemException("検索パラメータにnullを設定してはいけません。");
		}
	}
}
