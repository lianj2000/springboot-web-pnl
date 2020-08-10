package com.rob.restservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.rob.restservices.entities.DailyPnL;

@Service
public class DailyPnLRowMapper implements RowMapper<DailyPnL>{

	@Override
	public DailyPnL mapRow(ResultSet rs, int rowNum) throws SQLException {
		DailyPnL dailyPnL = new DailyPnL();
		dailyPnL.setPortfolio(rs.getString("portfolio"));
		dailyPnL.setTicker(rs.getString("ticker"));
		dailyPnL.setDailyChange(rs.getDouble("dailyChange"));
		dailyPnL.setPosition(rs.getDouble("position"));
		dailyPnL.setCurrent_price(rs.getDouble("tod_close"));
		dailyPnL.setPre_close(rs.getDouble("pre_close"));
		
		return dailyPnL;
	}

}
