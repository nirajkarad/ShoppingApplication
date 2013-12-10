package com.glam.test;

import java.util.List;

public interface Gateway {
	
	public boolean makePayment(String id,List<Item> itm,String pay_type);
	public void makeBill();
	
	
	
}
