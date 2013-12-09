package com.glam.test;

//Item Class to store Items
public class Item{

	private String item_name;
	private String item_desc;
	private float item_price;
	private String item_id;
	
	Item(String id, String name,String desc,float price)
	{
		this.item_id=id;
		this.item_name=name;
		this.item_desc =desc;
		this.item_price=price;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_desc() {
		return item_desc;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

	public float getItem_price() {
		return item_price;
	}

	public void setItem_price(float item_price) {
		this.item_price = item_price;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	
}
