package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public List<Account> getAccounts(){
	return accounts ;}

    public void setAccounts (List<Account> accountList ){
	this.accounts=accountList ; }

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        this.accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return this.accounts.size();
    }

    public double totalInterestEarned(Customer customer) {
        double total = 0;
        Account accounts= customer.getAccounts();

        for (Account a : accounts)
            total += a.interestEarned(a);
        return total;
    }

    public String getStatement() {
        String statement = null;
        statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : this.getAccounts()) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private String statementForAccount(Account a) {
        String s = "";

       //Translate to pretty account type
        switch(a.getAccountType()){
            case Account.CHECKING:
                s += "Checking Account\n";
                break;
            case Account.SAVINGS:
                s += "Savings Account\n";
                break;
            case Account.MAXI_SAVINGS:
                s += "Maxi Savings Account\n";
                break;
        }

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction t : a.getTransactions()) {
            s += "  " + (t.amount < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.amount) + "\n";
            total += t.amount;
        }
        s += "Total " + toDollars(total);
        return s;
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
	
	//tis method will transfer amount between accounts , from account1 to account2 depending upon weather it has that minimum amount or not
	public boolean transferBWAccounts(Account account1,Account account2,double amount) {
		
		double account1Balance = 0.0;
        account1Balance = account1.sumTransactions();
        
		//can use sql transactions as well when we will implement database in the same
		if(amount>0 & account1Balance > amount){
        account1.withdraw(amount);
		account2.deposit(amount);
		return true;
        }
		return false;
    }

}
