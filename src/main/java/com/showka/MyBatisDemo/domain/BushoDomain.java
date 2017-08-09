package com.showka.MyBatisDemo.domain;

import com.showka.MyBatisDemo.kubun.BushoKubun;
import com.showka.MyBatisDemo.kubun.JigyoKubun;
import com.showka.MyBatisDemo.system.EmptyProxy;
import com.showka.MyBatisDemo.system.exception.SystemException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BushoDomain extends DomainBase {

	// private member
	private String code = STRING_EMPTY;

	private BushoKubun bushoKubun = BushoKubun.EMPTY;;

	private JigyoKubun jigyoKubun = JigyoKubun.EMPTY;

	private String name = STRING_EMPTY;

	private int version = 0;

	// public method
	/**
	 * 営業所判定
	 * 
	 * @return 営業所ならtrue
	 */
	public boolean isEigyosho() {
		if (BushoKubun.営業所 == this.bushoKubun) {
			return true;
		}
		return false;
	}

	/**
	 * 販売事業判定
	 * 
	 * @return 販売事業をしているならtrue
	 */
	public boolean isHanbaiJigyoBusho() {
		if (JigyoKubun.販売 == this.jigyoKubun || JigyoKubun.兼業 == this.jigyoKubun) {
			return true;
		}
		return false;
	}

	/**
	 * レンタル事業判定
	 * 
	 * @return レンタル事業をしているならtrue
	 */
	public boolean isRentalJigyoBusho() {
		if (JigyoKubun.レンタル == this.jigyoKubun || JigyoKubun.兼業 == this.jigyoKubun) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return this == EMPTY;
	}

	@Override
	protected boolean equals(DomainBase other) {
		BushoDomain o = (BushoDomain) other;
		return code.equals(o.code);
	}

	@Override
	public int hashCode() {
		return code.hashCode();
	}

	@Override
	public void validate() throws SystemException {
	}

	// Empty
	public static final BushoDomain EMPTY = EmptyProxy.domain(BushoDomain.class);

}
