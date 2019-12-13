package com.fsd.stock.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.company.common.Result;
import com.fsd.stock.company.entity.BaseCompany;
import com.fsd.stock.company.entity.CompanySector;
import com.fsd.stock.company.entity.IpoDetails;
import com.fsd.stock.company.mapper.CompanyMapper;
import com.fsd.stock.company.mapper.IpoMapper;
import com.fsd.stock.company.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService {
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private IpoMapper ipoMapper;

	@Override
	public Result addCompany(BaseCompany company) {
		try {
			companyMapper.saveCompany(company);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

	@Override
	public BaseCompany selectCompanyByCode(String companyCode) {
		BaseCompany company = companyMapper.selectCompanyByCode(companyCode);
		return company;
	}

	@Override
	public IpoDetails selectIpoDetails(int ipoId) {
		IpoDetails ipoDetails = ipoMapper.selectIpoDetails(ipoId);
		return ipoDetails;
	}

	@Override
	public IpoDetails selectIpoByCompany(String companyName) {
		IpoDetails ipoDetails = ipoMapper.selectIpoByCompany(companyName);
		return ipoDetails;
	}

	@Override
	public Result addIpoDetails(IpoDetails ipoDetails) {
		try {
			ipoMapper.saveIpo(ipoDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

	@Override
	public Result updateIpoDetails(IpoDetails ipoDetails) {
		try {
			ipoMapper.updateIpo(ipoDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

	@Override
	public List<BaseCompany> listCompanyByName(String companyName) {
		List<BaseCompany> companys = companyMapper.listCompanyByName(companyName);
		return companys;
	}

	@Override
	public List<BaseCompany> listBySector(String sectorName) {
		List<BaseCompany> companys = companyMapper.listBySector(sectorName);
		return companys;
	}

	@Override
	public List<BaseCompany> listAll() {
		List<BaseCompany> companys = companyMapper.listAll();
		return companys;
	}

	@Override
	public Result updateCompanyDetails(BaseCompany company) {
		try {
			companyMapper.updateCompany(company);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		}
		return Result.ok();
	}

	@Override
	public List<IpoDetails> listIpos() {
		List<IpoDetails> ipos = ipoMapper.listAll();
		return ipos;
	}
	

}
