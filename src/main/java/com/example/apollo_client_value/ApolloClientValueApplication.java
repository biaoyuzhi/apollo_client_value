package com.example.apollo_client_value;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableApolloConfig
@SpringBootApplication
public class ApolloClientValueApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApolloClientValueApplication.class, args);
	}
}
