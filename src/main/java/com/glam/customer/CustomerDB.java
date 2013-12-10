package com.glam.customer;

public interface CustomerDB {
	void save(String id, Customer cust);
	Customer retrieve(String id);
	
}
