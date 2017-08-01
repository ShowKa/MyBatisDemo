package com.showka.MyBatisDemo.u01.g001.search.i;

import java.util.List;

import com.showka.MyBatisDemo.common.SearchMax;
import com.showka.MyBatisDemo.common.SearchType;
import com.showka.MyBatisDemo.u01.g001.search.U01G001Kokyaku;

public interface U01G001KokyakuSearchService {

	/**
	 * 顧客検索
	 * 
	 * @param name
	 *            顧客名
	 * @param shukanBushoName
	 *            主幹部署名
	 * @param type
	 *            検索タイプ
	 * @return 顧客検索結果
	 */
	public List<U01G001Kokyaku> search(String name, String shukanBushoName, @SearchMax SearchType type);

}
