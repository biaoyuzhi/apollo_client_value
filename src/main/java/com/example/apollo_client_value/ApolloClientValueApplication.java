package com.example.apollo_client_value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ApolloClientValueApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApolloClientValueApplication.class, args);
	}

	// 注入2个返回类型一致的bean，由方法名来区别
	@Bean
	public Map<String, String> wuzh(){
		Map<String, String> map = new HashMap<>();
		map.put("1", "wuzh");
		return map;
	}

	@Bean
	public Map<String, String> aa(){
		Map<String, String> map = new HashMap<>();
		map.put("1", "aa");
		return map;
	}
}
