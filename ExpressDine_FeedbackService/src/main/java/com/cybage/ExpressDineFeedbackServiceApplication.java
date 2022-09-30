package com.cybage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cybage")
@EnableJpaRepositories("com.cybage.dao")
@EntityScan("com.cybage.model")
public class ExpressDineFeedbackServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpressDineFeedbackServiceApplication.class, args);
	}

}
