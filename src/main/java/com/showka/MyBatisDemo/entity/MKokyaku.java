package com.showka.MyBatisDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 顧客マスタ
 * 
 */
@Entity
@Table(name = "m_kokyaku")
@Getter
@Setter
public class MKokyaku extends EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code", unique = true, nullable = false, length = 4)
	private String code;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "address", nullable = false, length = 255)
	private String address;

	@Column(name = "kokyaku_kubun", nullable = false, length = 2)
	private String kokyaku_kubun;

	@Column(name = "hanbai_kubun", nullable = false, length = 2)
	private String hanbai_kubun;

	@Column(name = "shukan_busho_code", nullable = false, length = 4)
	private String shukan_busho_code;

}