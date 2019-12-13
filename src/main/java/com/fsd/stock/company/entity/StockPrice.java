package com.fsd.stock.company.entity;

import java.math.BigDecimal;

public class StockPrice {
	
	private String companyCode;
	private String stockExchangesId;
	private BigDecimal price;
	private String date;
	private String time;
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockExchangesId() {
		return stockExchangesId;
	}
	public void setStockExchangesId(String stockExchangesId) {
		this.stockExchangesId = stockExchangesId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "StockPrice [companyCode=" + companyCode + ", stockExchangesId=" + stockExchangesId + ", price=" + price
				+ ", date=" + date + ", time=" + time + "]";
	}
	
	
}
