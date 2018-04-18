package bankManagement;

import bankManagement.Account;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.*;

public class Customer {
	public static String username;
	public static String firstName;
	public static String lastName;
	public static String email;
	public static String address;
	public static String mobilenumber;
	public static int age = 0;
	protected static String password;
	
	
	
	public boolean loginFlag=false;
	public static boolean bankApproval=false; 
	
	
	public Customer(String username, String firstName, String lastName, String email, String address,
			String mobilenumber, int age) {
		Account A = new Account("000", username, 000, 100,10);
		A.displayAccount();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.mobilenumber = mobilenumber;
		this.age = age;
	}
	
	public void createAccount(String pwd) throws FileNotFoundException, UnsupportedEncodingException{
		password=pwd;
		PrintWriter writer = new PrintWriter("database.txt", "UTF-8");
		writer.println(username+" "+password+" "+firstName+" "+lastName+" "+email+" "+address+" "+mobilenumber+" "+age+" "+bankApproval);
		writer.close();
		System.out.println("Account Created");
	}
	
	public void login(String uName, String pwd) throws IOException{
		 FileInputStream fstream = new FileInputStream("database.txt");				//Reading File
         DataInputStream in = new DataInputStream(fstream);							//Converting it to data stream
         BufferedReader br = new BufferedReader(new InputStreamReader(in));			//Storing the content into buffer
         String strLine;
         
         while ((strLine = br.readLine()) != null) /* While there are content in the file */   {
        	 String[] tokens = strLine.split(" ");
        	 //System.out.println(tokens[0] + tokens[1]);  	
  		if(uName.equals(tokens[0])&&pwd.equals(tokens[1])){

  			System.out.println("Login Success");
  			
  			long yourmilliseconds = System.currentTimeMillis();
  			SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
  			Date resultdate = new Date(yourmilliseconds);
  			System.out.println(sdf.format(resultdate));
  			
  			PrintWriter writer = new PrintWriter("login.txt", "UTF-8");
  			writer.println("Username: "+uName + " " + "Login time:" + sdf.format(resultdate));
  			writer.close();
  			
  			
  			loginFlag=true;
  			break;
  		}
  		else{
  			System.out.println("Wrong Username or Wrong password");
  			System.out.println("System.currentTimeMillis()");
  			
  			loginFlag=false;
  		}
  			
  		}
	}
	public void logout() throws FileNotFoundException, UnsupportedEncodingException{
		System.out.println("Logout Success");
		loginFlag=false;
		long yourmilliseconds = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
			Date resultdate = new Date(yourmilliseconds);
			System.out.println(sdf.format(resultdate));
		PrintWriter writer = new PrintWriter("logout.txt", "UTF-8");
			writer.println("Username: "+username + " " + "Logout time:" + sdf.format(resultdate));
			writer.close();
	}
	
	public float getCreditScore(){
		float creditScore = 0;
		
		return creditScore;
	}
}