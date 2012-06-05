	package record;

import java.sql.*;

import javax.swing.JApplet;

public class SearchTerms extends JApplet {
	public static ResultSet getTerms() {
		System.out.println("Getting values from Mysql database table!");
		Connection con = null;
		ResultSet res = null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				res = st.executeQuery("SELECT Term FROM SearchTerms");
				System.out.println("Search Terms:");
				while (res.next()) {
					String s = res.getString("Term");
					System.out.println(s);
				}
			}finally {
				try {
					if(con != null)
						con.close();
					System.out.println("Disconnected from database.");
				} catch(SQLException e) {}
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return res;
	}

	public static void insertTerms(String SearchTerm) {
		System.out.println("Inserting values in Mysql database table!");
		Connection con = null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				int val = st.executeUpdate("INSERT INTO `mydb`.`SearchTerms` (`Term`) VALUES ('" + SearchTerm +"')");
				System.out.println("1 row affected");
			}
			catch (SQLException s){
				System.out.println("SQL statement is not executed!");
				s.printStackTrace();
			}finally {
				try {
					if(con != null)
						con.close();
					System.out.println("Disconnected from database.");
				} catch(SQLException e) {}
			}
		}
		catch (Exception e){
			e.printStackTrace();
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		insertTerms("Chest Pain 3");
		getTerms();
	}
}

