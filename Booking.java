package BusProject;



import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class Booking {
	protected int BusNo;
	protected String Passanger_name;
	protected Date travel_date;
	protected int  vacany=0;
	Scanner scan=new Scanner(System.in);
	


	public boolean isAvailable(int BusNumber) throws SQLException {
		String query="select vacany from bus where BusNO = " +BusNumber;
		Connection connect=DbConnection.getConnection();
		Statement statement=connect.createStatement();
		ResultSet result=statement.executeQuery(query);
		if(result.next()) {
		    vacany=result.getInt(1);
		}
		
		return vacany>0?true:false;
		
	}
  public void ReduceVacancy(int vacancy,int BusNo) throws SQLException {
	    String query2="update Bus set vacany=? where BusNo=? ";
	     Connection connect=DbConnection.getConnection() ;
	     PreparedStatement prepareStatement=connect.prepareStatement(query2);
	  
		prepareStatement.setInt(1,vacany-1);
		prepareStatement.setInt(2, BusNo);
		
		int Row_Affected=prepareStatement.executeUpdate();
		if(Row_Affected==1) {
			System.out.println("The updates are changed :");
		}
		else
		{
			throw new Error("The error occured in updating area...");
		}
  }
	
	
	
	public void confirmBooking() throws SQLException {
		
		
		 System.out.println("Enter the BusNo :");
		BusNo=scan.nextInt();
		 System.out.println("Enter the passanger_Name");
		 Passanger_name=scan.next();
		 scan.nextLine();
		 System.out.println("Enter the date You need to Travel");
	     String dateInput=scan.nextLine();
	     SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
	     
	     try {
	    	 travel_date = dateFormat.parse(dateInput);
	     }
	     catch(Exception e) {
	    	 System.out.println(e);
	     }
	     String query1="insert into BusBooking values(?,?,?)";
	    
	     Connection connect=DbConnection.getConnection() ;
	     PreparedStatement prepareStatement=connect.prepareStatement(query1);
		prepareStatement.setInt(1, BusNo);
		prepareStatement.setString(2, Passanger_name);
		java.sql.Date date=new java.sql.Date(travel_date.getTime());
		prepareStatement.setDate(3, date);
		int rowsAffected=prepareStatement.executeUpdate();
	
		if(rowsAffected==1) {
//			System.out.println("The Data is Stored in the Database Successfully");
			ReduceVacancy(vacany-1,BusNo);
			
		}
		else
		{
			throw new Error("There was problem in the database connection:");
		}
		
		connect.close();
	}

	

}