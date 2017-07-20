package com.showka.MyBatisDemo.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.showka.MyBatisDemo.system.exception.OptimistickLockException;

@Aspect
@Component
public class AsppectOptimistickLock {

	@AfterReturning(pointcut = "execution(* com.showka.MyBatisDemo.mapper.*.update(..))", returning = "retVal")
	public void checkOptimisticLockErrorWhenUpdate(Object retVal) {
		check((boolean) retVal);
	}

	@AfterReturning(pointcut = "execution(* com.showka.MyBatisDemo.mapper.*.deleteLogically(..))", returning = "retVal")
	public void checkOptimisticLockErrorWhenDeleteLogically(Object retVal) {
		check((boolean) retVal);
	}

	@AfterReturning(pointcut = "execution(* com.showka.MyBatisDemo.mapper.*.deletePhysically(..))", returning = "retVal")
	public void checkOptimisticLockErrorWhenDeletePhysically(Object retVal) {
		check((boolean) retVal);
	}

	/**
	 * 
	 * @param result
	 */
	private static void check(boolean result) {
		if (!result) {
			throw new OptimistickLockException("Optimistic Lock Error Occured!!!!");
		}
	}
}