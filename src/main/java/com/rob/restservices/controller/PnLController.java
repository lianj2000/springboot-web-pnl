package com.rob.restservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rob.restservices.entities.DailyPnL;
import com.rob.restservices.entities.DailySummaryPnL;
import com.rob.restservices.exceptions.PortfolioNotFoundException;
import com.rob.restservices.service.PnLService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
//@RequestMapping("/PnLs")
public class PnLController {

	@Autowired
	PnLService pnlService;
	
	@GetMapping(path = "/PnLs/{region}",produces = MediaType.APPLICATION_JSON_VALUE)
	public DailySummaryPnL getPnLTotalForRegion(@PathVariable("region") String region) throws PortfolioNotFoundException{
		return pnlService.getPnlTotalForRegion(region);
	}
	
	@GetMapping(path = "/PnLs",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DailySummaryPnL> getPnLTotal() throws PortfolioNotFoundException {
		return pnlService.getPnlTotal();
	}
	
	@GetMapping(path = "/PnLDetails/{region}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DailyPnL> getPnLDetailsForRegion(@PathVariable("region") String region) throws PortfolioNotFoundException{
		return pnlService.getPnlDetailsRegion(region);
	}
	
	@GetMapping(path = "/PnLDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DailyPnL> getPnLDetailsTotal() throws PortfolioNotFoundException {
		return pnlService.getPnlDetailsAll();
	}
	
	
}
