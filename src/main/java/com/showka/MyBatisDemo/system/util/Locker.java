package com.showka.MyBatisDemo.system.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.showka.MyBatisDemo.domain.DomainBase;
import com.showka.MyBatisDemo.domain.DomainForUpdate;
import com.showka.MyBatisDemo.entity.EntityBase;
import com.showka.MyBatisDemo.entity.EntityComparator;
import com.showka.MyBatisDemo.repository.i.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
public class Locker {

	@Autowired
	private ApplicationContext context;

	public void lock(DomainBase... domains) {

		List<UpdateEntity> entityList = new ArrayList<UpdateEntity>();

		for (DomainBase d : domains) {
			DomainForUpdate dfu = d.getClass().getAnnotation(DomainForUpdate.class);
			if (dfu != null) {
				Class<? extends Repository> repositoryClass = dfu.repository();
				Repository<? extends EntityBase, DomainBase> repository = context.getBean(repositoryClass);
				EntityBase e = repository.createEntityFromDomain(d);
				entityList.add(new UpdateEntity(repository, e));
			}
		}

		Comparator<UpdateEntity> c = Comparator.comparing((UpdateEntity e) -> e.getClass().getName())
				.thenComparing((e1, e2) -> new EntityComparator().compare(e1.getEntity(), e2.getEntity()));
		entityList.sort(c);

		for (UpdateEntity ue : entityList) {
			ue.getRepository().selectForUpdate(ue.getEntity());
		}
	}
}

@Setter
@Getter
@AllArgsConstructor
class UpdateEntity<T extends EntityBase> {
	Repository<T, DomainBase> repository;
	T entity;
}