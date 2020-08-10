package com.rob.restservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
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
//@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				/*
				 * .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
				 */
				.apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
				  .apis(RequestHandlerSelectors.basePackage("com.rob.restservices"))
				 // .paths(PathSelectors.ant("/PnLs/**"))
				 
				.build();
				
	}
	
	//Swagger Metadata: http://localhost:8080/v2/api-docs
	//Swagger UI URL: http://localhost:8080/swagger-ui.html

	  private ApiInfo getApiInfo() { 
		  return new ApiInfoBuilder()
			  .title("com.rob PnL Service")
			  .description("This page lists all API's of PnL ") .version("2.0")
			  .contact(new Contact("Robert Ji", "https://www.rob.com",
			  "lianxiang.ji@gmail.com")) .license("License 2.0")
			  .licenseUrl("https://www.rob.com/license.html") .build();
	}
	  
}
