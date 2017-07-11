package com.showka.MyBatisDemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity Base.
 *
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

	/**
	 * version
	 */
	@Version
	@Column(name = "version", nullable = false, columnDefinition = "INTEGER DEFAULT 1")
	private Integer version;

	/**
	 * create_user_id
	 */
	@Column(name = "create_user_id", unique = false, nullable = false, length = 255, columnDefinition = "VARCHAR DEFAULT 'default'")
	private String create_user_id;

	/**
	 * create_timestamp
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_timestamp", unique = false, nullable = false, length = 255, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date create_timestamp;

	/**
	 * update_user_id
	 */
	@Column(name = "update_user_id", unique = false, nullable = false, length = 255, columnDefinition = "VARCHAR DEFAULT 'default'")
	private String update_user_id;

	/**
	 * update_timestamp
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_timestamp", unique = false, nullable = false, length = 255, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date update_timestamp;

	/**
	 * 文字列化
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
