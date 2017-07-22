package com.showka.MyBatisDemo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.showka.MyBatisDemo.entity.Todo;

@Mapper
public interface TodoMapper extends IMapper<Todo> {

	Todo selectByPK(String title);

}
