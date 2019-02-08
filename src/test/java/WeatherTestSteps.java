package test.java;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@SuppressWarnings("deprecation")
public class WeatherTestSteps {
	public String city;
	public String dayOfWeek;
	public String host="http://api.openweathermap.org";
	public String appID="24226490dc59fd5c97863e15fbd90a54";
	public String postHostURI ="data/2.5/forecast?q=";
	public String countryCode="AU";
	public String URL;
	public JSONObject resultJSON = null;
	public JSONArray jsonArray;
	JSONObject jObj;
	@Given("^I like to holiday in Sydney$")
	public void I_like_to_holiday_in_Sydney () throws Throwable {
		//This section sets up the property of MOzilla browser and opens the driver.
		city="Sydney";
		}

	@Given("^I only like to holiday on given Day$")
	public void I_only_like_to_holiday_on_Thursday() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dayOfWeek="2019-02-10 00:00:00";
	    
	}

	@When("^I look up the weather forecast$")
	public void I_look_up_the_weather_forecast() throws Throwable{
	    	// Write code here that turns the phrase above into concrete actions
			//api.openweathermap.org/data/2.5/forecast?q={{cityName}},{{countryCode}}&appid={{apiKey}}
			URL= host+"/"+postHostURI+city+","+countryCode+"&appid="+appID;
			System.out.println("URL is"+URL);
		   @SuppressWarnings("deprecation")
		   HttpClient httpClient = new DefaultHttpClient();
		    try {
		      HttpGet httpGetRequest = new HttpGet(URL);
		      // Execute HTTP request
		      HttpResponse httpResponse = httpClient.execute(httpGetRequest);
		      System.out.println("----------------------------------------");
		      System.out.println(httpResponse.getStatusLine());
		      System.out.println("----------------------------------------");
		      // Get hold of the response entity
		      if (httpResponse.getStatusLine().getStatusCode() != 200) 
					throw new IllegalStateException("Error recieved:"+httpResponse.getStatusLine().getStatusCode());
		      final HttpEntity entity = httpResponse.getEntity();
		      //System.out.println(EntityUtils.toString(entity));
		      String getResponse =EntityUtils.toString(entity);
		      resultJSON = new JSONObject(getResponse);
		    }
		    catch(Exception e) 
		    {
		    	System.out.println("Exception in GET "+e);
		    }

	}

	@Then("^I receive the weather forecast$")
	public void I_recieve_the_weather_forecast() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		int length;
		jsonArray = resultJSON.getJSONArray("list");
		length = jsonArray.length();
		for (int i =0; i< length;i++)
		{
			jObj = jsonArray.getJSONObject(i);
			if (jObj.getString("dt_txt").equals(dayOfWeek))
				break;
			
		}
		System.out.println("The weather for date :"+jObj.getString("dt_txt")+": "+jObj);
	}

	@Then("^the temperature is warmer than (\\d+) degrees$")
	public void the_temprature_is_warmer_than_degrees(Integer arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		JSONObject jObject = jObj.getJSONObject("main");
		System.out.println("The Temprature on Day is :"+jObject);
		if(jObject.getInt("temp")> 283)
			System.out.println("Its a good day to go out in Sydney");
	    
	}
	
}
//////////////////////////////////////////////////////////////////////
