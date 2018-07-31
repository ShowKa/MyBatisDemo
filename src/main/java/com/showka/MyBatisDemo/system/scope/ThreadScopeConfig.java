package com.showka.MyBatisDemo.system.scope;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadScopeConfig {

	@Bean
	public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
		System.out.println("thread scope の Config が呼ばれたよ！");
		return new ThreadBeanFactoryPostProcessor();
	}
}
