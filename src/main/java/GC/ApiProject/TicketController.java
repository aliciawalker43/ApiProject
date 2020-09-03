package GC.ApiProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import GC.ApiProject.dao.Dao;
import GC.ApiProject.entity.Events;

@Controller
public class TicketController {
	
	@Autowired
	private APIServiceController apiServ;
	
	@Autowired
	private Dao dao;
	
	@RequestMapping("/")
	public String home() {

		return "redirect:/index";
	}
	
	@RequestMapping("/index")
		public String getInputLocation() {

		return "index";
	}
	
	

	
	@RequestMapping("/filterResults")
	public String showEvents(@RequestParam String city,Model model) {
		
		List <Events> events = apiServ.showEvents(city);
		model.addAttribute("events", events);
		model.addAttribute("cityName", city);

		return "filterResults";
	}
	
	@RequestMapping("/detailResults/{id}")
	public String showDetails(@PathVariable String id, Events events, Model model) {
		model.addAttribute("events", events);
		
		return "detailResults";
	}

}
