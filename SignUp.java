package BusProject;

import java.util.Scanner;
import java.util.regex.*;
import java.sql.*;

public class SignUp {

	public boolean RegisterNewUser() throws SQLException {
		boolean result=false;
	        Scanner scan = new Scanner(System.in); 
			System.out.println("Enter the UserName:");
			 String Name=scan.nextLine();
			 System.out.println("Enter the Email:");
			 String email=scan.nextLine();
			 System.out.println("Enter the password:");
			 String password=scan.nextLine();
			 System.out.println("Enter the confirmPassword:");
			 String ConfirmPassword=scan.nextLine();
			 
			 Pattern pattern=Pattern.compile(password);
			 Matcher matcher=pattern.matcher(ConfirmPassword);
			 
			 if(matcher.find()) {
				 System.out.println("The password Matches:");
			 }
			 else
			 {
				 System.out.println("The password incorrect:");
				 RegisterNewUser();
			 }
			 String query="insert into users values(?,?,?);";
			 Connection connect=DbConnection.getConnection();
			 PreparedStatement preparedstatement=connect.prepareStatement(query);
			 preparedstatement.setString(1,Name);
			 preparedstatement.setString(2,email);
			 preparedstatement.setString(3,password);
			 
			 int Rows_Affected= preparedstatement.executeUpdate();	
			 
			 if(Rows_Affected==1) {
				 System.out.println("The User Registered Sucessfully :)");
				 result=true;
			 }
			 else
			 {
				 System.out.println("Fail To Register the user... ");
			 }
			 
	    connect.close();
		
		
		return result;
}
}
		 
		 
	     
	     
	     
		
	




