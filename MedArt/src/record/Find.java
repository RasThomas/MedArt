package record;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.InfoCardio;

public class Find {
	
	private static InfoCardio setData(ResultSet rs) throws SQLException{
		InfoCardio patient = new InfoCardio();
		patient.setId(rs.getString("idPatient"));
		patient.setCountrycode(rs.getString("countryCode"));
		patient.setDate(rs.getString("date"));
		patient.setUnexpextedSAE(rs.getString("unexpectedSAE"));
		patient.setUade(rs.getString("uade"));
		patient.setSAEdiagnosis(rs.getString("SAEdiagnosis"));
		patient.setEvent(rs.getString("event"));
		patient.setReportType(rs.getString("reportType"));
		patient.setSiteNotifiedDate(rs.getString("siteNotifiedDate"));
		patient.setFUReport(rs.getString("FUReport"));
		patient.setRelationDev(rs.getString("relationDev"));
		patient.setRelationDrug(rs.getString("relationDrug"));
		patient.setOutcome(rs.getString("outcome"));
		patient.setResolvedDate(rs.getString("resolvedDate"));
		return patient;
	}
	
	public static ResultSet FindPatient(String idPatient){
		ResultSet ret = null;
		Connection con = null;
		InfoCardio patient=null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				ret = st.executeQuery("SELECT * FROM Patient WHERE idPatient="+ idPatient + " ORDER BY date;");
				System.out.println("Patient");
				while (ret.next()) {
					patient = setData(ret);
					System.out.println(patient.toString()+"\n");
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
		return ret;
	}
	
	
	
	
	public static ResultSet FindEffect(String effect){
		ResultSet ret = null;
		Connection con = null;
		InfoCardio patient=null;
		try{
			con = DBConnection.connect();
			System.out.println("Connected!");
			try{
				Statement st = con.createStatement();
				ret = st.executeQuery("SELECT * FROM Patient WHERE SAEdiagnosis=\""+ effect +"\"");
				System.out.println("Patient");
				while (ret.next()) {
					patient = setData(ret);
					System.out.println(patient.toString()+"\n");
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
		return ret;
	}
	
	public static void main(String args[]) {
		//FindEffect("chest pain");
		FindPatient("1");
	}
}
