package com.fsd.stock.company.entity;

import lombok.Data;

@Data
public class BaseCompany {
	private String companyCode;
	private String companyName;
	private float turnover;
	private String ceo;
	private String directors;
	private String stockExchangesId;
	private String sectorName;
	private String brief;
	private String status;
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public float getTurnover() {
		return turnover;
	}
	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getDirectors() {
		return directors;
	}
	public void setDirectors(String directors) {
		this.directors = directors;
	}
	public String getStockExchangesId() {
		return stockExchangesId;
	}
	public void setStockExchangesId(String stockExchangesId) {
		this.stockExchangesId = stockExchangesId;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BaseCompany [companyCode=" + companyCode + ", companyName=" + companyName + ", turnover=" + turnover
				+ ", ceo=" + ceo + ", directors=" + directors + ", stockExchangesId=" + stockExchangesId
				+ ", sectorName=" + sectorName + ", brief=" + brief + ", status=" + status + "]";
	}
	public BaseCompany(String companyCode, String companyName, float turnover, String ceo, String directors,
			String stockExchangesId, String sectorName, String brief, String status) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.directors = directors;
		this.stockExchangesId = stockExchangesId;
		this.sectorName = sectorName;
		this.brief = brief;
		this.status = status;
	}
	public BaseCompany() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
