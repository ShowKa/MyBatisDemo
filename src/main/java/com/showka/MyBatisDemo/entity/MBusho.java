package com.showka.MyBatisDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 部署マスタ
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "m_busho")
@Getter
@Setter
public class MBusho extends EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code", nullable = false, length = 4)
	private String code;

	@Column(name = "busho_kubun", nullable = false, length = 2)
	private String busho_kubun;

	@Column(name = "jigyo_kubun", nullable = false, length = 2)
	private String jigyo_kubun;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

}