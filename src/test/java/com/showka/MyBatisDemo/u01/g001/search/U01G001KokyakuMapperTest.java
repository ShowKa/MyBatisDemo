package com.showka.MyBatisDemo.u01.g001.search;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.showka.MyBatisDemo.common.TestCaseBase;

public class U01G001KokyakuMapperTest extends TestCaseBase {

	@Autowired
	private U01G001KokyakuMapper mapper;

	@Test
	public void search() {
		List<U01G001Kokyaku> actual = mapper.search();
		System.out.println(actual);
		assertTrue(true);
	}

}
