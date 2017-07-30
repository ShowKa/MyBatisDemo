package com.showka.MyBatisDemo.u01.g001.search;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.showka.MyBatisDemo.common.SearchMapper;
import com.showka.MyBatisDemo.common.SearchParam;

@Mapper
public interface U01G001KokyakuMapper extends SearchMapper {

	public List<U01G001Kokyaku> search(SearchParam param);

}
