package GC.ApiProject;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	

	
	@RequestMapping("/cityResults")
	public String showEvents(@RequestParam String city,Model model) {
		
		List <Events> events = apiServ.showCity(city);
		model.addAttribute("events", events);
		model.addAttribute("cityName", city);

		return "filterResults";
	}
	
	@RequestMapping("/detailResults")
	public String showDetails(@RequestParam String id, Model model) {
		List <Events> events = apiServ.showDeets(id);
		
		model.addAttribute("events", events);
	
		
		return "detailResults";
	}
	
	@PostMapping("/dateResults")
	public String showDates(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate , Model model) {
		List <Events> events = apiServ.showDates(startDate,endDate);
		
		model.addAttribute("events", events);
	
		
		return "otherResults";
	}
	
	@RequestMapping("/keywordResults")
	public String showKeyword(@RequestParam String keyword , Model model) {
		List <Events> events = apiServ.showKeyword(keyword);
		
		model.addAttribute("events", events);
	
		
		return "otherResults";
	}

}
