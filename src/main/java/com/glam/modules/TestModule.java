package com.glam.modules;

import com.google.inject.AbstractModule;

public class TestModule extends AbstractModule{

	@Override
	public void configure() {

		bind(CustomerDB.class).to(CustomerImpl.class);
		bind(Gateway.class).to(Order.class);
		bind(DBConfig.class).toProvider(Payment.class);

	}

}
