package bankManagement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import bankManagement.Customer;
public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Customer c1 = new Customer("meetmaniar","Meet","Maniar","meetrmaniar@gmail.com","xyzxyz","514514514514",22);
		c1.createAccount("meetmeetmeet");
		c1.login("meetmaniar", "meetmeetmeet");
		
		c1.logout();
		
		Bank b1 = new Bank("BMO");
		b1.addCustomer(c1,"acc121");
		
		
	}

}
