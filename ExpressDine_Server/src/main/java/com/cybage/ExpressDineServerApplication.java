package com.cybage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.cybage.model.PDFGenerator;
import com.cybage.model.RestaurantPDFGenerator;

@SpringBootApplication(scanBasePackages = "com.cybage")
@EnableJpaRepositories("com.cybage.dao")
@EntityScan("com.cybage.model")
public class ExpressDineServerApplication {

	public static void main(String[] args) {
		ApplicationContext ac = 
				SpringApplication.run(ExpressDineServerApplication.class, args);

		PDFGenerator pDFGenerator = ac.getBean("pdfGenerator", PDFGenerator.class);
		RestaurantPDFGenerator pDFGenerator2 = ac.getBean("pdfGenerator2", RestaurantPDFGenerator.class);
		

		pDFGenerator.generatePdfReport();
		pDFGenerator2.generatePdfReport();
		

	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}