import Services.Weather.*;

public class Prova {

	public static void main(String[] args){
		 
		WeatherForecast result = new WeatherForecast();
		
		WeatherForecastResult data = result.getForecast(45.52604572966644, 9.334258996024303);
		
		System.out.println(data.toWeatherTable());

	}

}
