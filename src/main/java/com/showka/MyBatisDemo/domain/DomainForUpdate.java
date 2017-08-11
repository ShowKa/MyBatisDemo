package com.showka.MyBatisDemo.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.showka.MyBatisDemo.repository.i.Repository;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DomainForUpdate {
	Class<? extends Repository> repository();
}
