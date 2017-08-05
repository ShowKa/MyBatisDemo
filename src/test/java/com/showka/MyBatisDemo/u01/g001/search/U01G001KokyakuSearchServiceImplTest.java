package com.showka.MyBatisDemo.u01.g001.search;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.showka.MyBatisDemo.common.ServiceTestCaseBase;
import com.showka.MyBatisDemo.u01.g001.search.i.U01G001KokyakuSearchRepository;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class U01G001KokyakuSearchServiceImplTest extends ServiceTestCaseBase {

	@Tested
	private U01G001KokyakuSearchServiceImpl service;

	@Injectable
	private U01G001KokyakuSearchRepository repository;

	/**
	 * 画面検索テスト
	 */
	@Test
	public void test_searchForScreen() {
		// Mock
		List<U01G001Kokyaku> r = new ArrayList<U01G001Kokyaku>();
		for (int i = 0; i < 6; i++) {
			r.add(new U01G001Kokyaku());
		}
		new Expectations() {
			{
				repository.search((String) any, (String) any);
				result = r;
			}
		};
		// test
		List<U01G001Kokyaku> actual = service.searchForScreen("any", "any");
		assertEquals(6, actual.size());
	}

	/**
	 * 帳票検索テスト
	 */
	@Test
	public void test_searchForReport() {
		// Mock
		List<U01G001Kokyaku> r = new ArrayList<U01G001Kokyaku>();
		for (int i = 0; i < 6; i++) {
			r.add(new U01G001Kokyaku());
		}
		new Expectations() {
			{
				repository.search((String) any, (String) any);
				result = r;
			}
		};
		// test
		List<U01G001Kokyaku> actual = service.searchForReport("any", "any");
		assertEquals(6, actual.size());
	}
}
