package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;

//	@Value("${driver}")
//	private String driver;
//
//	@Value("${url}")
//	private String jdbcUrl;
//
//	@Value("${username}")
//	private String jdbcUsername;
//
//	@Value("${password}")
//	private String jdbcPassword;

	@RequestMapping(value="/hi")
	public String hi(){
		return foo;
	}


//	@RequestMapping("/getDataBaseProp")
//	public String getDataBaseProp(){
//		return driver+"---";
////				+jdbcUrl+"---"+jdbcUsername+"----"+jdbcPassword;
//	}

}
