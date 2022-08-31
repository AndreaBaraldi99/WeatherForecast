package Services.Weather;

import Services.API.*;
import com.google.gson.Gson;


public class WeatherForecast {
	
	private String apiRoot = "https://api.open-meteo.com/v1/forecast?";
	private String forecastParams = "daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,windspeed_10m_max&timezone=auto";
	
	public WeatherForecastResult getForecast(double latitude, double longitude) {
		
		String url = apiRoot + forecastParams + "&latitude=" + latitude + "&longitude=" + longitude;
		
		//API call to weather service
		API api = new API();
		
		APIResult forecast = api.callAPI(url);
		if(forecast == null) {
			return null;
		}
		else if(forecast.getResponseCode()!=200) {
			System.out.println("Connection failed");
			return null;
		}
		
		//Convert result json to result object
		WeatherForecastResult forecastResult = new Gson().fromJson(forecast.getInformationString(), WeatherForecastResult.class);
		return forecastResult;
		
	}
}
