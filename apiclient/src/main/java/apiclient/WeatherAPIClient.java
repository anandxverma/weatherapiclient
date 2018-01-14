package apiclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class WeatherAPIClient {

	public static void main(String[] args) {
		String apiUrl = "https://query.yahooapis.com/v1/public/yql?q=select%20astronomy.sunset,%20astronomy.sunrise%20from%20weather.forecast%20where%20woeid%20=%202440549&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		Client client = ClientBuilder.newClient();
		Object o = client.target(apiUrl).path("/").request(MediaType.APPLICATION_JSON).get();
		System.out.println(o);
	}

}
