package com.showka.MyBatisDemo.entity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AsppectSetEntityColumnForTest {

	private static final String USER = "UnitTest";

	@Around("execution(* com.showka.MyBatisDemo.mapper.*.insert(..))")
	public Object aroundInsert(ProceedingJoinPoint pjp) throws Throwable {
		AbstractEntity entity = (AbstractEntity) pjp.getArgs()[0];
		entity.setCreateUserId(USER);
		entity.setUpdateUserId(USER);
		return pjp.proceed();
	}

	@Around("execution(* com.showka.MyBatisDemo.mapper.*.update(..))")
	public Object aroundUpdate(ProceedingJoinPoint pjp) throws Throwable {
		AbstractEntity entity = (AbstractEntity) pjp.getArgs()[0];
		entity.setUpdateUserId(USER);
		return pjp.proceed();
	}
}
