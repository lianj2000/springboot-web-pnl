package com.rob.restservices.entities;

public class DailySummaryPnL {
	private String portfolio;
	private double dailyTotalChange;
	
	public DailySummaryPnL() {}
	
	public String getPortfolio() {
		return portfolio;
	}
	
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public double getDailyTotalChange() {
		return dailyTotalChange;
	}

	public void setDailyTotalChange(double dailyTotalChange) {
		this.dailyTotalChange = dailyTotalChange;
	}
	
}
