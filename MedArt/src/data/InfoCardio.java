package data;

public class InfoCardio {
	private int id;
	private int countrycode;
	private String date;
	private int unexpextedSAE;
	private int uade;
	private String SAEdiagnosis;
	private int event;
	private int reportType;
	private String siteNotifiedDate;
	private String FUReport;
	private int relationDev;
	private int relationDrug;
	private int outcome;
	private String resolvedDate;
	
	public InfoCardio(){
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUnexpextedSAE() {
		return unexpextedSAE;
	}
	public void setUnexpextedSAE(int unexpextedSAE) {
		this.unexpextedSAE = unexpextedSAE;
	}
	public int getUade() {
		return uade;
	}
	public void setUade(int uade) {
		this.uade = uade;
	}
	public String getSAEdiagnosis() {
		return SAEdiagnosis;
	}
	public void setSAEdiagnosis(String sAEdiagnosis) {
		SAEdiagnosis = sAEdiagnosis;
	}
	public int getEvent() {
		return event;
	}
	public void setEvent(int event) {
		this.event = event;
	}
	public int getReportType() {
		return reportType;
	}
	public void setReportType(int reportType) {
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
	public int getRelationDev() {
		return relationDev;
	}
	public void setRelationDev(int relationDev) {
		this.relationDev = relationDev;
	}
	public int getRelationDrug() {
		return relationDrug;
	}
	public void setRelationDrug(int relationDrug) {
		this.relationDrug = relationDrug;
	}
	public int getOutcome() {
		return outcome;
	}
	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}
	public String getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

}
