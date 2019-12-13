package com.fsd.stock.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.company.common.IpoRspModel;
import com.fsd.stock.company.common.ListIpoModel;
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
@RequestMapping("/ipo")
@Api(description = "IPO Interface")
public class IpoController {

	@Autowired
	private ICompanyService companySrc;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "list all ipos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<ListIpoModel> listIpos() {
		ListIpoModel rsp = new ListIpoModel();
		try {
			List<IpoDetails> Ipos = companySrc.listIpos();
			if (Ipos.size() == 0) {
				rsp.setCode(400);
				rsp.setMessage("ipo list empty");
				return new ResponseEntity<ListIpoModel>(rsp, HttpStatus.OK);
			} else {
				rsp.setCode(200);
				rsp.setMessage("ipo are listed");
				rsp.setData(Ipos);
				return new ResponseEntity<ListIpoModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<ListIpoModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
 	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "create IPO record")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<IpoRspModel> add(
			@ApiParam(name = "body", required = true) @RequestBody IpoDetails ipoDetails) {
 		IpoRspModel rsp = new IpoRspModel();
		try {
			IpoDetails checkipoDetails = companySrc.selectIpoByCompany(ipoDetails.getCompanyName());
			if (checkipoDetails == null) {
				Result rs = companySrc.addIpoDetails(ipoDetails);
				if (rs.get("code").equals(200)) {
					rsp.setCode(200);
					rsp.setMessage("IPO record for " + ipoDetails.getCompanyName() + " was created");
					return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.OK);
				} else {
					rsp.setCode(400);
					rsp.setMessage("IPO record added fail");
					return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.OK);
				}
			} else {
				rsp.setCode(400);
				rsp.setMessage("IPO record already exist for company " + ipoDetails.getCompanyName());
				return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(value = "/getDetails", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "get IPO details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<IpoRspModel> getDetails(
			@ApiParam(name = "body", required = true) @RequestBody int ipoId) {
		IpoRspModel rsp = new IpoRspModel();
		try {
			IpoDetails ipoDetails = companySrc.selectIpoDetails(ipoId);
			if (ipoDetails == null) {
				rsp.setCode(400);
				rsp.setMessage("IPO details not found");
				return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.OK);
			} else {
				rsp.setCode(200);
				rsp.setMessage("IPO Details for ID " + ipoDetails.getIpoId() + " was found");
				rsp.setData(ipoDetails);
				return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "update IPO details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<IpoRspModel> update(
			@ApiParam(name = "body", required = true) @RequestBody IpoDetails ipoDetails) {
		IpoRspModel rsp = new IpoRspModel();
		try {
			Result rs = companySrc.updateIpoDetails(ipoDetails);
			if (rs.get("code").equals(200)) {
				rsp.setCode(200);
				rsp.setMessage("IPO Details for ID" + ipoDetails.getIpoId() + " was updated");
				rsp.setData(ipoDetails);
				return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.OK);
			} else {
				rsp.setCode(400);
				rsp.setMessage("IPO details updated fail");
				return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.OK);		
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<IpoRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
