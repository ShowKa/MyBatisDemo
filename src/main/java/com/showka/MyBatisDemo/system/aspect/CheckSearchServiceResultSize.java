package com.showka.MyBatisDemo.system.aspect;

import java.util.Collection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.showka.MyBatisDemo.common.SearchType;
import com.showka.MyBatisDemo.system.exception.TooMuchResultException;

@Aspect
@Component
public class CheckSearchServiceResultSize {
	/**
	 * 画面検索が許容する検索結果の最大件数
	 */
	@Value("${framework.max_size_of_screen}")
	private int MAX_SCREEN;

	/**
	 * 画面検索が許容する検索結果の最大件数
	 */
	@Value("${framework.max_size_of_report}")
	private int MAX_REPORT;

	@Around("execution(public java.util.Collection+ com.showka.MyBatisDemo..*.*(..)) && args(..,searchType)")
	public Object checkSearchResultSizeForSearchService(ProceedingJoinPoint pjp, SearchType searchType)
			throws Throwable {
		Object ret = pjp.proceed();
		Collection<?> result = (Collection<?>) ret;

		switch (searchType) {
		case SCREEN:
			if (result.size() > MAX_SCREEN) {
				throw new TooMuchResultException();
			}
			break;
		case REPORT:
			if (result.size() > MAX_REPORT) {
				throw new TooMuchResultException();
			}
			break;
		}
		return ret;
	}
}
