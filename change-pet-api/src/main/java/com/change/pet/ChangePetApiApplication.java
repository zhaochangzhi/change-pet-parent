package com.change.pet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaochangzhi
 * @description
 * @date 2018/9/14 15:39
 */
@SpringBootApplication
@MapperScan(basePackages = "com.change.pet.dao")
public class ChangePetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChangePetApiApplication.class, args);
	}
}
