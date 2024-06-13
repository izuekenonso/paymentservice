package com.example.paymentservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AccountServiceWebclient {

	@Bean
	public AccountService accountService() {
		
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:9093/").build();
		WebClientAdapter adapter = WebClientAdapter.create(webClient);
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

		return factory.createClient(AccountService.class);
	}
}
