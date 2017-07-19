package com.showka.MyBatisDemo.entity;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.showka.MyBatisDemo.system.exception.LoginUser;

@Aspect
@Component
public class AsppectSetEntityColum {

	@Autowired
	HttpSession session;

	@Around("execution(* com.showka.MyBatisDemo.mapper.*.insert(..))")
	public Object aroundInsert(ProceedingJoinPoint pjp) throws Throwable {
		EntityBase entity = (EntityBase) pjp.getArgs()[0];
		entity.setCreateUserId(getUserId());
		entity.setUpdateUserId(getUserId());
		return pjp.proceed();
	}

	@Around("execution(* com.showka.MyBatisDemo.mapper.*.update(..))")
	public Object aroundUpdate(ProceedingJoinPoint pjp) throws Throwable {
		EntityBase entity = (EntityBase) pjp.getArgs()[0];
		entity.setUpdateUserId(getUserId());
		return pjp.proceed();
	}

	@Around("execution(* com.showka.MyBatisDemo.mapper.*.deleteLogically(..))")
	public Object aroundDeleteLogically(ProceedingJoinPoint pjp) throws Throwable {
		EntityBase entity = (EntityBase) pjp.getArgs()[0];
		entity.setUpdateUserId(getUserId());
		entity.deleteLogically();
		return pjp.proceed();
	}

	private String getUserId() {
		LoginUser user = (LoginUser) session.getAttribute("user");
		return user.getUserId();
	}
}
