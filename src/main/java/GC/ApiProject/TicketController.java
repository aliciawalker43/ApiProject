package GC.ApiProject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import GC.ApiProject.dao.Dao;
import GC.ApiProject.entity.Dates;
import GC.ApiProject.entity.Events;
import GC.ApiProject.entity.Table;

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
	
	@RequestMapping("/dateResults")
	public String showDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDateTime, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date endDateTime , Model model) {
		
		List <Events> events = apiServ.showDates(startDateTime,endDateTime);
		
		model.addAttribute("events", events);
	
		
		return "otherResults";
	}
	
	@RequestMapping("/keywordResults")
	public String showKeyword(@RequestParam String keyword , Model model) {
		List <Events> events = apiServ.showKeyword(keyword);
		
		model.addAttribute("events", events);
	
		
		return "otherResults";
	}
	
	@RequestMapping("/addbucket")
	   public String addBucklist(@RequestParam String id, Model model) {
		Events event = null;
		//find event by id
	  	 List <Events> events = apiServ.showDeets(id);
	  	for(int i=0; i<events.size(); i++ ) {
 			 String name = events.get(i).getName();
 			 String info = events.get(i).getInfo();
 			 //Dates date = events.get(i).getDates();
 			 Table table = new Table();
 			 table.setName(name);
 			 table.setInfo(info);
 			 //table.setDate(date);
 			 dao.save(table);
 			 model.addAttribute("table", table);
 			 
	  	}
 					 return "redirect:/bucketlist";
	
	}
	
	@RequestMapping("/bucketList")
	   public String showBucket(Table table, Model model) {
		 List <Table> tables = dao.findAll();
		model.addAttribute("tables", tables);
		
			return "bucketList";
	}

      @RequestMapping("/bucketList")
      public String addBucklist(@RequestParam String id, Model model) {
    	  //find event by id
    	  List <Events> events = apiServ.showDeets(id);
  		//save to database id
    	 
  		model.addAttribute("events", events);
  		Events event;
  		
  		for(int i=0; i<events.size(); i++ ) {
  			 event= events.get(i);
  		}
  		
  		System.out.println(event);
    	  return"bucketList";
      }
	
	
}
