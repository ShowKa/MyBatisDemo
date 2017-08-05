package com.showka.MyBatisDemo.system.aspect;

import java.util.List;

import javax.persistence.Table;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import com.showka.MyBatisDemo.common.MapperTestCaseBase;
import com.showka.MyBatisDemo.entity.MBusho;
import com.showka.MyBatisDemo.entity.MKokyaku;
import com.showka.MyBatisDemo.entity.MNyukinKakeInfo;
import com.showka.MyBatisDemo.system.exception.TooMuchResultException;
import com.showka.MyBatisDemo.u01.g001.search.U01G001Kokyaku;
import com.showka.MyBatisDemo.u01.g001.search.U01G001KokyakuSearchRepositoryImpl;

@TestPropertySource(properties = { "framework.max_size_of_system = 1" })
public class CheckSearchMapperResultSizeTest extends MapperTestCaseBase {

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

	// m_nyukin_kake_info
	private static final String M_NYUKIN_KAKE_INFO = MNyukinKakeInfo.class.getAnnotation(Table.class).name();
	private static final String[] M_NYUKIN_KAKE_INFO_C = { "kokyaku_code", "nyukin_hoho_kubun", "nyukin_tsuki_kubun",
			"shimebi", "nyukin_date" };
	private static final Object[] M_NYUKIN_KAKE_INFO_V01 = { "KK01", "00", "00", 10, 30 };
	private static final Object[] M_NYUKIN_KAKE_INFO_V02 = { "KK02", "10", "10", 10, 30 };

	/**
	 * Before
	 */
	@Override
	@Before
	public void before() {
		super.deleteAll(M_BUSHO, M_KOKYAKU, M_NYUKIN_KAKE_INFO);
		super.insert(M_KOKYAKU, M_KOKYAKU_C, M_KOKYAKU_V01, M_KOKYAKU_V02);
		super.insert(M_NYUKIN_KAKE_INFO, M_NYUKIN_KAKE_INFO_C, M_NYUKIN_KAKE_INFO_V01, M_NYUKIN_KAKE_INFO_V02);
		super.insert(M_BUSHO, M_BUSHO_C, M_BUSHO_V01, M_BUSHO_V02);
	}

	@Autowired
	private U01G001KokyakuSearchRepositoryImpl mapper;

	/**
	 * TooMuchResultException発生テスト
	 * 
	 * @throws Exception
	 */
	@Test(expected = TooMuchResultException.class)
	public void tooMuchErro() throws Exception {
		mapper.search("顧客", "部署");
	}

	/**
	 * 許容範囲内の場合のテスト
	 * 
	 * @throws Exception
	 */
	@Test
	public void sucess() throws Exception {
		List<U01G001Kokyaku> actual = mapper.search("顧客01", "部署01");
		assertTrue(actual.size() > 0);
	}
}
