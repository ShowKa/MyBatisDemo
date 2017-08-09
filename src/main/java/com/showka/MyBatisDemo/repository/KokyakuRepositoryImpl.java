package com.showka.MyBatisDemo.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.showka.MyBatisDemo.domain.KokyakuDomain;
import com.showka.MyBatisDemo.domain.builder.KokyakuDomainBuilder;
import com.showka.MyBatisDemo.entity.MKokyaku;
import com.showka.MyBatisDemo.kubun.HanbaiKubun;
import com.showka.MyBatisDemo.kubun.KokyakuKubun;
import com.showka.MyBatisDemo.kubun.i.Kubun;
import com.showka.MyBatisDemo.mapper.MKokyakuMapper;
import com.showka.MyBatisDemo.repository.i.BushoRepository;
import com.showka.MyBatisDemo.repository.i.KokyakuRepository;

public class KokyakuRepositoryImpl implements KokyakuRepository {

	@Autowired
	private MKokyakuMapper mapper;

	@Autowired
	private BushoRepository bushoRepository;

	@Override
	public void insert(KokyakuDomain domain) {
		MKokyaku e = createEntityFromDomain(domain);
		mapper.insert(e);
	}

	@Override
	public void update(KokyakuDomain domain) {
		MKokyaku e = createEntityFromDomain(domain);
		mapper.update(e);
	}

	@Override
	public void deleteLogically(KokyakuDomain domain) {
		MKokyaku e = createEntityFromDomain(domain);
		mapper.deleteLogically(e);
	}

	@Override
	public void deletePhysically(KokyakuDomain domain) {
		MKokyaku e = createEntityFromDomain(domain);
		mapper.deletePhysically(e);
	}

	@Override
	public KokyakuDomain createDoaminFromEntity(MKokyaku entity) {
		KokyakuDomainBuilder b = new KokyakuDomainBuilder();
		b.withAddress(entity.getAddress());
		b.withCode(entity.getCode());
		b.withHanbaiKubun(Kubun.get(HanbaiKubun.class, entity.getHanbai_kubun()));
		b.withKokyakuKubun(Kubun.get(KokyakuKubun.class, entity.getKokyaku_kubun()));
		b.withName(entity.getName());
		b.withShukanBushoDomain(bushoRepository.selectByPK(entity.getShukan_busho_code()));
		b.withVersion(entity.getVersion());
		KokyakuDomain d = b.build();
		return d;
	}

	@Override
	public MKokyaku createEntityFromDomain(KokyakuDomain domain) {
		MKokyaku e = new MKokyaku();
		e.setAddress(domain.getAddress());
		e.setCode(domain.getCode());
		e.setHanbai_kubun(domain.getHanbaiKubun().getCode());
		e.setKokyaku_kubun(domain.getHanbaiKubun().getCode());
		e.setName(domain.getName());
		e.setShukan_busho_code(domain.getShukanBushoDomain().getCode());
		e.setVersion(domain.getVersion());
		return e;
	}

	@Override
	public KokyakuDomain selectByPK(String code) {
		MKokyaku e = mapper.selectByPK(code);
		KokyakuDomain d = createDoaminFromEntity(e);
		return d;
	}

}
