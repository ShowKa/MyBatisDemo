package com.showka.MyBatisDemo.mapper;

import com.showka.MyBatisDemo.entity.AbstractEntity;

public interface IMapper<T extends AbstractEntity> {

	/**
	 * insert
	 * 
	 * @param entity
	 */
	void insert(T todo);

	/**
	 * update
	 * 
	 * @param entity
	 */
	boolean update(T entity);
}
