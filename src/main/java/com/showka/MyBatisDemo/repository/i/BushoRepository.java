package com.showka.MyBatisDemo.repository.i;

import com.showka.MyBatisDemo.domain.BushoDomain;
import com.showka.MyBatisDemo.entity.MBusho;

public interface BushoRepository extends Repository<MBusho, BushoDomain> {

	/**
	 * 部署ドメイン取得
	 * 
	 * @param code
	 *            部署コード
	 * @return 部署ドメイン
	 */
	public BushoDomain selectByPK(String code);

}
