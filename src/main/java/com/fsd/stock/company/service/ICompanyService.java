package com.fsd.stock.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.stock.company.common.Result;
import com.fsd.stock.company.entity.BaseCompany;
import com.fsd.stock.company.entity.IpoDetails;

@Service
public interface ICompanyService {

	Result addCompany(BaseCompany company);

	BaseCompany selectCompanyByCode(String companyCode);

	IpoDetails selectIpoDetails(int ipoId);

	IpoDetails selectIpoByCompany(String companyName);

	Result addIpoDetails(IpoDetails ipoDetails);

	Result updateIpoDetails(IpoDetails ipoDetails);

	List<BaseCompany> listCompanyByName(String companyName);

	List<BaseCompany> listBySector(String sectorName);

	List<BaseCompany> listAll();

	Result updateCompanyDetails(BaseCompany company);

	List<IpoDetails> listIpos();

}
