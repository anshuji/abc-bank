package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public void setCustomers(List<Customer> customerList){
        this.customers=customerList;
    }
    
    public List<Customer> getCustomerList(){
        this.customers;
    }
    
    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public String customerSummary(Bank bank) {
        String summary = "Customer Summary";
        Customer customers = bank.getCustomerList();
        for (Customer c : customers)
            summary += "\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")";
        return summary;
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid(Bank bank) {
        double total = 0;
        Customer customers = bank.getCustomerList();

        for(Customer c: customers)
            total += c.totalInterestEarned();
        return total;
    }

    public String getFirstCustomer() {
        try {
            if(customers !=null & customers.get(0)!=null){
            //customers = null;
            return customers.get(0).getName();
            }
        return null;
        } catch (Exception e){
            // or we can throw the same to the calling method
            e.printStackTrace();
            return "Error";
        }
    }
}
