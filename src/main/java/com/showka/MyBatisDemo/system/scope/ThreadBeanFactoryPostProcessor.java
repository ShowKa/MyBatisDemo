package com.showka.MyBatisDemo.system.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.SimpleThreadScope;

public class ThreadBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// beanFactory.registerScope("thread", new ThreadScope());
		System.out.println("simple thread scope を登録します。");
		beanFactory.registerScope("thread", new SimpleThreadScope());
	}

}
