package com.glam.modules;

import com.glam.billing.DBConfig;
import com.glam.billing.Gateway;
import com.glam.billing.Order;
import com.glam.billing.Payment;
import com.glam.customer.CustomerDB;
import com.glam.customer.CustomerImpl;
import com.google.inject.AbstractModule;

public class TestModule extends AbstractModule{

	@Override
	public void configure() {

		bind(CustomerDB.class).to(CustomerImpl.class);
		bind(Gateway.class).to(Order.class);
		bind(DBConfig.class).toProvider(Payment.class);

	}

}
