package com.fsd.stock.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.company.common.PriceRspModel;
import com.fsd.stock.company.entity.PriceQueryForm;
import com.fsd.stock.company.entity.StockPrice;
import com.fsd.stock.company.service.IPriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/price")
@Api(description = "price Interface")
public class PriceController {

	@Autowired
	private IPriceService priceSrc;

	@RequestMapping(value = "/getbydate", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "get company price list within period")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "error request"), @ApiResponse(code = 401, message = "no authorize"),
			@ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<PriceRspModel> getStockPriceByDate(
			@ApiParam(name = "body", required = true) @RequestBody PriceQueryForm priceQueryForm) {
		PriceRspModel rsp = new PriceRspModel();
		try {
			List<StockPrice> stockPrice = priceSrc.getCompanyPrice(priceQueryForm);
			if (stockPrice == null) {
				rsp.setCode(400);
				rsp.setMessage("Company price list is empty");
				return new ResponseEntity<PriceRspModel>(rsp, HttpStatus.OK);
			} else {
				rsp.setCode(200);
				rsp.setMessage("Companys price are listed");
				rsp.setData(stockPrice);
				return new ResponseEntity<PriceRspModel>(rsp, HttpStatus.OK);
			}
		} catch (Exception ex) {
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<PriceRspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
