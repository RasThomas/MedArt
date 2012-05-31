package record;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Comments {
	public static ResultSet getComments(int number) {
		System.out.println("Getting values from Mysql database table!");
		Connection con = null;
		String id = null;
		ResultSet res = null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				res = st.executeQuery("SELECT * FROM Comments WHERE idArticleMeta="+ number + " ");
				System.out.println("Comments:");
				while (res.next()) {
					id = res.getString("Comment");
					System.out.println(id);
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

	public static void insertArticle(int ArticlenNumber, String Comment) {
		System.out.println("Inserting values in Mysql database table!");
		Connection con = null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				int val = st.executeUpdate("INSERT INTO mydb.Comments (Comment,idArticleMeta) VALUES ('" + Comment + "','" + ArticlenNumber +"')");
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
		insertArticle(1, "Nice, yes?");
//		insertArticle(1, "Very nice!");
//		System.out.println(getComments(1));
//		System.out.println(getComments(104));
	}
}
