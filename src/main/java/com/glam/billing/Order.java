package com.glam.billing;


import java.util.Iterator;
import java.util.List;


import org.apache.log4j.Logger;

import com.glam.customer.Customer;
import com.glam.customer.CustomerDB;
import com.glam.item.Item;
import com.google.inject.Inject;

//Order class responsible for making payment & billing
public class Order implements Gateway{

	 private Customer cust;
	 private List<Item> cart;
	 
	 private final CustomerDB cdb;
	 private final DBConfig db;
	 
	 private Logger logger = Logger.getLogger(Order.class);
	 
	 static int OrderID;
	 float billAmount;
	 String shippingAddress;
	 int offOnOrder;
	 String paymentMode;
	 String dateTimeOfDelivery;
	 
	@Inject
	 public Order(CustomerDB cdb,DBConfig db)
	 {
		 this.cdb=cdb;
		 this.db = db;
	 }
	 
	 public void updatePoints()
	 {
		 float sum=0;
		 Iterator<Item> itr = cart.iterator();
		 System.out.println("Item Details: ");
		 System.out.println("-----------------");
		 System.out.println(" Name \t  Price");
		 System.out.println("-----------------");
		 while(itr.hasNext())
		 {
			 Item itm = itr.next();
			 System.out.println(" "+itm.getItem_name()+"\t  "+itm.getItem_price());
			 sum = sum + itm.getItem_price();
		 }
		 System.out.println("---------------------");
		 System.out.println("Total Bill : "+sum);
		 System.out.println("---------------------");
		 if(sum<=2000 && sum>=1800)
		 {
			 sum=sum-200; offOnOrder=200;
			 System.out.println(" *Getting Rs 200/- Off");
		 }
		 else if(sum>2000 && sum<=5000)
		 {
			 sum=sum-500; offOnOrder=500;
			 System.out.println(" *Getting Rs 500/- Off");
		 }
		 else if(sum>5000 && sum<=10000)
		 {
			 sum=sum-1000; offOnOrder=1000;
			 System.out.println("\n *Getting Rs 1000/- Off");
		 }
		 else if(sum>10000)
		 {
			 System.out.println("You are our premium customer");
		 }
		 else
		 logger.info("\nProceeding for Final Billing...");
		 billAmount=sum;
		 }
	 
	 public void updateCustLevel()
	 {
		 if(billAmount>10000){
			 System.out.println("Please Collect Your Gift from Gift Counter....");
		 }
	 }
	 
	 @Override
	 public void makeBill()
	 {
		 OrderID++;
		 updatePoints();
		 updateCustLevel();
		 System.out.println("Order Id\t : "+OrderID + "\t\tShipping Address : "+cust.getCust_addr());
		 System.out.println("Date of Delivery : 1-Jan-2014"+ "\tPayment Mode\t : "+paymentMode);
		 System.out.println("Off on Order\t : "+"Rs."+offOnOrder+"/-"+"\tBill Amount\t: "+"Rs."+billAmount+"/-");
		 System.out.println("\t\t\t----Thank You!!!-----");
	 }
	 
	@Override
	public boolean makePayment(String id,List<Item> i,String type) {
		this.paymentMode=type;
		this.cust= cdb.retrieve(id);
		this.cart=i;
		System.out.println("\n\n----------------------- Making Payment ----------------------");
		System.out.println("Customer Name :"+cust.getCust_name() + " Customer Id : "+cust.getCust_id());
		System.out.println("URL = "+db.getURL() + " User = "+db.getDBUser() + " Pass = "+db.getDBPass());
		return true;
	}

}
