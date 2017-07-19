package com.showka.MyBatisDemo.mapper;

import com.showka.MyBatisDemo.entity.EntityBase;

public interface IMapper<T extends EntityBase> {

	/**
	 * insert
	 * 
	 * @param entity
	 */
	void insert(T entity);

	/**
	 * update
	 * 
	 * @param entity
	 */
	boolean update(T entity);

	/**
	 * 論理削除
	 * 
	 * @param entity
	 */
	boolean deleteLogically(T entity);

	/**
	 * 物理削除
	 * 
	 * @param entity
	 */
	boolean deletePhysically(T entity);
}
