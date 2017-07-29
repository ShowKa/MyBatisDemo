package com.showka.MyBatisDemo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.showka.MyBatisDemo.entity.MKokyaku;

@Mapper
public interface MKokyakuMapper extends IMapper<MKokyaku> {

	public MKokyaku selectByPK(String code);

}
