package com.showka.MyBatisDemo.entity;

import javax.persistence.Table;

public class TestData {

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
}
