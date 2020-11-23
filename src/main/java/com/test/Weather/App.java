package com.test.Weather;


import java.io.FileReader;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class App {
	public static void main(String[] args) {

		try {

			Object obj = new JSONParser().parse(new FileReader("src/main/java/file.json"));

			// typecasting obj to JSONObject
			JSONObject jo = (JSONObject) obj;

			List<JSONObject> lst = (List<JSONObject>) jo.get("list");
			
			//Returning list of dates when it rained
			System.out.println("List of Dates rained:");
			for(int i=1;i<lst.size();i++)
			{ 
				  if(lst.get(i).get("rain") != null) 
				  {
			        System.out.println(lst.get(i).get("dt_txt")); 
			      } 
		    }

			for (JSONObject child : lst) {
				
				JSONObject man = (JSONObject) child.get("main");
				JSONArray array=(JSONArray) child.get("weather");
				
				//for a given date returning temp_min,temp_max,humidity,main under weather
				System.out.println("For a given date temp_min,temp_max,humidity,main under weather are:");

				try {
					Double tempmin = (Double) man.get("temp_min");
					System.out.println("temp_min " + tempmin);

				} catch (Exception e) {
					Long tempmin = (Long) man.get("temp_min");
					System.out.println("temp_min " + tempmin);

				}

				try {
					Double tempmax = (Double) man.get("temp_max");
					System.out.println("temp_max " + tempmax);

				} catch (Exception e) {
					Long tempmax = (Long) man.get("temp_max");
					System.out.println("temp_max " + tempmax);

				}
				
				try {
					Double humidity = (Double) man.get("humidity");
					System.out.println("humidity " + humidity);

				} catch (Exception e) {
					Long humidity = (Long) man.get("humidity");
					System.out.println("humidity " + humidity);

				}
				
				for(int i=0; i<array.size(); i++)  
                {
                JSONObject obj1 = (JSONObject) array.get(i); 
                String main = (String) obj1.get("main").toString();
                System.out.println("main under weather : "+main);
                }
				
			}

		   } 
		        catch (Exception e) {
			    e.printStackTrace();
		}

	}

}

