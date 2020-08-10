package com.rob.restservices;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rob.restservices.entities.DailyPnL;

@SpringBootApplication
public class SpringbootWebPnL implements ApplicationRunner {

	@Autowired
	DataSource oracleDataSource;
	
	@Autowired
	RowMapper<DailyPnL> pnlRowMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebPnL.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		JdbcTemplate template = new JdbcTemplate(oracleDataSource);
		int cnt = template.queryForObject("select count(*) from EMPLOYEES",Integer.class);
		System.out.println("employee count:" + cnt);
		
		/*
		 * String PNL_ALL_QUERY =
		 * " select cp.portfolio, cp.ticker, sum( cp.pos *(sp.tod_close - sp.pre_close)) dailyChange, cp.pos position, sp.tod_close, sp.pre_close\r\n"
		 * + " from current_position CP join stock_price SP\r\n" +
		 * " on CP.ticker = SP.ticker\r\n" + " group by cp.portfolio,cp.ticker";
		 * 
		 * 
		 * List<DailyPnL> list = template.query(PNL_ALL_QUERY, pnlRowMapper);
		 * 
		 * System.out.println(list.size());
		 */
		
		String PNL_DETAILS_REGION = 
				" select cp.portfolio, cp.ticker,  cp.pos *(sp.tod_close - sp.pre_close) dailyChange, cp.pos position, sp.tod_close, sp.pre_close\r\n" + 
				" from current_position CP join stock_price SP\r\n" + 
				" on CP.ticker = SP.ticker\r\n" + 
				" where cp.portfolio=?\r\n" + 
				" order by cp.portfolio,cp.ticker";
		
		System.out.println(PNL_DETAILS_REGION);
		
		List<DailyPnL> pnl = template.query(PNL_DETAILS_REGION, pnlRowMapper,"EU");
		System.out.println(pnl);
	}

}

