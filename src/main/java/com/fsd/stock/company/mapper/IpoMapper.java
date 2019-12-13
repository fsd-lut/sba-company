package com.fsd.stock.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fsd.stock.company.entity.IpoDetails;

@Mapper
public interface IpoMapper {

	IpoDetails selectIpoDetails(@Param("ipoId")int ipoId);
	
	IpoDetails selectIpoByCompany(@Param("companyName")String companyName);
	
	void saveIpo(IpoDetails ipoDetails);

	void updateIpo(IpoDetails ipoDetails);

	List<IpoDetails> listAll();

}
