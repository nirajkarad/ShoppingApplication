package com.glam.billing;

import java.util.List;

import com.glam.item.Item;

public interface Gateway {
	
	public boolean makePayment(String id,List<Item> itm,String pay_type);
	public float makeBill();
	
	
	
}
