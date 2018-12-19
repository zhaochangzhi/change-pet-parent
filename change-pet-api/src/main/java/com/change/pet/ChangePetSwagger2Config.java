package com.change.pet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhaochangzhi
 * @description swagger配置
 * @date 2018/9/28 14:35
 */
@Configuration
@EnableSwagger2
public class ChangePetSwagger2Config {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.change.pet.controller"))
				.paths(PathSelectors.any()).build();

	}

	/**
	 * 构建api文档的详细信息函数
	 */
	private ApiInfo apiInfo() {

		return new ApiInfoBuilder()
				//页面标题
				.title("CHANGE PET使用Swagger2构建RESTFul API")
				//创建人
				.contact(new Contact("zhaochangzhi", "http://www.baidu.com", "changzhi.zhao@163.com"))
				//版本号
				.version("1.0")
				//描述
				.description("API 描述")
				.build();
	}
}