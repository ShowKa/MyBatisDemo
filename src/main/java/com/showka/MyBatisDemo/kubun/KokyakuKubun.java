package com.showka.MyBatisDemo.kubun;

import com.showka.MyBatisDemo.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KokyakuKubun implements Kubun<KokyakuKubun> {
	法人("00"), 個人("10");
	private String code;

}
