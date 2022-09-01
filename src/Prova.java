import java.util.Scanner;
import Services.Weather.*;

public class Prova {

	public static void main(String[] args){
		System.out.println("Inserire la città");
		Scanner tastiera = new Scanner(System.in);
		String citta = tastiera.nextLine();
		tastiera.close();
		WeatherForecastResult data = new WeatherForecast().getForecast(citta);
		
		System.out.println(data.toWeatherTable());
		
	}

}
