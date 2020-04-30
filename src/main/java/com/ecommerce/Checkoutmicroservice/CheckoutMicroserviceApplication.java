package com.ecommerce.Checkoutmicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class CheckoutMicroserviceApplication  implements CommandLineRunner {



	public static void main(String[] args) {

		SpringApplication.run(CheckoutMicroserviceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
