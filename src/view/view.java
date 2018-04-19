package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import controller.Account;
import controller.Bank;
import controller.Customer;

public class view {
	public view() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame=new JFrame("Bank Management");
				frame.setSize(500,400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				

				JPanel loginPanel = new JPanel();
				loginPanel.setLayout(null);
				
				
				JLabel userID = new JLabel("Enter Used ID:");
				userID.setBounds(100,100,100,100);
				loginPanel.add(userID);
				
				JTextArea id = new JTextArea();
				id.setBounds(200, 140, 100, 20);
				loginPanel.add(id);
				
				
				JLabel password= new JLabel("Enter Password:");
				password.setBounds(100,120,100,100);
				loginPanel.add(password);
				
				
				JTextArea pwd = new JTextArea();
				pwd.setBounds(200,160,100,20);
				loginPanel.add(pwd);
				
				JButton login =new JButton("Login");
				login.setPreferredSize(new Dimension(90, 90));
				login.setBounds(150, 200, 100, 50);
				
				JPanel displayPanel = new JPanel();
				displayPanel.setLayout(null);
				
				Customer c1=new Customer("vamsikrishnan", "vamsi", "krishnan", "xyz@abc.com", "xyz", "xyz", 24);
				try {
					c1.createAccount("abcdefg");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (UnsupportedEncodingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				JButton signup = new JButton("SignUp");
				signup.setPreferredSize(new Dimension(90,90));
				signup.setBounds(100, 270, 180, 50);
				loginPanel.add(signup);
				
				signup.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						loginPanel.setVisible(false);
						
						JPanel createAccount = new JPanel();
						createAccount.setLayout(null);
						frame.add(createAccount);
						
						JTextArea username= new JTextArea("Enter User Name");
						JTextArea firstname = new JTextArea("Enter First Name");
						JTextArea lastname = new JTextArea("Enter Last Name");
						JTextArea email = new JTextArea("Enter email");
						JTextArea address = new JTextArea("Enter Address");
						JTextArea mobile = new JTextArea("Enter Mobile Number");
						JTextArea age = new JTextArea("Enter Age");
						JTextArea password = new JTextArea("Password");
						
						
						username.setBounds(10,100,700,20);
						firstname.setBounds(10,140,700,20);
						lastname.setBounds(10,180,700,20);
						email.setBounds(10,220,700,20);
						address.setBounds(10,260,700,20);
						mobile.setBounds(10,300,700,20);
						age.setBounds(10,340,700,20);
						password.setBounds(10,500,700,20);
						
						createAccount.add(username);
						createAccount.add(firstname);
						createAccount.add(lastname);
						createAccount.add(email);
						createAccount.add(address);
						createAccount.add(mobile);
						createAccount.add(age);
						createAccount.add(password);
						
						JButton accountCreation = new JButton("Create Account");
						accountCreation.setPreferredSize(new Dimension(90,90));
						accountCreation.setBounds(300, 700, 180, 50);
						createAccount.add(accountCreation);
						
						
						
						accountCreation.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent e) {
								String userName = username.getText();
								String firstName=firstname.getText();
								String lastName=lastname.getText();
								String emailID=email.getText();
								String Address=address.getText();
								String cell=mobile.getText();
								String passWord = password.getText();
								int Age = 0;
								
								try {
								    Age = Integer.parseInt(age.getText());
								} catch (NumberFormatException wrongAge) {
								    JOptionPane.showMessageDialog(frame,"Enter integer in Age");
								    
								}
						
						Customer C=new Customer(userName,firstName,lastName,emailID,Address,cell,Age);
						try {
							C.createAccount(passWord);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						createAccount.setVisible(false);
						loginPanel.setVisible(true);
					}
					
				});
					
					
					}});
				
				JButton BankLogin = new JButton("System Login");
				BankLogin.setPreferredSize(new Dimension(90,90));
				BankLogin.setBounds(350, 270, 180, 50);
				loginPanel.add(BankLogin);
				BankLogin.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						loginPanel.setVisible(false);
						JPanel systemPanel = new JPanel();
						
						
						
						
						JTextArea adminID = new JTextArea("ID");
						JTextArea PwD = new JTextArea("Password");
						
						adminID.setBounds(100,10,100,20);
						PwD.setBounds(400,40,100,200);
						
						systemPanel.add(adminID);
						systemPanel.add(PwD);
						
						JButton systemLogin = new JButton("login");
						systemLogin.setBounds(40,40,100,100);
						systemPanel.add(systemLogin);
						systemLogin.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								if(adminID.getText().equals("admin") && PwD.getText().equals("admin")){
									JOptionPane.showMessageDialog(frame,"login success");
									System.out.println("Bank Logged In");
									systemPanel.setVisible(false);
									
									JPanel bankInfo = new JPanel();
									frame.add(bankInfo);
									
									JButton addCustomers = new JButton("Add Client");
									addCustomers.setPreferredSize(new Dimension(90,90));
									addCustomers.setBounds(100, 100, 100, 100);
									
									JTextArea assignAcc=new JTextArea("Assign Account Number");
									assignAcc.setBounds(50,100,100,20);
									
									bankInfo.add(addCustomers);
									bankInfo.add(assignAcc);
									
									addCustomers.addActionListener(new ActionListener(){

										@Override
										public void actionPerformed(ActionEvent arg0) {
											// TODO Auto-generated method stub
											Bank BMO=new Bank("Scotia Bank");
											
											try {
												BMO.addCustomer(c1, assignAcc.getText());
												bankInfo.setVisible(false);
												JOptionPane.showMessageDialog(frame, "Client Added");
												loginPanel.setVisible(true);
												
											} catch (FileNotFoundException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (UnsupportedEncodingException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
											
										}
										
									});
								}
								else{
									JOptionPane.showMessageDialog(frame,"login fail");
									System.out.println("Bank Logged In fail");
								}
							}
							
						});
						
						frame.add(systemPanel);
					}
				});
				
				login.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
							try{
								
								FileInputStream fstream = new FileInputStream("database.txt");				//Reading File
							
					         DataInputStream in = new DataInputStream(fstream);							//Converting it to data stream
					         BufferedReader br = new BufferedReader(new InputStreamReader(in));			//Storing the content into buffer
					         String strLine;
					         
					         while ((strLine = br.readLine()) != null) /* While there are content in the file */   {
					        	 String[] tokens = strLine.split(" ");
					        	 String uId = id.getText();
					        	 String PWD = pwd.getText();
					        	 System.out.println(uId+":"+tokens[0]+":"+PWD+":"+tokens[1]);
					        	 //System.out.println(tokens[0] + tokens[1]);  	
					  		if(uId.equals(tokens[0])&&PWD.equals(tokens[1])&&c1.bankApproval==true){
					  			
					  			c1.login(uId, PWD);
					  			JOptionPane.showMessageDialog(frame,"Login Success");
					  			loginPanel.setVisible(false);
					  			
					  			JPanel displayPanel = new JPanel();
								displayPanel.setLayout(null);
								frame.add(displayPanel);
								displayPanel.setVisible(false);
								JLabel accountNo = new JLabel("Account Number");
								accountNo.setBounds(100,100,100,100);
								accountNo.setVisible(false);
								JLabel accountNumber= new JLabel(Account.accountNo);
								accountNumber.setBounds(100,120,100,100);
								
								JLabel clientName = new JLabel("Client Name");
								clientName.setBounds(200,100,100,100);
								clientName.setVisible(false);
								JLabel accountHolderName= new JLabel(Account.accountHolderName);
								accountHolderName.setBounds(200,120,100,100);
								
								JLabel minBal = new JLabel("Minimum Balance");
								minBal.setBounds(300,100,100,100);
								JLabel accountMinBal= new JLabel(Double.toString(Account.minBal));
								accountMinBal.setBounds(300,120,100,100);
								
								JLabel Balance = new JLabel("Balance");
								Balance.setBounds(400,100,100,100);
								JLabel accountCurrentBal= new JLabel(Double.toString(Account.currentBal));
								accountCurrentBal.setBounds(400,120,100,100);
								
								JLabel interestRate = new JLabel("Interest");
								interestRate.setBounds(500,100,100,100);
								JLabel accountInterestRate= new JLabel(Double.toString(Account.interestRate));
								accountInterestRate.setBounds(500,120,100,100);
								
								JButton logout =new JButton("logout");
								logout.setPreferredSize(new Dimension(90, 90));
								logout.setBounds(10, 10, 100, 50);
								
								
								
								displayPanel.add(accountNumber);
								displayPanel.add(accountHolderName);
								displayPanel.add(accountMinBal);
								displayPanel.add(accountCurrentBal);
								displayPanel.add(accountInterestRate);
								displayPanel.add(accountNo);
								displayPanel.add(clientName);
								displayPanel.add(minBal);
								displayPanel.add(Balance);
								displayPanel.add(interestRate);
								displayPanel.add(logout);
								displayPanel.setVisible(true);
								
								logout.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
								
										try {
											c1.logout();
											displayPanel.setVisible(false);
											JOptionPane.showMessageDialog(frame,"Logged Out");
											loginPanel.setVisible(true);
											
										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (UnsupportedEncodingException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
								
					  		}});
							}
					  		else{
					  			JOptionPane.showMessageDialog(frame,
					  				    "Login Fail");
					  		}
						
					         }	
					
				}
							catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();

							}}});
				
								

				loginPanel.add(login);
				
				
				frame.add(loginPanel);
	}});
		
	
	}
}
