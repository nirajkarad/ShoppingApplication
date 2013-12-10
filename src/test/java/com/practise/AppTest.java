package com.practise;

import static org.junit.Assert.assertEquals;

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
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testApp()
    {
		MyClass tester = new MyClass();
	    assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
    }
    
    
    public void testCustomer1(){
    	System.setProperty("db_name", "visa");
    	//Start: 1st Customer
		Customer c1 = new Customer("Raj", "4", "21", "Pune");
		List<Item> itm1 = new LinkedList<Item>();
		Item i1 = new Item("1", "Tshirt", "Nike Brand", 599);
		Item i2 = new Item("2", "Shoes", "Puma Brand", 499);
		Item i3 = new Item("3", "Jacket", "Woodsland Brand", 699);
		Item i4 = new Item("4", "Watch", "Titan Brand", 599);
		itm1.add(i1);
		itm1.add(i2);
		itm1.add(i3);
		itm1.add(i4);
		//End: 1st Customer
			
		Injector inj = Guice.createInjector(new TestModule());
		CustomerDB c_db = inj.getInstance(CustomerDB.class);
		Gateway gw = inj.getInstance(Gateway.class); 
		
		//For 1st Customer
		c_db.save(c1.getCust_id(), c1);
		gw.makePayment(c1.getCust_id(),itm1,"debit");
		float amount1 = gw.makeBill();
		
		assertEquals( 1896, amount1, 0.00);
    }
    
    public void testCustomer2(){
    	System.setProperty("db_name", "visa");
    	
    	Customer c2 = new Customer("Ravi", "4", "21", "Pune");
		List<Item> itm2 = new LinkedList<Item>();
		Item i11 = new Item("1", "Tshirt", "Nike Brand", 999);
		Item i22 = new Item("2", "Shoes", "Puma Brand", 1599);
		Item i33 = new Item("3", "Jacket", "Woodsland Brand", 1799);
		Item i44 = new Item("4", "Watch", "Titan Brand", 5899);
		itm2.add(i11);
		itm2.add(i22);
		itm2.add(i33);
		itm2.add(i44);
		//End: 2nd Customer
		
		Injector inj = Guice.createInjector(new TestModule());
		CustomerDB c_db = inj.getInstance(CustomerDB.class);
		Gateway gw = inj.getInstance(Gateway.class); 			
		
		//For 2nd Customer
		c_db.save(c2.getCust_id(), c2);
		gw.makePayment(c2.getCust_id(),itm2,"visa");
		float amount2 = gw.makeBill();
		
		assertEquals( 8796, amount2, 0.00);
    }
    
}
