package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;

    private int accountType;
    private List<Transaction> transactions;

    public void setTransactions (List<Transaction transactions){
           this.transactions=transactions;

	}


	public List<Transaction> getTransactions(){
           return this.transactions;

	}

    public Account(int accountType) {
        this.accountType = accountType;
        this.setTransactions (new ArrayList<Transaction>());
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            this.getTransactions().add(new Transaction(amount));
        }
    }

public void withdraw(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("amount must be greater than zero");
    } else {
        this.gettransactions().add(new Transaction(-amount));
    }
}

    public double interestEarned(Account account) {
		double period = 365;  // calculated on daily basis but paid annually
		double third_Part_Interest = 0.0d;
		double partial_Interest = 0.0d;
		double second_Part_Interest 0.0d;
		double int_rate_First = 0.0d;
		double int_rate_Second = 0.0d;
		double int_rate_Third = 0.0d;

        double amount = sumTransactions();
        switch(account.accountType){
            case SAVINGS:
			int_Rate_First = 0.001/365;
			int_Rate_Second = 0.002/365;
			if(amount<=1000){
				partial_Interest = (amount * Math.pow((1+ int_Rate_First), period)) - amount; 
				return partial_Interest;
			}
			else if(amount>1000){
				partial_Interest = (amount * Math.pow((1+ int_Rate_First),period)) - 1000;
				second_Part_Interest = ((amount-1000) * Math.pow((1+ int_Rate_Second),period)) -(amount-1000);
				return partial_Interest + second_Part_Interest;
			}
                //if (amount <= 1000)
                  //  return amount * 0.001;
                //else
                  //  return 1 + (amount-1000) * 0.002;
//            case SUPER_SAVINGS:
//                if (amount <= 4000)
//                    return 20;
			case CHECKING:
				int_Rate_First = 0.001/365;
				partial_Interest = (amount * Math.pow((1+ int_Rate_First), period)) - amount; 
				return partial_Interest;

		    case MAXI_SAVINGS:
				int_Rate_First = 0.02/365;
				int_Rate_Second = 0.05/365;
				int_Rate_Third = 0.1/365;
				int_Rate_Fourth = 0.001/365;

				//need to add condition to check if any withdrawals made in last 10 days and accordingly change the rate
				if( ){
				int_Rate_First = 0.05/365;
				int_Rate_Third = 0.05/365;
				int_Rate_Second = 0.05/365;
				}

			if(amount<=1000){
			partial_Interest = (amount * Math.pow((1+ int_Rate_First), period)) - amount; 
			return partial_Interest;
			}
				else if(amount>1000 && amount<=2000){
			partial_Interest = (amount * Math.pow((1+ int_Rate_First),period)) - 1000;
			second_Part_Interest = ((amount-1000) * Math.pow((1+ int_Rate_Second),period)) - (amount-1000);
			return partial_Interest + second_Part_Interest;
			}
			else if(amount>2000){
			partial_Interest = (amount * Math.pow((1+ int_Rate_First),period)) - 1000;
			second_Part_Interest = ((amount-1000) * Math.pow((1+ int_Rate_Second),period)) - (amount-1000);
			second_Part_Interest = ((amount-1000) * Math.pow((1+ int_Rate_Third),period)) - (amount-2000);
			return partial_Interest + second_Part_Interest + third_Part_Interest;
			}

            //case MAXI_SAVINGS:
              //  if (amount <= 1000)
                //    return amount * 0.02;
                //if (amount <= 2000)
                  //  return 20 + (amount-1000) * 0.05;
                //return 70 + (amount-2000) * 0.1;
            default:
                return amount * 0.001;
        }
    }

    public double sumTransactions() {
       return checkIfTransactionsExist(true);
    }

    private double checkIfTransactionsExist(boolean checkAll) {
        double amount = 0.0;
        for (Transaction t: this.getTransactions())
            amount += t.amount;
        return amount;
    }

    public int getAccountType() {
        return accountType;
    }

}
