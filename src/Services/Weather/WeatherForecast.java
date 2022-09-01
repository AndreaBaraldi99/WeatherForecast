package Services.Weather;

import Services.API.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class WeatherForecast {
	
	private String apiRootWeather = "https://api.open-meteo.com/v1/forecast?";
	private String forecastParams = "daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,windspeed_10m_max&timezone=auto";
	private String apiRootLocation = "http://api.positionstack.com/v1/forward?limit=1&access_key=d77ed0d76be5d6b096a219da1e7d8767";
	
	public WeatherForecastResult getForecast(double latitude, double longitude) {
		
		String url = apiRootWeather + forecastParams + "&latitude=" + latitude + "&longitude=" + longitude;
		
		//API call to weather service
		APIResult forecastString = new API().callAPI(url);
		if(forecastString == null) {
			return null;
		}
		else if(forecastString.getResponseCode()!=200) {
			System.out.println("Connection failed");
			return null;
		}
		
		//Convert result json to result object
		WeatherForecastResult forecastResult = new Gson().fromJson(forecastString.getInformationString(), WeatherForecastResult.class);
		return forecastResult;
		
	}
	
	public WeatherForecastResult getForecast(String city) {
		
		String url = apiRootLocation + "&query=" + city;
		
		APIResult locationString = new API().callAPI(url);
		if(locationString== null) {
			return null;
		}
		else if(locationString.getResponseCode()!=200) {
			System.out.println("Connection failed");
			return null;
		}
		
		Data location = new Gson().fromJson(locationString.getInformationString(), Data.class);
		
		return getForecast(location.data.get(0).latitude, location.data.get(0).longitude);
	    	
	    
	}
}
