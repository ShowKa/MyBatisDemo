package com.showka.MyBatisDemo.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.showka.MyBatisDemo.system.exception.OptimistickLockException;

@Aspect
@Component
public class AsppectOptimistickLock {

	@AfterReturning(pointcut = "execution(* com.showka.MyBatisDemo.mapper.*.update(..))", returning = "retVal")
	public void checkOptimisticLockError(Object retVal) {
		boolean result = (boolean) retVal;
		if (!result) {
			throw new OptimistickLockException("Optimistic Lock Error Occured!!!!");
		}
	}
}
