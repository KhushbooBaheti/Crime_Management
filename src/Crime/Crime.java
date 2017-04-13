package Crime;

public class Crime {
	protected int cid;
	protected String crimeType;
	protected int noOfCases;
	protected int solvedCases;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCrimeType() {
		return crimeType;
	}
	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}
	public int getNoOfCases() {
		return noOfCases;
	}
	public void setNoOfCases(int noOfCases) {
		this.noOfCases = noOfCases;
	}
	public int getSolvedCases() {
		return solvedCases;
	}
	public void setSolvedCases(int solvedCases) {
		this.solvedCases = solvedCases;
	}
		
}
