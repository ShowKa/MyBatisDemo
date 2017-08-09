package com.showka.MyBatisDemo.repository.i;

import com.showka.MyBatisDemo.domain.KokyakuDomain;
import com.showka.MyBatisDemo.entity.MKokyaku;

public interface KokyakuRepository extends Repository<MKokyaku, KokyakuDomain> {
	/**
	 * 顧客検索
	 * 
	 * @param code
	 *            顧客コード
	 * @return 顧客ドメイン
	 */
	public KokyakuDomain selectByPK(String code);
}
