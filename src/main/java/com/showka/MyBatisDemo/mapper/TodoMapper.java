package com.showka.MyBatisDemo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.showka.MyBatisDemo.entity.Todo;

@Mapper
public interface TodoMapper {

	void insert(Todo todo);

	Todo select(String id);
}
