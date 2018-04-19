package controller;

public class Account {
public static String accountNo;
public static String accountHolderName;
public static double minBal;
public static double currentBal;
public static double interestRate;

public Account(String accountNo, String accountHolderName, double minBal, double currentBal, double interestRate) {
	super();
	this.accountNo = accountNo;
	this.accountHolderName = accountHolderName;
	this.minBal = minBal;
	this.currentBal = currentBal;
	this.interestRate = interestRate;
}

void displayAccount(){
	
	System.out.println(accountNo+" "+accountHolderName+" "+minBal+" "+currentBal+" "+interestRate);
}
}
