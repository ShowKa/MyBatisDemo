package com.showka.MyBatisDemo.system.aspect;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.showka.MyBatisDemo.system.exception.TooMuchResultException;

@Aspect
@Component
public class CheckSearchMapperResultSize {

	private Logger logger = Logger.getLogger(CheckSearchMapperResultSize.class);

	/**
	 * システムが許容する検索結果の最大件数
	 */
	@Value("${framework.max_size_of_search_result}")
	private int max;

	/**
	 * 検索結果の件数チェック
	 * 
	 * @param retVal
	 *            検索結果
	 * @return 件数が許容範囲内であれば、そのまま呼び出しもとのメソッドに検索結果を返却する。
	 */
	@AfterReturning(pointcut = "execution(* com.showka.MyBatisDemo.common.SearchMapper+.*(..))", returning = "retVal")
	public Object checkSearchResultSizeForSearchMapper(Object retVal) {

		// 1未満であれば何もしない
		if (max < 1) {
			return retVal;
		}

		// get search result
		Collection<?> result;
		try {
			result = (Collection<?>) retVal;
		} catch (RuntimeException e) {
			logger.warn("検索結果の件数チェックが行なえませんでした。検索メソッドの返却値がjava.util.Listでない可能性があります。", e);
			return retVal;
		}

		// check size
		if (result.size() > max) {
			throw new TooMuchResultException();
		}
		return retVal;
	}

}
