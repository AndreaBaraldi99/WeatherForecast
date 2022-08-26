import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.*;

import Exceptions.ConnectionException;

public class Prova {

	public static void main(String[] args) throws IOException {
		 
		try {
			URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			int responseCode = conn.getResponseCode();
			if(responseCode != 200) {
				throw new ConnectionException("Connessione fallita");
			}
			
			StringBuilder informationString = new StringBuilder();
			Scanner scanner = new Scanner(url.openStream());
			
			while(scanner.hasNext()) {
				informationString.append(scanner.nextLine());
			}
			
			scanner.close();
			
			System.out.println(informationString);
			JsonObject json = new JsonObject();
			json = JsonParser.parseString(informationString.toString()).getAsJsonObject();
			JsonElement element = json.get("latitude");
			System.out.println(element.getAsString());
			
			
		}
		catch(ConnectionException r) {
			System.out.println("Connessione fallita");
		}
		

	}

}
