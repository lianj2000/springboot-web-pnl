package com.rob.restservices.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rob.restservices.entities.DailyPnL;
import com.rob.restservices.entities.DailySummaryPnL;
import com.rob.restservices.exceptions.PortfolioNotFoundException;
import com.rob.restservices.service.PnLService;
@Controller
//@RequestMapping("/PnLs")
public class PnLPageController {

	@Value("${welcome.message}")
    private String welcomeMessage;

	
	@Autowired
	PnLService pnlService;
	
	/*
	 * @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 * List<DailySummaryPnL> getAllPnL() throws PortfolioNotFoundException{ return
	 * pnlService.getPnlTotal(); }
	 */
	
	//@GetMapping(path = "/PnLsPage/{region}")
	public DailySummaryPnL getPnLTotalForRegion(@PathVariable("region") String region, Model model) throws PortfolioNotFoundException{
		return pnlService.getPnlTotalForRegion(region);
	}
	
	@GetMapping(path = "/PnLsPage")
	public String getPnLTotal(Model model,Principal principal) throws PortfolioNotFoundException {
		
		 List<DailySummaryPnL> pnlList = pnlService.getPnlTotal();
		 model.addAttribute("pnls",pnlList );
		 String name = principal.getName(); //get logged in username
	     model.addAttribute("username", name);
	     model.addAttribute("message", welcomeMessage);
		 return "pnlPage";
	}
	
	@GetMapping(path = "/PnLDetailsPage/{region}")
	public String getPnLDetailsForRegion(@PathVariable("region") String region,Model model,Principal principal) throws PortfolioNotFoundException{
		List<DailyPnL>pnlList = pnlService.getPnlDetailsRegion(region);
		model.addAttribute("pnldetails",pnlList );
		String name = principal.getName(); //get logged in username
	    model.addAttribute("username", name);
	    model.addAttribute("message", welcomeMessage);
		return "pnlDetailPage";
	}
	
	//@GetMapping(path = "/PnLDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DailyPnL> getPnLDetailsTotal() throws PortfolioNotFoundException {
		return pnlService.getPnlDetailsAll();
	}
	
	
}
