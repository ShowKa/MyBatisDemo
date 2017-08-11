package com.showka.MyBatisDemo.system.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.showka.MyBatisDemo.domain.DomainBase;
import com.showka.MyBatisDemo.domain.DomainForUpdate;
import com.showka.MyBatisDemo.entity.EntityBase;
import com.showka.MyBatisDemo.repository.i.Repository;

@Component
public class Locker {

	@Autowired
	private ApplicationContext context;

	public void lock(DomainBase... domains) throws InstantiationException, IllegalAccessException {
		for (DomainBase d : domains) {
			DomainForUpdate dfu = d.getClass().getAnnotation(DomainForUpdate.class);
			if (dfu != null) {
				Class<Repository> repositoryClass = (Class<Repository>) dfu.repository();
				Repository<?, DomainBase> repository = context.getBean(repositoryClass);
				EntityBase e = repository.createEntityFromDomain(d);
				// select for updat
				System.out.println(e);
			}
		}

	}
}
