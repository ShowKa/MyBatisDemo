package com.showka.MyBatisDemo.u01.g001.search.i;

import java.util.List;

import com.showka.MyBatisDemo.u01.g001.search.U01G001Kokyaku;

public interface U01G001KokyakuSearchRepository {

	/**
	 * 顧客検索
	 * 
	 * @param name
	 *            顧客名
	 * @return 顧客データ
	 */
	public List<U01G001Kokyaku> search(String name, String shukanBushoName);
}
