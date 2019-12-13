package com.fsd.stock.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.company.entity.PriceQueryForm;
import com.fsd.stock.company.entity.StockPrice;
import com.fsd.stock.company.mapper.PriceMapper;
import com.fsd.stock.company.service.IPriceService;

@Service
public class PriceServiceImpl implements IPriceService {
	@Autowired
	private PriceMapper priceMapper;

	@Override
	public List<StockPrice> getCompanyPrice(PriceQueryForm priceQueryForm) {
		List<StockPrice> stockPriceList = priceMapper.getStockPrice(priceQueryForm.getCompanyCode(), priceQueryForm.getFromDate(),priceQueryForm.getEndDate());
		return stockPriceList;
	}
	

}
