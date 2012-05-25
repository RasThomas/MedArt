package record;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Article {
	public static String matchArticleNumber(int number) {
		System.out.println("Getting values from Mysql database table!");
		Connection con = null;
		String id = null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("SELECT * FROM Article WHERE ArticleNumber="+ number + " ");
				System.out.println("Articleid:");
				while (res.next()) {
					id = res.getString("idArticle");
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
		return id;
	}

	public static void insertArticle(int ArticlenNumber) {
		System.out.println("Inserting values in Mysql database table!");
		Connection con = null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				int val = st.executeUpdate("INSERT INTO `mydb`.`Article` (`ArticleNumber`) VALUES ('" + ArticlenNumber +"')");
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
		insertArticle(108);
		System.out.println(matchArticleNumber(103));
		System.out.println(matchArticleNumber(104));
	}
	

}
