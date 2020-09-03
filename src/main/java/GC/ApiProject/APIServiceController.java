package GC.ApiProject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
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
	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT,"");
			return execution.execute(request, body);
		};
		rt = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}
	
	public List<Events> showDates(Date startDateTime, Date endDateTime){
		
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  

          //startDateTime = new SimpleDateFormat("yyyy-mm-dd");  
         // endDateTime = new SimpleDateFormat("yyyy-mm-dd");  
          String endDate = formatter.format(endDateTime); 
          String strDate = formatter.format(startDateTime); 
          System.out.println(strDate);
	
		String url = "https://app.ticketmaster.com/discovery/v2/events.json?startDateTime={strDate}T01:00:00Z&endDateTime={endDate}T23:59:00Z&apikey={apiKey}";
		List<Events> events;		
		TicketResponse response = rt.getForObject(url, TicketResponse.class, strDate, endDate, apiKey);
		events = response.get_embedded().getEvents();
		return events;
		
	}
	
	public List<Events> showCity(String city){
		
		String url = "https://app.ticketmaster.com/discovery/v2/events.json?city={city}&apikey={apiKey}";
		List<Events> events;		
		TicketResponse response = rt.getForObject(url, TicketResponse.class, city, apiKey);
		events = response.get_embedded().getEvents();
		return events;
		
	}
	
		public List<Events> showKeyword(String keyword){
		
		String url = "https://app.ticketmaster.com/discovery/v2/events.json?keyword={keyword}&apikey={apiKey}";
		List<Events> events;		
		TicketResponse response = rt.getForObject(url, TicketResponse.class, keyword, apiKey);
		events = response.get_embedded().getEvents();
		return events;
		
	}
	
	public List <Events> showDeets(String id) {
		String url = "https://app.ticketmaster.com/discovery/v2/events.json?id={id}&apikey={apiKey}";
		TicketResponse response = rt.getForObject(url, TicketResponse.class, id, apiKey);
		return response.get_embedded().getEvents();
		
	}

}
