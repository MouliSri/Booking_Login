package BusProject;

import java.sql.*;

public class BusInformation {
	
	public void display() throws SQLException {
		String query="select * from bus";
		Connection connect=DbConnection.getConnection();
		Statement statement=connect.createStatement();
		 ResultSet result=statement.executeQuery(query);
		
		
		System.out.println("The Bus Details :");
		System.out.println();
		System.out.println();
		
		while(result.next()) {
			System.out.println("The Bus Number is : " + result.getInt(1));
			System.out.println("The Bus Name is : " + result.getString(2));
			if(result.getInt(3)==1) {
				System.out.println("The Bus type is : AC");
			}
			else
			{
				System.out.println("The Bus type is : Non-AC");
			}
			System.out.println("The Vacany Available is :" +result.getInt(4));
			System.out.println("----------------------------");
			
			
		}
		connect.close();
	}
	
	

}