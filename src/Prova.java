import java.util.Scanner;

import Services.Weather.*;

public class Prova {

	public static void main(String[] args){
		double latitude = 45.473702;
		double longitude = 9.170685;
		System.out.println("Inserire la città");
		Scanner tastiera = new Scanner(System.in);
		String citta = tastiera.nextLine();
		tastiera.close();
		WeatherForecastResult data = new WeatherForecast().getForecast(citta);
		//System.out.println(data.latitude + data.longitude);
		//System.out.println(data.toWeatherTable());

	}

}
