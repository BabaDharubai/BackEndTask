package com.pdfcreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author BabaFakruddinDharubai
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class FlattenapiCloudGatewayApplication {

	/**
	 * @param args array of arguments to pass
	 */
	public static void main(String[] args) {
		SpringApplication.run(FlattenapiCloudGatewayApplication.class, args);
	}

}
