package com.showka.MyBatisDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@Column(name = "kokyaku_id", nullable = false, length = 4)
	private String kokyakuId;

	@Column(name = "nyukin_hoho_kubun", nullable = false, length = 2)
	private String nyukinHohoKubun;

	@Column(name = "nyukin_tsuki_kubun", nullable = false, length = 2)
	private String nyukinTsukiKubun;

	@Column(name = "shimebi", nullable = false)
	private int shimebi;

	@Column(name = "nyukin_date", nullable = false)
	private int nyukinDate;

}