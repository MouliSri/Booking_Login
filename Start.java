package BusProject;

import java.sql.SQLException;
import java.util.*;
//import java.util.regex.Pattern;
//import java.util.regex.Matcher;

public class Start {
	

	public static void main(String args[]){
		
		int option=1;
		
		try {
			Scanner scan=new Scanner(System.in);

			while(option==1) {
				System.out.println("Enter 1 to Login Page or Enter 2 to Signup Page");
				option=scan.nextInt();
			  
			if(option==1) {
			Login login=new Login();
			boolean userlogin=login.loginTheUser();
			   if(userlogin) {
				option=3;
			    }
			   else
			   {
				 option=1;
			   }
			}
			else if(option==2) {
			SignUp signup=new SignUp();
			boolean registered=signup.RegisterNewUser();
			   if(registered) {
				   System.out.println("-----------------------------------");
				   System.out.println("The login page:");
				   Login login=new Login();
				   login.loginTheUser();
			  }
			  else {
				System.out.println("There was as an error while registering the user:");
			  }
			  option=1;
			}
			else
			{
				System.err.println("Input is Incorrect...try again");
		 	}
		  }
		
		
	
		
	}
		catch(Exception e) {
			System.out.println(e);
		}

	}
}
