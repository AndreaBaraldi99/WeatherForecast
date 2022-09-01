package Services.Weather;
import java.util.ArrayList;

public class Daily{
    public ArrayList<String> time;
    public ArrayList<Double> temperature_2m_max;
    public ArrayList<Double> temperature_2m_min;
    public ArrayList<String> sunrise;
    public ArrayList<String> sunset;
    public ArrayList<Double> precipitation_sum;
    public ArrayList<Double> windspeed_10m_max;
    public ArrayList<Integer> weathercode;
    
    public String[] getWeather() {
    	int k = 0;
    	String[] weather = new String[weathercode.size()];
    	for(Integer i: weathercode) {
    		switch(i) {
    			case 0:
    				weather[k]="Clear Sky";
    				break;
    			case 1:
    				weather[k]="Mainly clear";
    				break;
    			case 2:
    				weather[k]="Partly cloudy";
    				break;
    			case 3:
    				weather[k]="Overcast";
    				break;
    			case 45:
    				weather[k]="Fog";
    				break;
    			case 48:
    				weather[k]="Depositing rime fog";
    				break;
    			case 51:
    				weather[k]="Light drizzle";
    				break;
    			case 53:
    				weather[k]="Moderate drizzle";
    				break;
    			case 55:
    				weather[k]="Dense drizzle";
    				break;
    			case 56:
    				weather[k]="Light freezing drizzle";
    				break;
    			case 57:
    				weather[k]="Dense freezing drizzle";
    				break;
    			case 61:
    				weather[k]="Slight rain";
    				break;
    			case 63:
    				weather[k]="Moderate rain";
    				break;
    			case 65:
    				weather[k]="Heavy rain";
    				break;
    			case 66:
    				weather[k]="Light freezing rain";
    				break;
    			case 67:
    				weather[k]="Heavy freezing rain";
    				break;
    			case 71:
    				weather[k]="Slight snow fall";
    				break;
    			case 73:
    				weather[k]="Moderate snow fall";
    				break;
    			case 75:
    				weather[k]="Heavy snow fall";
    				break;
    			case 77:
    				weather[k]="Snow grains";
    				break;
    			case 80:
    				weather[k]="Slight rain showers";
    				break;
    			case 81:
    				weather[k]="Moderate rain showers";
    				break;
    			case 82:
    				weather[k]="Violent rain showers";
    				break;
    			case 85:
    				weather[k]="Slight snow showers";
    				break;
    			case 86:
    				weather[k]="Heavy snow showers";
    				break;
    			case 95:
    				weather[k]="Thunderstorm";
    				break;
    			case 96:
    				weather[k]="Thunderstorm with slight hail";
    				break;
    			case 99:
    				weather[k]="Thunderstorm with heavy hail";
    				break;
    			default:
    				weather[k]="No data";
    				break;
    		}
    		k++;
    	}
    	return weather;
    }
    
}