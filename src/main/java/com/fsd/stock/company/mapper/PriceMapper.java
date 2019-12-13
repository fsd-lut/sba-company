package com.fsd.stock.company.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fsd.stock.company.entity.StockPrice;

@Mapper
public interface PriceMapper {

	List<StockPrice> getStockPrice(@Param("companyCode")String companyCode, @Param("fromDate")Date fromDate, @Param("endDate")Date endDate);	

}
