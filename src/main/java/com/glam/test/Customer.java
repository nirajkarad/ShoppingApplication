package com.glam.test;

/*Customer class to save customer information*/
public class Customer {
	
	private String cust_name;
	private String cust_id;
	private String cust_age;
	private String cust_addr;
	
	public Customer(String name, String id, String age,String addr) {
		this.cust_name = name;
		this.cust_id= id;
		this.cust_age  = age;
		this.cust_addr = addr;
	}
	
	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_age() {
		return cust_age;
	}

	public void setCust_age(String cust_age) {
		this.cust_age = cust_age;
	}

	public String getCust_addr() {
		return cust_addr;
	}

	public void setCust_addr(String cust_addr) {
		this.cust_addr = cust_addr;
	}

}
