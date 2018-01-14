package apiclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherAPIClient {

	/**
	 * Main program
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String apiUrl = "https://query.yahooapis.com/v1/public/yql?q=select%20astronomy.sunset,%20astronomy.sunrise%20from%20weather.forecast%20where%20woeid%20=%202440549&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
			Client client = ClientBuilder.newClient();
			String response = client.target(apiUrl).path("/").request(MediaType.APPLICATION_JSON).get(String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonObject = mapper.readTree(response);
			System.out.println("Sunrise: " + jsonObject.get("query").get("results").get("channel").get("astronomy").get("sunrise").asText());
			System.out.println("Sunset: " + jsonObject.get("query").get("results").get("channel").get("astronomy").get("sunset").asText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
