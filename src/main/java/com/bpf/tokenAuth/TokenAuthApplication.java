package com.bpf.tokenAuth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bpf.tokenAuth.mapper")
public class TokenAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenAuthApplication.class, args);
	}
}
