package com.fsd.stock.company.entity;

import java.util.List;

import lombok.Data;

@Data
public class CompanySector {
 
	private String sectorName;
	private List<BaseCompany> companys;
	
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public List<BaseCompany> getCompanys() {
		return companys;
	}
	public void setCompanys(List<BaseCompany> companys) {
		this.companys = companys;
	}
	
}
