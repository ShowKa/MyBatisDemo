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
public abstract class AbstractEntity {

	/**
	 * version
	 */
	@Version
	@Column(name = "version", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
	@Getter
	@Setter
	private Integer version = 0;

	/**
	 * 論理削除
	 */
	public void deleteLogically() {
		deleted = true;
	}

	/**
	 * create_user_id
	 */
	@Column(name = "create_user_id", unique = false, nullable = false, length = 255, columnDefinition = "VARCHAR DEFAULT 'default'")
	private String create_user_id = "default";

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
	private String update_user_id = "default";;

	/**
	 * update_timestamp
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_timestamp", unique = false, nullable = false, length = 255, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date update_timestamp;

	/**
	 * update_timestamp
	 */
	@Column(name = "deleted", unique = false, nullable = false)
	private boolean deleted = false;

	/**
	 * 文字列化
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * 論理をやめてレコードを復活させる。
	 */
	public void restore() {
		deleted = false;
	}

	/**
	 * 論理削除済みチェック
	 * 
	 * @return 削除済みならtrue
	 */
	public boolean isLogicallyDeleted() {
		return deleted;
	}

}
