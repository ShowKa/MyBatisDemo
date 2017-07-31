package com.showka.MyBatisDemo.common;

import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.showka.MyBatisDemo.system.exception.TooMuchResultException;

@Aspect
@Component
public class AspectSearchResultSize {

	private static final int max = 300000;

	/**
	 * 検索結果の件数チェック
	 * 
	 * @param retVal
	 *            検索結果
	 * @return 件数が許容範囲内であれば、そのまま呼び出しもとのメソッドに検索結果を返却する。
	 */
	@AfterReturning(pointcut = "execution(* com.showka.MyBatisDemo.common.SearchMapper+.*(..))", returning = "retVal")
	public Object checkSearchResultSize(Object retVal) {
		// get search result
		List<?> result;
		try {
			result = (List<?>) retVal;
		} catch (RuntimeException e) {
			System.out.println("検索結果の件数チェックが行なえませんでした。");
			System.out.println("検索メソッドの返却値がjava.util.Listでない可能性があります。");
			e.printStackTrace();
			return retVal;
		}
		// check size
		if (result.size() > max) {
			throw new TooMuchResultException();
		}
		return retVal;
	}

}
