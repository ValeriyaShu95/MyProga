package com.proga.MyProga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.proga.MyProga")
@EnableJpaRepositories
public class MyProgaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProgaApplication.class, args);
	}

}
