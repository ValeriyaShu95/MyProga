package com.proga.MyProga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.proga.MyProga")
public class MyProgaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProgaApplication.class, args);
	}

}
