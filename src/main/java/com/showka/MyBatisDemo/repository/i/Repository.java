package com.showka.MyBatisDemo.repository.i;

import com.showka.MyBatisDemo.domain.DomainBase;
import com.showka.MyBatisDemo.entity.EntityBase;

public interface Repository<T extends EntityBase, D extends DomainBase> {

	/**
	 * insert
	 * 
	 * @param domain
	 */
	public void insert(D domain);

	/**
	 * update
	 * 
	 * @param domain
	 */
	public void update(D domain);

	/**
	 * deleteLogically
	 * 
	 * @param domain
	 */
	public void deleteLogically(D domain);

	/**
	 * deletePhysically
	 * 
	 * @param domain
	 */
	public void deletePhysically(D domain);

	/**
	 * EntityからDomainを生成
	 * 
	 * @param domain
	 *            Domain
	 * @return Entity
	 */
	public D createDoaminFromEntity(T entity);

	/**
	 * DomainからEntityを生成
	 * 
	 * @param entity
	 *            Entity
	 * @return Domain
	 */
	public T createEntityFromDomain(D domain);
}
