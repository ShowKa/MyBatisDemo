package com.showka.MyBatisDemo.system.aspect;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import com.showka.MyBatisDemo.common.SearchType;
import com.showka.MyBatisDemo.common.ServiceTestCaseBase;
import com.showka.MyBatisDemo.system.exception.TooMuchResultException;
import com.showka.MyBatisDemo.u01.g001.search.U01G001Kokyaku;
import com.showka.MyBatisDemo.u01.g001.search.U01G001KokyakuSearchServiceImpl;
import com.showka.MyBatisDemo.u01.g001.search.i.U01G001KokyakuSearchRepository;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

@TestPropertySource(properties = { "framework.max_size_of_screen = 5" })
public class CheckSearchServiceResultSizeTest extends ServiceTestCaseBase {

	@Tested
	private U01G001KokyakuSearchServiceImpl service;

	@Injectable
	private U01G001KokyakuSearchRepository repository;

	@Test(expected = TooMuchResultException.class)
	public void test_toomuch() {

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
		service.search("any", "any", SearchType.SCREEN);
	}
}
