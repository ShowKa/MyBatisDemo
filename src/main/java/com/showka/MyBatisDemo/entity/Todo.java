package com.showka.MyBatisDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todo")
@Getter
@Setter
public class Todo extends EntityBase {

	@Id
	@Column(name = "title", nullable = false, length = 255)
	private String title;

	@Column(name = "details", nullable = false, length = 255)
	private String details;

	@Column(name = "finished", nullable = false)
	private boolean finished;
}
