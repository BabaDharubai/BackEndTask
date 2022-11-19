package com.pdfcreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author BabaFakruddinDharubai
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class SpringFlattenpdfCreatorApplication{

	/**
	 * @param args to pass array of arguments to the method
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringFlattenpdfCreatorApplication.class, args);
	}
}
