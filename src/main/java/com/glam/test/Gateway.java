package com.glam.test;

import java.util.Vector;

public interface Gateway {
	
	public boolean makePayment(String id,Vector<Item> itm,String pay_type);
	public void makeBill();
	
	
	
}
