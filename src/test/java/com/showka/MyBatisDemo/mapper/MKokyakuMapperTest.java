package com.showka.MyBatisDemo.mapper;

import javax.persistence.Table;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.showka.MyBatisDemo.common.MapperTestCaseBase;
import com.showka.MyBatisDemo.entity.MBusho;
import com.showka.MyBatisDemo.entity.MKokyaku;

public class MKokyakuMapperTest extends MapperTestCaseBase {

	// m_busho
	private static final String M_BUSHO = MBusho.class.getAnnotation(Table.class).name();
	private static final String[] M_BUSHO_C = { "code", "busho_kubun", "jigyo_kubun", "name" };
	private static final Object[] M_BUSHO_V01 = { "BS01", "00", "00", "部署01" };
	private static final Object[] M_BUSHO_V02 = { "BS02", "00", "00", "部署02" };

	// m_kokyaku
	private static final String M_KOKYAKU = MKokyaku.class.getAnnotation(Table.class).name();
	private static final String[] M_KOKYAKU_C = { "code", "name", "address", "kokyaku_kubun", "hanbai_kubun",
			"shukan_busho_code" };
	private static final Object[] M_KOKYAKU_V01 = { "KK01", "顧客01", "左京区", "00", "00", "BS01" };
	private static final Object[] M_KOKYAKU_V02 = { "KK02", "顧客02", "右京区", "10", "10", "BS02" };

	/**
	 * Before
	 */
	@Override
	@Before
	public void before() {
		super.deleteAll(M_BUSHO, M_KOKYAKU);
		super.insert(M_KOKYAKU, M_KOKYAKU_C, M_KOKYAKU_V01, M_KOKYAKU_V02);
		super.insert(M_BUSHO, M_BUSHO_C, M_BUSHO_V01, M_BUSHO_V02);
	}

	@Autowired
	private MKokyakuMapper mapper;

	@Test
	public void testSelect() throws Exception {
		MKokyaku actual = mapper.selectByPK("KK01");
		System.out.println(actual);
	}

}
