package com.showka.MyBatisDemo.u01.g001.search;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showka.MyBatisDemo.common.SearchService;
import com.showka.MyBatisDemo.common.SearchType;
import com.showka.MyBatisDemo.u01.g001.search.i.U01G001KokyakuSearchRepository;
import com.showka.MyBatisDemo.u01.g001.search.i.U01G001KokyakuSearchService;

@Service
@SearchService
@Transactional
public class U01G001KokyakuSearchServiceImpl implements U01G001KokyakuSearchService {

	@Autowired
	private U01G001KokyakuSearchRepository repository;

	/**
	 * 顧客検索
	 */
	@Override
	public List<U01G001Kokyaku> search(String name, String shukanBushoName, SearchType type) {
		List<U01G001Kokyaku> result = repository.search(name, shukanBushoName);
		return result;
	}

}
