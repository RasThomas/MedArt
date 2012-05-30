package data;
import com.csvreader.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import record.DBConnection;



public class Util {
	
	public static void readExcel(String file){
		CsvReader reader = null;
		
		try {
			reader = new CsvReader(file, ';');
		} catch(FileNotFoundException e){
			System.err.println(e);
		}
		
		
		try{
			InfoCardio record;
			reader.readRecord();
			while(reader.readRecord()){
				Connection con = null;
				try{
					con = DBConnection.connect();
					System.out.println("Connected!");
					try{
						Statement st = con.createStatement();
						int val = st.executeUpdate("INSERT INTO `mydb`.`Patient` (`idPatient`, `countryCode`, `date`, `unexpectedSAE`, `uade`, `SAEdiagnosis`, `event`, `reportType`, `siteNotifiedDate`, `FUReport`, `relationDev`, `relationDrug`, `outcome`, `resolvedDate`) VALUES ('" + reader.get(0) + "','" + reader.get(1) + "','" + reader.get(2) + "','" + reader.get(3) + "','" + reader.get(4) + "','" + reader.get(5) + "','" + reader.get(6) + "','" + reader.get(7) + "','" + reader.get(9) + "','" + reader.get(8) + "','" + reader.get(10) + "','" + reader.get(11) + "','" + reader.get(12) + "','" + reader.get(13) +"')");
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
		} catch(IOException ex){
			ex.printStackTrace();
		}
		reader.close();
			
	}
	
	public static void main (String[] args){
		readExcel("data.csv");
	}
	
}
