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
import GC.ApiProject.entity.BucketList;

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
	public String showEvents(@RequestParam("city")String city,Model model) {
		
		List <Events> events = apiServ.showCity(city);
		model.addAttribute("events", events);
		model.addAttribute("cityName", city);

		return "filterResults";
	}
	
	@RequestMapping("/detailResults")
	public String showDetails(@RequestParam("id")  String id, Model model) {
		List <Events> events = apiServ.showDeets(id);
		
		model.addAttribute("events", events);
	
		
		return "detailResults";
	}
	
	@RequestMapping("/dateResults")
	public String showDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDateTime, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date endDateTime , Model model) {
		
		List <Events> events = apiServ.showDates(startDateTime,endDateTime);
		
		model.addAttribute("events", events);
	
		
		return "filterResults";
	}
	
	@RequestMapping("/keywordResults")
	public String showKeyword(@RequestParam ("keyword") String keyword , Model model) {
		List <Events> events = apiServ.showKeyword(keyword);
		
		model.addAttribute("events", events);
	
		
		return "filterResults";
	}
	
	@RequestMapping("/addBucket")
	   public String addBucklist(@RequestParam("id") String id, Model model) {
	
		//find event by id
	  	 List <Events> events = apiServ.showDeets(id);
	  	for(int i=0; i<events.size(); i++ ) {
 			 String name = events.get(i).getName();
 			 String info = events.get(i).getInfo();
 			 //Dates date = events.get(i).getDates();
 			 BucketList bucketList = new BucketList();
 			 bucketList.setName(name);
 			 bucketList.setInfo(info);
 			 bucketList.setId(id);
 			 //table.setDate(date);
 			 dao.save(bucketList);
 			 model.addAttribute("bucketList", bucketList);
 			 
	  	} return "otherResults";
 					 
 	
	}
	
	@RequestMapping("/bucketList")
	   public String showBucket(BucketList bucketLists, Model model) {
		List <BucketList> bucketList = dao.findAll();
		model.addAttribute("bucketList", bucketList);
		
			return "bucketList";
	}
	@RequestMapping("/deleteBucket/{id}/delete")
	public String deleteBucket(@PathVariable("id")Long id) {
		
		
		dao.deleteById(id);
		
		return "redirect:/bucketList";
	}

	}

