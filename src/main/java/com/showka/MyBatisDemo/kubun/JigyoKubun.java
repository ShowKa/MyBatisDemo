package com.showka.MyBatisDemo.kubun;

import com.showka.MyBatisDemo.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JigyoKubun implements Kubun<JigyoKubun> {
	販売("01"), レンタル("02"), 兼業("10"), EMPTY("");
	private String code;
}
