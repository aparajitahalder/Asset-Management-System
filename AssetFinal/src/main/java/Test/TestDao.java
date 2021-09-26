package Test;

import java.time.LocalDate;
import java.util.List;

import beans.Borrower;
import beans.User;
import Exceptions.AssetNotFoundException;
import Exceptions.BorrowerNotFoundException;
import Exceptions.EmailAlreadyExistsException;
import Exceptions.UserNotFoundException;
import service.BorrowInterface;
import service.BorrowInterfaceImpl;
import service.UserInterface;
import service.UserInterfaceImpl;

public class TestDao {

	public static void main(String[] args) {
		// Lets first Check User Dao
		UserInterface Userservice=new UserInterfaceImpl();
		User u=new User(3,"shalini","user","9789899987","shalinijha219999@gmail.com","67637");
		// if status=1 successful registeration if status=0 unsucessful registeration
		
		// check Registeration
//		User u=new User("shalini","user","9789899987","shalinijha219999@gmail.com","67637");
//	    try {
//			int status =Userservice.RegisterUser(u);
//			System.out.println(status); 
//		} catch (EmailAlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    
	    // check login 
	    
//	    try {
//			Userservice.LoginUser("b@c.com", "12345");
//		} catch (EmailAlreadyExistsException | UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BorrowInterface borrowservice=new BorrowInterfaceImpl();
		
		
		try {
			List<Borrower>list=borrowservice.getAllborrowers();
			System.out.println(list);
		} catch (BorrowerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		try {
//			Borrower b=borrowservice.getBorrowerById(1);
//			System.out.println(b);
//		} catch (BorrowerNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//		try {
//			List<Borrower> b=borrowservice.getBorowerByName("shalini");
//			System.out.println(b);
//		} catch (BorrowerNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			List<Borrower> b=borrowservice.getBorowerByDate(LocalDate.parse("2021-09-01"));
//			System.out.println(b);
//		} catch (BorrowerNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
		// System.out.println(borrowservice.sendMessage(1, "hey there "));
		
//		try {
//			borrowservice.issueAsset(u, "Laptop");
//		} catch (AssetNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//borrowservice.returnAsset(3, 1);

		
		
	    
	}

}
