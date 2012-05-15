package data;
import com.csvreader.CsvReader;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class Util {
	
	public ArrayList readExcel(String file){
		ArrayList ret = new ArrayList();
		CsvReader reader = null;
		
		try {
			reader = new CsvReader(file, ';');
		} catch(FileNotFoundException e){
			System.err.println(e);
		}
		
		try{
			reader.readHeaders();
		} catch(IOException ex){
			ex.printStackTrace();
		}
		
		try{
			InfoCardio record;
			while(reader.readRecord()){
				record = new InfoCardio();
				record.setId(reader.get("Pat Id"));
				record.setCountrycode(reader.get("Country Code"));
				record.setDate(reader.get("SAE Date"));
				record.setUnexpextedSAE(reader.get("Unexpected SAE"));
				record.setUade(reader.get("UADE"));
				record.setSAEdiagnosis(reader.get("SAE Diagnosis"));
				record.setEvent(reader.get("Event Number"));
				record.setReportType(reader.get("Report Type"));
				record.setSiteNotifiedDate(reader.get("Site Notified Date"));
				record.setFUReport(reader.get("FU Report"));
				record.setRelationDev(reader.get("Relation Device"));
				record.setRelationDrug(reader.get("Relation Drug"));
				record.setOutcome(reader.get("Outcome"));
				record.setResolvedDate(reader.get("Resolved Date"));
			}
		} catch(IOException ex){
			ex.printStackTrace();
		}
		reader.close();
			
	return ret;
	}
	
}
