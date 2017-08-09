package com.showka.MyBatisDemo.domain.builder;

import com.showka.MyBatisDemo.domain.BushoDomain;
import com.showka.MyBatisDemo.domain.KokyakuDomain;
import com.showka.MyBatisDemo.kubun.HanbaiKubun;
import com.showka.MyBatisDemo.kubun.KokyakuKubun;

public class KokyakuDomainBuilder extends DomainBuilderBase<KokyakuDomain, KokyakuDomainBuilder> {

	// private member
	/** code */
	private String code;

	/** kokyakuKubun */
	private KokyakuKubun kokyakuKubun;

	/** hanbaiKubun */
	private HanbaiKubun hanbaiKubun;

	/** name */
	private String name;

	/** address */
	private String address;

	/** shukanBushoDomain */
	private BushoDomain shukanBushoDomain;

	/** version */
	private Integer version;

	// protected method
	@Override
	protected void apply(KokyakuDomain domain, KokyakuDomainBuilder builder) {
		builder.withCode(domain.getCode());
		builder.withKokyakuKubun(domain.getKokyakuKubun());
		builder.withHanbaiKubun(domain.getHanbaiKubun());
		builder.withName(domain.getName());
		builder.withAddress(domain.getAddress());
		builder.withShukanBushoDomain(domain.getShukanBushoDomain());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected KokyakuDomain createDomainObject() {
		return new KokyakuDomain(code, kokyakuKubun, hanbaiKubun, name, address, shukanBushoDomain, version);
	}

	@Override
	protected KokyakuDomainBuilder getThis() {
		return this;
	}

	@Override
	protected KokyakuDomainBuilder newInstance() {
		return new KokyakuDomainBuilder();
	}

	// public method
	/**
	 * {@link KokyakuDomain}に与えるcodeをこのビルダに設定する。
	 *
	 * @param code
	 *            code
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withCode(final String code) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.code = code;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与えるkokyakuKubunをこのビルダに設定する。
	 *
	 * @param kokyakuKubun
	 *            kokyakuKubun
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withKokyakuKubun(final KokyakuKubun kokyakuKubun) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.kokyakuKubun = kokyakuKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与えるhanbaiKubunをこのビルダに設定する。
	 *
	 * @param hanbaiKubun
	 *            hanbaiKubun
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withHanbaiKubun(final HanbaiKubun hanbaiKubun) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.hanbaiKubun = hanbaiKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与えるnameをこのビルダに設定する。
	 *
	 * @param name
	 *            name
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withName(final String name) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.name = name;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与えるaddressをこのビルダに設定する。
	 *
	 * @param address
	 *            address
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withAddress(final String address) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.address = address;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与えるshukanBushoDomainをこのビルダに設定する。
	 *
	 * @param shukanBushoDomain
	 *            shukanBushoDomain
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withShukanBushoDomain(final BushoDomain shukanBushoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.shukanBushoDomain = shukanBushoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与えるversionをこのビルダに設定する。
	 *
	 * @param version
	 *            version
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withVersion(final Integer version) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}