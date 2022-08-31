package Services.API;

public class APIResult {
	
	private String informationString;
	private int responseCode;
	
	protected APIResult(int responseCode, String informationString) {
		this.responseCode = responseCode;
		this.informationString = informationString;
	}
	
	protected APIResult() {}

	public String getInformationString() {
		return informationString;
	}

	public int getResponseCode() {
		return responseCode;
	}
	
}
