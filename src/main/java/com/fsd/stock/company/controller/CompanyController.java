package com.fsd.stock.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.company.common.CompanyRspModel;
import com.fsd.stock.company.common.IpoRspModel;
import com.fsd.stock.company.common.ListRspModel;
import com.fsd.stock.company.common.Result;
import com.fsd.stock.company.entity.BaseCompany;
import com.fsd.stock.company.entity.IpoDetails;
import com.fsd.stock.company.service.ICompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(description = "Company Interface")
public class CompanyController {

	@Autowired
	private ICompanyService companySrc;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "create new company")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<CompanyRspModel> addCompany(
			@ApiParam(name = "body", required = true) @RequestBody BaseCompany company) {
		CompanyRspModel rsp = new CompanyRspModel();
		try {
			BaseCompany checkcompany = companySrc.selectCompanyByCode(company.getCompanyCode());
			if (checkcompany == null) {
				Result rs = companySrc.addCompany(company);
				if (rs.get("code").equals(200)) {
					rsp.setCode(200);
					rsp.setMessage("company " + company.getCompanyName() + " was created");
					return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.OK);
				} else {
					rsp.setCode(400);
					rsp.setMessage("company added fail");
					return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.OK);
				}
			} else {
				rsp.setCode(400);
				rsp.setMessage("company already exist");
				return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(value = "/getdetails", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "get company details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<CompanyRspModel> getDetails(
			@ApiParam(name = "body", required = true) @RequestBody String companyCode) {
		CompanyRspModel rsp = new CompanyRspModel();
		try {
			BaseCompany company = companySrc.selectCompanyByCode(companyCode);
			if (company == null) {
				rsp.setCode(400);
				rsp.setMessage("company not found");
				return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.OK);
			} else {
				rsp.setCode(200);
				rsp.setMessage("company " + company.getCompanyName() + " was found");
				rsp.setData(company);
				return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "search company by name")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<ListRspModel> search(
			@ApiParam(name = "body", required = true) @RequestBody String companyName) {
		ListRspModel rsp = new ListRspModel();
		try {
			List<BaseCompany> companys = companySrc.listCompanyByName(companyName);
			if (companys == null) {
				rsp.setCode(400);
				rsp.setMessage("company not found");
				return new ResponseEntity<ListRspModel>(rsp, HttpStatus.OK);
			} else {
				rsp.setCode(200);
				rsp.setMessage("companys are listed");
				rsp.setData(companys);
				return new ResponseEntity<ListRspModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<ListRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/listbysector", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "list companys by sector")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<ListRspModel> listCompanysBySector(
			@ApiParam(name = "body", required = true) @RequestBody String sectorName) {
		ListRspModel rsp = new ListRspModel();
		try {
			List<BaseCompany> companys = companySrc.listBySector(sectorName);
			if (companys == null) {
				rsp.setCode(400);
				rsp.setMessage("company not found");
				return new ResponseEntity<ListRspModel>(rsp, HttpStatus.OK);
			} else {
				rsp.setCode(200);
				rsp.setMessage("companys are listed");
				rsp.setData(companys);
				return new ResponseEntity<ListRspModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<ListRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "list all companys")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<ListRspModel> listAll() {
		ListRspModel rsp = new ListRspModel();
		try {
			List<BaseCompany> companys = companySrc.listAll();
			if (companys == null) {
				rsp.setCode(400);
				rsp.setMessage("company list empty");
				return new ResponseEntity<ListRspModel>(rsp, HttpStatus.OK);
			} else {
				rsp.setCode(200);
				rsp.setMessage("companys are listed");
				rsp.setData(companys);
				return new ResponseEntity<ListRspModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<ListRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "update company base info")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<CompanyRspModel> update(
			@ApiParam(name = "body", required = true) @RequestBody BaseCompany company) {
		CompanyRspModel rsp = new CompanyRspModel();
		try {
			Result rs = companySrc.updateCompanyDetails(company);
			if (rs.get("code").equals(200)) {
				rsp.setCode(200);
				rsp.setMessage("Company" + company.getCompanyName() + " was updated");
				rsp.setData(company);
				return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.OK);
			} else {
				rsp.setCode(400);
				rsp.setMessage("company updated fail");
				return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.OK);		
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<CompanyRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
}
