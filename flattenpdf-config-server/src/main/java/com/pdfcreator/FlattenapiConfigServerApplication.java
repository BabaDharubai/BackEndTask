package com.pdfcreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author BabaFakruddinDharubai
 *
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class FlattenapiConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlattenapiConfigServerApplication.class, args);
	}

}
