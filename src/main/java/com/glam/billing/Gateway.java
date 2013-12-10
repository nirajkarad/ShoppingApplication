package com.glam.billing;

import java.util.List;

public interface Gateway {
	
	public boolean makePayment(String id,List<Item> itm,String pay_type);
	public void makeBill();
	
	
	
}
