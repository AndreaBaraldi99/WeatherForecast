package Services.API;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class API {
	
	public APIResult callAPI(String url) {
		try {
			URL urlCall = new URL(url);
			
			HttpURLConnection conn = (HttpURLConnection) urlCall.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			int responseCode = conn.getResponseCode();
			
			StringBuilder informationString = new StringBuilder();
			Scanner scanner = new Scanner(urlCall.openStream());
			
			while(scanner.hasNext()) {
				informationString.append(scanner.nextLine());
			}
			
			scanner.close();
			
			return new APIResult(responseCode, informationString.toString());		
		
		} catch (MalformedURLException e) {
			System.out.println("URL error");
		} catch (IOException e) {
			System.out.println("IO error");
		}
		return null;
		
	}
	
	
}
