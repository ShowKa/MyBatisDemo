package com.showka.MyBatisDemo.u01.g001.search;

import com.showka.MyBatisDemo.entity.MBusho;
import com.showka.MyBatisDemo.entity.MKokyaku;
import com.showka.MyBatisDemo.entity.MNyukinKakeInfo;

import lombok.Getter;

@Getter
public class U01G001Kokyaku extends MKokyaku {

	/**
	 * SID.
	 */
	private static final long serialVersionUID = -6105489726434260846L;

	/**
	 * 主幹部署
	 */
	private MBusho shukanBusho;

	/**
	 * 入金掛情報
	 */
	private MNyukinKakeInfo nyukinKakeInfo;

}
