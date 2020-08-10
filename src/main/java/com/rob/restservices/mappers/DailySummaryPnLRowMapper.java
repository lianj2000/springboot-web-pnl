package com.rob.restservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.rob.restservices.entities.DailyPnL;
import com.rob.restservices.entities.DailySummaryPnL;

@Service
public class DailySummaryPnLRowMapper implements RowMapper<DailySummaryPnL>{

	@Override
	public DailySummaryPnL mapRow(ResultSet rs, int rowNum) throws SQLException {
		DailySummaryPnL dailyPnL = new DailySummaryPnL();
		dailyPnL.setPortfolio(rs.getString("portfolio"));
		dailyPnL.setDailyTotalChange(rs.getDouble("dailyTotalChange"));
		return dailyPnL;
	}

}
