package com.fsd.stock.company.common;

import javax.validation.constraints.NotNull;

import com.fsd.stock.company.entity.BaseCompany;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Sector action model")
public class CompanyRspModel {
	
	@ApiModelProperty(notes = "code", example = "200", required = true, dataType = "java.lang.Integer")
	@NotNull
	private Integer code;
	
	@ApiModelProperty(notes = "message", example = "Created", required = true, dataType = "java.lang.String")
	@NotNull
	private String message;
	
	@ApiModelProperty(notes = "data", required = true, dataType = "java.lang.Object")
	private BaseCompany data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BaseCompany getData() {
		return data;
	}

	public void setData(BaseCompany data) {
		this.data = data;
	}

	
	

}