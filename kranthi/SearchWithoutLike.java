package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchWithoutLike {

	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		//Step 2
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","M1racle@123");
		//Step 3
		Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String firstName, lastName, username;
		System.out.println("Enter first, last and username");
		firstName = scan.nextLine();
		lastName = scan.nextLine();
		username = scan.nextLine();
		// Step 4
		String selectQuery = "SELECT * FROM EMPLOYEE";
		ResultSet rs = s.executeQuery(selectQuery);
		while(rs.next()) {
			String firstNam = rs.getString("FIRSTNAME");
			String lastNam = rs.getString("LASTNAME");
			String usernam = rs.getString("USERNAME");
			if(firstNam.contains(firstName) && lastNam.contains(lastName)&&usernam.contains(username)) {
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+" ");
				System.out.print(rs.getLong(4)+" ");
				System.out.print(rs.getString(5)+" ");
				System.out.print(rs.getString(6)+" ");
				System.out.print(rs.getString(7)+" ");
				System.out.print(rs.getString(8)+" ");
				System.out.println();
			}
			
		}
	
		// Step 5
		s.close();
		scan.close();
		con.close();
	}

}


