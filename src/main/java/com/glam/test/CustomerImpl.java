package com.glam.test;

import java.util.HashMap;

import org.apache.log4j.Logger;

/*Class to store & retrieve customer using hashmap*/
public class CustomerImpl implements CustomerDB{

	private static Logger logger = Logger.getLogger(CustomerImpl.class);
	
	private static HashMap<String, Customer> map= new HashMap<String,Customer>();
	
	@Override
	public void save(String id , Customer c) {
		map.put(id, c);
	}


	@Override
	public Customer retrieve(String id) {
		Customer c = map.get(id);
		
		if (c==null)
			logger.info("Id not found");
		else
		{
			logger.info("Name : "+c.getCust_name());
			logger.info("Address : "+c.getCust_addr());
		}
		return c;
		
	}
}
