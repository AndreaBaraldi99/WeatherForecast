package Services.Weather;

import com.google.gson.*;


public class WeatherForecastResult{
	public double latitude;
    public double longitude;
    public double generationtime_ms;
    public int utc_offset_seconds;
    public String timezone;
    public String timezone_abbreviation;
    public double elevation;
    public DailyUnits daily_units;
    public Daily daily;
    
    public String toPrettyJson() {
    	
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	return gson.toJson(this);
    	
    }
    
    public String toWeatherTable() {
    	String leftAlignFormat = "| %-10s | %-8s | %-8s | %-6s | %-7s | %-7s | %-8s | %-5s |\n";
    	String table = "";
    	table+=("+------------+----------+----------+--------+---------+---------+----------+-------+\n");
    	table+=("| Date       | Max temp | Min Temp | Sunset | Sunrise | Rain mm | Wind spd | Wc    |\n");
    	table+=("+------------+----------+----------+--------+---------+---------+----------+-------+\n");
    	for(int i = 0; i<daily.time.size(); i++) {
    		String row = String.format(leftAlignFormat, daily.time.get(i), daily.temperature_2m_max.get(i), daily.temperature_2m_min.get(i), 
    				daily.sunset.get(i).substring(daily.sunset.get(i).indexOf("T")+1), daily.sunrise.get(i).substring(daily.sunset.get(i).indexOf("T")+1),
    				daily.precipitation_sum.get(i), daily.windspeed_10m_max.get(i), daily.weathercode.get(i));
    		table += row;
    	}
    	table+=("+------------+----------+----------+--------+---------+---------+----------+-------+\n");
    	
    	return table;
    	
    	
    }
    
}