package com.rob.restservices.entities;

public class DailyPnL {
	private String portfolio;
	private String ticker;
	private double dailyChange;
	private double position;
	private double current_price;
	private double pre_close;
	
	public DailyPnL() {}
	
	public String getPortfolio() {
		return portfolio;
	}
	
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	
	public String getTicker() {
		return ticker;
	}
	
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	public double getDailyChange() {
		return dailyChange;
	}
	
	public void setDailyChange(double dailyChange) {
		this.dailyChange = dailyChange;
	}

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public double getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}

	public double getPre_close() {
		return pre_close;
	}

	public void setPre_close(double pre_close) {
		this.pre_close = pre_close;
	}

	@Override
	public String toString() {
		return "DailyPnL [portfolio=" + portfolio + ", ticker=" + ticker + ", dailyChange=" + dailyChange
				+ ", position=" + position + ", current_price=" + current_price + ", pre_close=" + pre_close + "]";
	}

}
