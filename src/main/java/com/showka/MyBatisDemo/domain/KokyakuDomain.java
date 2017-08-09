package com.showka.MyBatisDemo.domain;

import com.showka.MyBatisDemo.kubun.HanbaiKubun;
import com.showka.MyBatisDemo.kubun.KokyakuKubun;
import com.showka.MyBatisDemo.system.EmptyProxy;
import com.showka.MyBatisDemo.system.exception.SystemException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 顧客ドメイン
 * 
 * @author ShowKa
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KokyakuDomain extends DomainBase {

	// private member
	/** 顧客コード */
	private String code = STRING_EMPTY;

	/** 顧客区分 */
	private KokyakuKubun kokyakuKubun = KokyakuKubun.EMPTY;

	/** 販売区分 */
	private HanbaiKubun hanbaiKubun = HanbaiKubun.EMPTY;

	/** 顧客名 */
	private String name = STRING_EMPTY;

	/** 住所 */
	private String address = STRING_EMPTY;

	/** 主幹部署 */
	private BushoDomain shukanBushoDomain = BushoDomain.EMPTY;

	/** バージョン */
	private Integer version = INTEGER_EMPTY;

	// public method
	/**
	 * 個人判定
	 * 
	 * @return 個人ならtrue
	 */
	public boolean isKojin() {
		if (KokyakuKubun.個人 == kokyakuKubun) {
			return true;
		}
		return false;
	}

	/**
	 * 法人判定
	 */
	public boolean isHojin() {
		if (KokyakuKubun.法人 == kokyakuKubun) {
			return true;
		}
		return false;
	}

	/**
	 * 空チェック
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return this == EMPTY;
	}

	/**
	 * 顧客コードが一緒なら同値
	 */
	@Override
	protected boolean equals(DomainBase other) {
		KokyakuDomain o = (KokyakuDomain) other;
		return this.code.equals(o.code);
	}

	@Override
	public int hashCode() {
		return this.code.hashCode();
	}

	@Override
	public void validate() throws SystemException {
	}

	// Empty
	public static final KokyakuDomain EMPTY = EmptyProxy.domain(KokyakuDomain.class);

}
