package com.asi1.GameCard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.asi1.GameCard.cards.model", "com.asi1.GameCard.auth.model",
		"com.asi1.GameCard.trading.model" })
@EnableJpaRepositories(basePackages = { "com.asi1.GameCard.cards.repository", "com.asi1.GameCard.auth.repository",
		"com.asi1.GameCard.trading.repository" })
@ComponentScan(basePackages = { "com.asi1.GameCard.cards.controller", "com.asi1.GameCard.auth.controller",
		"com.asi1.GameCard.trading.controller", "com.asi1.GameCard.cards.service", "com.asi1.GameCard.auth.service",
		"com.asi1.GameCard.trading.service" })
public class GameCardApplication {
	public static void main(String[] args) {
		SpringApplication.run(GameCardApplication.class, args);
	}
}
