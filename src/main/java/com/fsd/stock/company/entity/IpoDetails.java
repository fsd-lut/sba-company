package com.fsd.stock.company.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoDetails {
	private int ipoId;
	private String companyName;
	private String stockExchangesId;
	private BigDecimal sharePrice;
	private BigDecimal sharesNum;
	private Date openDateTime;
	private String remarks;
	public int getIpoId() {
		return ipoId;
	}
	public void setIpoId(int ipoId) {
		this.ipoId = ipoId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStockExchangesId() {
		return stockExchangesId;
	}
	public void setStockExchangesId(String stockExchangesId) {
		this.stockExchangesId = stockExchangesId;
	}
	public BigDecimal getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(BigDecimal sharePrice) {
		this.sharePrice = sharePrice;
	}
	public BigDecimal getSharesNum() {
		return sharesNum;
	}
	public void setSharesNum(BigDecimal sharesNum) {
		this.sharesNum = sharesNum;
	}
	public Date getOpenDateTime() {
		return openDateTime;
	}
	public void setOpenDateTime(Date openDateTime) {
		this.openDateTime = openDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
