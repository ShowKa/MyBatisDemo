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

	@Around("execution(* com.showka.MyBatisDemo.mapper.IMapper+.insert(..))")
	public Object aroundInsert(ProceedingJoinPoint pjp) throws Throwable {
		EntityBase entity = (EntityBase) pjp.getArgs()[0];
		entity.setCreateUserId(getUserId());
		entity.setUpdateUserId(getUserId());
		entity.setVersion(0);
		return pjp.proceed();
	}

	@Around("execution(* com.showka.MyBatisDemo.mapper.IMapper+.update(..))")
	public Object aroundUpdate(ProceedingJoinPoint pjp) throws Throwable {
		EntityBase entity = (EntityBase) pjp.getArgs()[0];
		entity.setUpdateUserId(getUserId());
		Object ret = pjp.proceed();
		entity.setVersion(entity.getVersion() + 1);
		return ret;
	}

	@Around("execution(* com.showka.MyBatisDemo.mapper.IMapper+.deleteLogically(..))")
	public Object aroundDeleteLogically(ProceedingJoinPoint pjp) throws Throwable {
		EntityBase entity = (EntityBase) pjp.getArgs()[0];
		entity.setUpdateUserId(getUserId());
		entity.deleteLogically();
		Object ret = pjp.proceed();
		entity.setVersion(entity.getVersion() + 1);
		return ret;
	}

	private String getUserId() {
		LoginUser user = (LoginUser) session.getAttribute("user");
		return user.getUserId();
	}
}
