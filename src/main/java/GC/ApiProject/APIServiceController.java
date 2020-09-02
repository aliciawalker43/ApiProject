package GC.ApiProject;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import GC.ApiProject.entity.Events;
import GC.ApiProject.entity.TicketResponse;

@Service
public class APIServiceController {
	
	
	@Value("${api-key}")
	private String apiKey;
	
	
	private RestTemplate rt;
	// ADD DECK_ID value
	// initialization block that runs when a new instance of the class is created
	// loaded before the constructor
	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT,"");
			return execution.execute(request, body);
		};
		rt = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}
	
	public List<Events> showEvents(String city){
		
		//1. specify a URL
		String url = "https://app.ticketmaster.com/discovery/v2/events.json?city={city}apikey={apiKey}";
		List<Events> events;
		//2. call the API, response type to match entire JSON
		
		TicketResponse response = rt.getForObject(url, TicketResponse.class, city);
		
		//return certain parts of JSON response;
		events = response.get_embedded().getEvents();
		//return weather.getData();
		return events;
		
	}
	

}
