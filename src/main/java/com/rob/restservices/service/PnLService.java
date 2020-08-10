package com.rob.restservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.rob.restservices.entities.DailyPnL;
import com.rob.restservices.entities.DailySummaryPnL;
import com.rob.restservices.exceptions.PortfolioNotFoundException;

@Service
public class PnLService {
	public static final String PNL_DETAILS_ALL = 
			" select cp.portfolio, cp.ticker,  cp.pos *(sp.tod_close - sp.pre_close) dailyChange, cp.pos position, sp.tod_close, sp.pre_close\r\n" + 
			" from current_position CP join stock_price SP\r\n" + 
			" on CP.ticker = SP.ticker\r\n" + 
			" order by cp.portfolio,cp.ticker";
	
	public static final String PNL_DETAILS_REGION = 
			" select cp.portfolio, cp.ticker,  cp.pos *(sp.tod_close - sp.pre_close) dailyChange, cp.pos position, sp.tod_close, sp.pre_close\r\n" + 
			" from current_position CP join stock_price SP\r\n" + 
			" on CP.ticker = SP.ticker\r\n" + 
			" where cp.portfolio=?\r\n" + 
			" order by cp.portfolio,cp.ticker";
	
	public static final String PNL_SUMMARY_REGION= 
			" select cp.portfolio,  sum( cp.pos *(sp.tod_close - sp.pre_close)) dailyTotalChange\r\n" + 
			" from current_position CP join stock_price SP\r\n" + 
			" on CP.ticker = SP.ticker\r\n" + 
			" where cp.portfolio=?\r\n" + 
			" group by cp.portfolio";
	
	public static final String PNL_SUMMARY = 
			" select cp.portfolio,  sum( cp.pos *(sp.tod_close - sp.pre_close)) dailyTotalChange\r\n" + 
			" from current_position CP join stock_price SP\r\n" + 
			" on CP.ticker = SP.ticker\r\n" + 
			" group by cp.portfolio";
	
	@Autowired
	//DataSource oracleDataSource;
	JdbcTemplate oracleTemplate;
	
	@Autowired
	RowMapper<DailyPnL> pnlRowMapper;
	
	@Autowired
	RowMapper<DailySummaryPnL> pnlSummaryRowMapper;
	
	public List<DailyPnL> getPnlDetailsAll(){
		return oracleTemplate.query(PNL_DETAILS_ALL, pnlRowMapper);
	}
	
	public List<DailyPnL> getPnlDetailsRegion(String region) throws PortfolioNotFoundException{
		List<DailyPnL> pnl = null;
		
		try {
			pnl = oracleTemplate.query(PNL_DETAILS_REGION, pnlRowMapper,region);
		}catch(Exception ex) {
			throw new PortfolioNotFoundException("Portfolio not found");
		}
		return pnl;
	}
	
	/*
	 * Need to handle exception when region is NOT found in data
	 * org.springframework.dao.EmptyResultDataAccessException: Incorrect result size: expected 1, actual 0
	 */
	public DailySummaryPnL getPnlTotalForRegion(String region) throws PortfolioNotFoundException{
		DailySummaryPnL pnl = null;
		
		try {
			pnl = oracleTemplate.queryForObject(PNL_SUMMARY_REGION,pnlSummaryRowMapper, region);
		}catch(Exception ex) {
			throw new PortfolioNotFoundException("Portfolio not found");
		}
		return pnl;
	}
	
	public List<DailySummaryPnL> getPnlTotal() throws PortfolioNotFoundException{
		List<DailySummaryPnL> pnlList = null;
		
		try {
			pnlList = oracleTemplate.query(PNL_SUMMARY,pnlSummaryRowMapper);
		}catch(Exception ex) {
			throw new PortfolioNotFoundException("Portfolio not found");
		}
		return pnlList;
	}
}
