package data;
import com.csvreader.*;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



public class Util {
	
	public static ArrayList<InfoCardio> readExcel(String file){
		ArrayList<InfoCardio> ret = new ArrayList<InfoCardio>();
		CsvReader reader = null;
		int i = 0;
		
		try {
			reader = new CsvReader(file, ';');
		} catch(FileNotFoundException e){
			System.err.println(e);
		}
		
		
		try{
			InfoCardio record;
			reader.readRecord();
			while(reader.readRecord()){
				record = new InfoCardio();
				record.setId(reader.get(0));
				record.setCountrycode(reader.get(1));
				record.setDate(reader.get(2));
				record.setUnexpextedSAE(reader.get(3));
				record.setUade(reader.get(4));
				record.setSAEdiagnosis(reader.get(5));
				record.setEvent(reader.get(6));
				record.setReportType(reader.get(7));
				record.setSiteNotifiedDate(reader.get(9));
				record.setFUReport(reader.get(8));
				record.setRelationDev(reader.get(10));
				record.setRelationDrug(reader.get(11));
				record.setOutcome(reader.get(12));
				record.setResolvedDate(reader.get(13));
				ret.add(record);
				System.out.println(record.toString());
				i++;
			}
		} catch(IOException ex){
			ex.printStackTrace();
		}
		System.out.println("\nTotal: "+i +" patients");
		reader.close();
			
	return ret;
	}
	
}
