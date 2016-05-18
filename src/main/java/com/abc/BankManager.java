package com.abc;

import java.util.ArrayList;
import java.util.List;

/*
* this class is for report generation
*/
public class BankManager {
	
	private Bank bank ;
	
	public void setBank(Bank bank){
		this.bank=bank;
	}
	
	public Bank getBank(){
		return bank;
	}
	
	/*
	*getting all the accounts associated with bank : getting the report
    */
	public boolean showCustomerAccounts(Bank bank) {
			
		//get the type of bank from user and then get the customer list and account list out
		// for the requirement to show the customer associated in the bank and their corresponding accounts
		
		Account accounts = null;  //will get it from customer object
		Customer customers = bank.getCustomerList();
		
		//it will display customer and the number of account each customer holds, mentioned in the requirement
		for (Customer c : customers){
			// we can use logger here
			System.out.println("the customer name is "+c.getName()+"accounts the customer hold are "+c.getNumberOfAccounts());
		}
		//we can store it in a map , key will be customer and value will be the accounts one customer is holding
		//we can return the map from here and in JUNIt , I can put an assertFalse on my map being empty 
		//as of now returning true if I have at least 1 customer in my bank
		if(customers.size()>0)
		    return true;
		else
		false;
	}
		
		
	/*
	*getting all the interest earned by bank : getting the report
	*/
	public double showTotalInterest(Bank bank){
		Customer customers = bank.getCustomerList();
		double totalInterestPaid =0.0 ;
		//it will display all customers with all their accounts
		for (Customer c : customers){
			for (Account account : c.getAccounts() )
			totalInterestPaid += account.interestEarned();
		System.out.println("calculating for the customer name "+c.getName());
		}
		
		System.out.println("total interest earned by bank by all the customers "+totalInterestPaid);
		return totalInterestPaid;
	}


	//here use main method , where user will give the bank it wants to get information from like BOA etc ... call above m() from main m() .
	
}
