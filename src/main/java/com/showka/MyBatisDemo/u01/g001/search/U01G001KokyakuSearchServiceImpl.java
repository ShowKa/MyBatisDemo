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
@Transactional
public class U01G001KokyakuSearchServiceImpl implements U01G001KokyakuSearchService {

	/**
	 * 検索リポジトリ
	 */
	@Autowired
	private U01G001KokyakuSearchRepository repository;

	/**
	 * 顧客検索
	 */
	@Override
	public List<U01G001Kokyaku> search(String name, String shukanBushoName, SearchType type) {
		return justSearch(name, shukanBushoName);
	}

	/**
	 * 顧客検索(画面)
	 */
	@Override
	@SearchService(searchType = SearchType.SCREEN)
	public List<U01G001Kokyaku> searchForScreen(String name, String shukanBushoName) {
		return justSearch(name, shukanBushoName);
	}

	/**
	 * 顧客検索(帳票)
	 */
	@Override
	@SearchService(searchType = SearchType.REPORT)
	public List<U01G001Kokyaku> searchForReport(String name, String shukanBushoName) {
		return justSearch(name, shukanBushoName);
	}

	/**
	 * 検索共通
	 * 
	 */
	private List<U01G001Kokyaku> justSearch(String name, String shukanBushoName) {
		return repository.search(name, shukanBushoName);
	}
}