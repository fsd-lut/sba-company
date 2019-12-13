package com.fsd.stock.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fsd.stock.company.entity.BaseCompany;

@Mapper
public interface CompanyMapper {

	void saveCompany(BaseCompany company);

	BaseCompany selectCompanyByCode(@Param("companyCode")String companyCode);

	List<BaseCompany> listCompanyByName(@Param("companyName")String companyName);

	List<BaseCompany> listBySector(@Param("sectorName")String sectorName);

	List<BaseCompany> listAll();

	void updateCompany(BaseCompany company);

}
