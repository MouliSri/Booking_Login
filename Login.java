package BusProject;
import java.sql.*;
import java.util.Scanner;

public class Login {

	public boolean loginTheUser() throws SQLException {
		boolean attempt=false;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the UserName:");
		String UserName=scan.nextLine();
		System.out.println("Enter the Password:");
		String Password=scan.nextLine();
	
		String query="select userName,password from users where userName=? and password=?";
		
		Connection connect=DbConnection.getConnection();
		PreparedStatement preparedstatement=connect.prepareStatement(query);
		preparedstatement.setString(1,UserName);
		preparedstatement.setString(2,Password);
		ResultSet result=preparedstatement.executeQuery();
		
		
		if(result.next())
		{
			System.out.println("The User Logined Successfully");
			BusDemo.Bus();
			attempt=true;
		}
		else
		{
			System.out.println(" Incorrect userName and password ");
		}
		
		connect.close();
		
		return attempt;
	}

	
		
		
	}


