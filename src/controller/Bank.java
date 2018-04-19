package controller;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import controller.Account;
import controller.Customer;

public class Bank {
	public String bankName;
	public String customerLoginDetails;
	public double loan;
	public float creditScore;
	
	public Bank(String bankName) {
		
		this.bankName = bankName;
		
		
	}
	
	public void addCustomer(Customer obj, String accountNumber) throws FileNotFoundException, UnsupportedEncodingException{
		String accountNo = accountNumber;
		PrintWriter writer = new PrintWriter("database.txt", "UTF-8");
		Customer.bankApproval=true;
		
		writer.println(Customer.username+" "+Customer.password+" "+Customer.firstName+" "+Customer.lastName+" "+Customer.email+" "+Customer.address+" "+Customer.mobilenumber+" "+Customer.age+" "+Customer.bankApproval+" "+accountNumber);
		writer.close();
		
		System.out.println("Customer Added");
	}
	
}
