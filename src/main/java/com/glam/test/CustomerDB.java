package com.glam.test;

/*An interface to do action for customer*/
public interface CustomerDB {
	void save(String id, Customer cust);
	Customer retrieve(String id);
	
}
