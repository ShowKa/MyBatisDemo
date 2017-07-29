package com.showka.MyBatisDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the m_nyukin_kake_info database table.
 * 
 */
@Entity
@Table(name = "m_nyukin_kake_info")
@Setter
@Getter
public class MNyukinKakeInfo extends EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "kokyaku_code", nullable = false, length = 4)
	private String kokyaku_code;

	@Column(name = "nyukin_hoho_kubun", nullable = false, length = 2)
	private String nyukin_hoho_kubun;

	@Column(name = "nyukin_tsuki_kubun", nullable = false, length = 2)
	private String nyukin_tsuki_kubun;

	@Column(name = "shimebi", nullable = false)
	private int shimebi;

	@Column(name = "nyukin_date", nullable = false)
	private int nyukin_date;

}