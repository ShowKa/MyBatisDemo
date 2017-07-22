package com.showka.MyBatisDemo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.showka.MyBatisDemo.entity.MBusho;

@Mapper
public interface MBushoMapper extends IMapper<MBusho> {

	MBusho select(String code);

}
