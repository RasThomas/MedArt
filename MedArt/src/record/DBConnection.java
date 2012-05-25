package record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	

  public static Connection connect() {

	    Connection con = null;

	    try {
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
	        "root", "komputer");

	      if(!con.isClosed())
	        System.out.println("Successfully connected to MySQL server");

	    } catch(Exception e) {
	      System.err.println("Exception: " + e.getMessage());
	      e.printStackTrace();
	    } 
	return con;
  }
}