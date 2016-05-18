package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankManagerTest {

	
    @Test
    public void showTotalInterestTest() {
		BankManager bankManager = new BankManager();
		
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
		
		Customer Johnson = new Customer("Johnson");
        Johnson.openAccount(new Account(Account.CHECKING));
		
        bank.addCustomer(john);
		bank.addCustomer(Johnson);
		
		// we could have used mockito over here to mock the response from various method within , but as there is no database hit we are not bothered about
		// runtime db connection exceptions and so not using mock , otherwise we can use the same .
        assertFalse(0.0, bankManager.showTotalInterest(bank));
    }

    @Test
    public void showCustomerAccounts_Test() {
		BankManager bankManager = new BankManager();
		
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
		john.openAccount(new Account(Account.SAVINGS));
		
		Customer Johnson = new Customer("Johnson");
        Johnson.openAccount(new Account(Account.CHECKING));
		
        bank.addCustomer(john);
		bank.addCustomer(Johnson);
		
		// we could have used mockito over here to mock the response from various method within , but as there is no database hit we are not bothered about
		// runtime db connection exceptions and so not using mock , otherwise we can use the same .
        assertTrue(assertTrue, bankManager.showCustomerAccounts(bank));

    }

}
