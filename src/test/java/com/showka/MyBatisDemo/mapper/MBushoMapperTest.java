package com.showka.MyBatisDemo.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.showka.MyBatisDemo.common.TestCaseBase;
import com.showka.MyBatisDemo.entity.MBusho;

public class MBushoMapperTest extends TestCaseBase {

	@Autowired
	MBushoMapper mapper;

	@Test
	public void testSelect() throws Exception {

		MBusho entity = new MBusho();
		entity.setBusho_kubun("01");
		entity.setCode("01");
		entity.setJigyo_kubun("01");
		entity.setName("name01");
		mapper.insert(entity);

		MBusho entity2 = new MBusho();
		entity2.setBusho_kubun("01");
		entity2.setCode("01");
		entity2.setJigyo_kubun("01");
		entity2.setName("name02");
		entity2.setVersion(0);
		mapper.update(entity2);

		MBusho result = mapper.selectByPK("01");

		assertEquals(new Integer(1), result.getVersion());
		assertEquals("name02", result.getName());
	}

}
