package com.practise;


import java.util.LinkedList;
import java.util.List;

import com.glam.billing.Gateway;
import com.glam.customer.Customer;
import com.glam.customer.CustomerDB;
import com.glam.item.Item;
import com.glam.modules.TestModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{

	private Injector inj;
	private CustomerDB c_db;
	private Gateway gw;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		System.setProperty("db_name", "visa");
		
		inj = Guice.createInjector(new TestModule());
		c_db = inj.getInstance(CustomerDB.class);
		gw = inj.getInstance(Gateway.class); 
	}
	
/*    public AppTest( String testName )
    {
        super( testName );
    }
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    public void testApp()
    {
	    assert(true);
    }*/
    
    
    public void testCustomer1(){
    	
    	//Start: 1st Customer
		Customer c1 = new Customer("Raj", "4", "21", "Pune");
		
		assertNotNull("Checking Customer 1 ", c1);
		
		List<Item> itm1 = new LinkedList<Item>();
		Item i1 = new Item("1", "Tshirt", "Nike Brand", 599);
		Item i2 = new Item("2", "Shoes", "Puma Brand", 499);
		Item i3 = new Item("3", "Jacket", "Woodsland Brand", 699);
		Item i4 = new Item("4", "Watch", "Titan Brand", 599);
		assertEquals(0, itm1.size());
		itm1.add(i1);
		assertEquals(1, itm1.size());
		itm1.add(i2);
		assertEquals(2, itm1.size());
		itm1.add(i3);
		assertEquals(3, itm1.size());
		itm1.add(i4);
		assertEquals(4, itm1.size());
		
		c_db.save(c1.getCust_id(), c1);
		gw.makePayment(c1.getCust_id(),itm1,"debit");
		
		assertEquals( 1896,  gw.makeBill(), 0.00);
    }
    
    public void testCustomer2(){
    	Customer c2 = new Customer("Ravi", "4", "21", "Pune");
    	assertNotNull("Checking Customer 2 ", c2);
		List<Item> itm2 = new LinkedList<Item>();
		Item i11 = new Item("1", "Tshirt", "Nike Brand", 999);
		Item i22 = new Item("2", "Shoes", "Puma Brand", 1599);
		Item i33 = new Item("3", "Jacket", "Woodsland Brand", 1799);
		Item i44 = new Item("4", "Watch", "Titan Brand", 5899);
		assertEquals(0, itm2.size());
		itm2.add(i11);
		assertEquals(1, itm2.size());
		itm2.add(i22);
		assertEquals(2, itm2.size());
		itm2.add(i33);
		assertEquals(3, itm2.size());
		itm2.add(i44);
		assertEquals(4, itm2.size());
		
		c_db.save(c2.getCust_id(), c2);
		gw.makePayment(c2.getCust_id(),itm2,"visa");
		
		assertEquals( 8796, gw.makeBill(), 0.00);
    }
    
}
