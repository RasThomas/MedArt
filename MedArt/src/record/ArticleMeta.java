package record;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArticleMeta {
	public static ResultSet getGrade(int number) {
		System.out.println("Getting values from Mysql database table!");
		Connection con = null;
		String id = null;
		String id2 = null;
		ResultSet res = null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				res = st.executeQuery("SELECT * FROM ArticleMeta WHERE idArticle="+ number + " ");
				System.out.println("Comments:");
				while (res.next()) {
					id = res.getString("AverageGrade");
					System.out.println(id);
					id2 = res.getString("NumberOfUsers");
					System.out.println(id2);
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

	public static void insertMeta(int idSearchTerms, int idArticle, double averageGrade, int numberofUsers) {
		System.out.println("Inserting values in Mysql database table!");
		Connection con = null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				int val = st.executeUpdate("INSERT INTO `mydb`.`ArticleMeta` (idSearchTerms, idArticle, AverageGrade, NumberOfUsers) VALUES ('" +  idSearchTerms + "','" + idArticle + "','" + averageGrade + "','" + numberofUsers + "')");
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
		insertMeta(1,2,9,3);
		System.out.println(getGrade(1));
		System.out.println(getGrade(2));
	}
}
