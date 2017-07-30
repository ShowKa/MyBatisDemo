package com.showka.MyBatisDemo.u01.g001.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.showka.MyBatisDemo.common.SearchParam;
import com.showka.MyBatisDemo.u01.g001.search.i.U01G001KokyakuSearchRepository;

@Repository
public class U01G001KokyakuSearchRepositoryImpl implements U01G001KokyakuSearchRepository {

	@Autowired
	private U01G001KokyakuMapper mapper;

	/**
	 * 顧客検索
	 */
	@Override
	public List<U01G001Kokyaku> search(String name, String shukanBushoName) {
		SearchParam param = new SearchParam();

		// 顧客名
		if (name != null) {
			param.putForPartialMatch("name", name);
		}

		// 部署名
		if (shukanBushoName != null) {
			param.putForPartialMatch("shukanBushoName", shukanBushoName);
		}

		return mapper.search(param);
	}

}
