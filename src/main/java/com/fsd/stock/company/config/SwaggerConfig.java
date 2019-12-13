package com.fsd.stock.company.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import({springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {
	
	
	@Value(value = "${swagger.enabled}")
	Boolean swaggerEnabled;
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				// Open or not
				.enable(swaggerEnabled).select()
				// scan path
				.apis(RequestHandlerSelectors.basePackage("com.fsd.stock"))
				// 
				.paths(PathSelectors.any()).build().pathMapping("/");
	}
	
	
	//设置api信息
		private ApiInfo apiInfo() {
			return new ApiInfoBuilder()
					.title("Stock system- sector：swagger2 API Document")
					.description("stock")
					.contact(new Contact("system admin","",""))
					.version("1.0.0")
					.build();
		}

}