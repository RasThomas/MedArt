package data;

public class InfoCardio {
	
	private String id;
	private String countrycode;
	private String date;
	private String unexpextedSAE;
	private String uade;
	private String SAEdiagnosis;
	private String event;
	private String reportType;
	private String siteNotifiedDate;
	private String FUReport;
	private String relationDev;
	private String relationDrug;
	private String outcome;
	private String resolvedDate;
	
	public InfoCardio(){
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUnexpextedSAE() {
		return unexpextedSAE;
	}

	public void setUnexpextedSAE(String unexpextedSAE) {
		this.unexpextedSAE = unexpextedSAE;
	}

	public String getUade() {
		return uade;
	}

	public void setUade(String uade) {
		this.uade = uade;
	}

	public String getSAEdiagnosis() {
		return SAEdiagnosis;
	}

	public void setSAEdiagnosis(String sAEdiagnosis) {
		SAEdiagnosis = sAEdiagnosis;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getSiteNotifiedDate() {
		return siteNotifiedDate;
	}

	public void setSiteNotifiedDate(String siteNotifiedDate) {
		this.siteNotifiedDate = siteNotifiedDate;
	}

	public String getFUReport() {
		return FUReport;
	}

	public void setFUReport(String fUReport) {
		FUReport = fUReport;
	}

	public String getRelationDev() {
		return relationDev;
	}

	public void setRelationDev(String relationDev) {
		this.relationDev = relationDev;
	}

	public String getRelationDrug() {
		return relationDrug;
	}

	public void setRelationDrug(String relationDrug) {
		this.relationDrug = relationDrug;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	
	public String toString(){
		String ret;
		ret = "\n\nPatient: " +id;
		ret += "\nCountry: " + countrycode;
		ret += "\nDate: " + date;
		ret += "\nSAE: " + unexpextedSAE;
		ret += "\nUADE: " + uade;
		ret += "\nSAE diagnosis: " + SAEdiagnosis;
		ret += "\nEvent: " + event;
		ret += "\nReport: " + reportType;
		ret += "\nNotified date: " + siteNotifiedDate;
		ret += "\nFU: " + FUReport;
		ret += "\nRelation device: " + relationDev;
		ret += "\nRelation Drug: " + relationDrug;
		ret += "\nOutcome: " + outcome;
		ret += "\nResolved date: " + resolvedDate;
		return ret;
	}


}
