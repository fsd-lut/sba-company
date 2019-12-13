package com.fsd.stock.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.stock.company.entity.PriceQueryForm;
import com.fsd.stock.company.entity.StockPrice;

@Service
public interface IPriceService {

 	List<StockPrice> getCompanyPrice(PriceQueryForm priceQueryForm);

}
