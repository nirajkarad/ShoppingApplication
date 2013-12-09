package com.glam.test;



import java.io.IOException;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class Test {
	
private static java.util.logging.Logger logger= Logger.getLogger(Test.class); 
		
	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure("log4j.properties");
				
		logger.info("-- Starting --");
		//Start: 1st Customer
		Customer c1 = new Customer("Raj", "4", "21", "Pune");
		Vector<Item> itm1 = new Vector<Item>();
		Item i1 = new Item("1", "Tshirt", "Nike Brand", 599);
		Item i2 = new Item("2", "Shoes", "Puma Brand", 499);
		Item i3 = new Item("3", "Jacket", "Woodsland Brand", 699);
		Item i4 = new Item("4", "Watch", "Titan Brand", 599);
		itm1.add(i1);
		itm1.add(i2);
		itm1.add(i3);
		itm1.add(i4);
		//End: 1st Customer
		
		//Start: 2nd Customer
		Customer c2 = new Customer("Ravi", "4", "21", "Pune");
		Vector<Item> itm2 = new Vector<Item>();
		Item i11 = new Item("1", "Tshirt", "Nike Brand", 999);
		Item i22 = new Item("2", "Shoes", "Puma Brand", 1599);
		Item i33 = new Item("3", "Jacket", "Woodsland Brand", 1799);
		Item i44 = new Item("4", "Watch", "Titan Brand", 5899);
		itm2.add(i11);
		itm2.add(i22);
		itm2.add(i33);
		itm2.add(i44);
		//End: 1st Customer

		
		
		
		Injector inj = Guice.createInjector(new TestModule());
		CustomerDB c_db = inj.getInstance(CustomerDB.class);
		Gateway gw = inj.getInstance(Gateway.class); 
		
		//For 1st Customer
		c_db.save(c1.getCust_id(), c1);
		gw.makePayment(c1.getCust_id(),itm1,"debit");
		gw.makeBill();
		
		//For 2nd Customer
		c_db.save(c2.getCust_id(), c2);
		gw.makePayment(c2.getCust_id(),itm2,"visa");
		gw.makeBill();
		
		logger.info("--Ending--");
	}
}
