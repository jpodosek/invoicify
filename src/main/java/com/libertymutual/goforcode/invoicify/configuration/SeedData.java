package com.libertymutual.goforcode.invoicify.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepository;

@Configuration
@Profile("development") //will only load this configuration (bean) if active spring profile is named "development"
public class SeedData {
	
	
	public SeedData(UserRepository userRepository) {
		userRepository.save(new User("admin", "admin", "ADMIN"));
		userRepository.save(new User("clerk", "clerk", "CLERK"));
		userRepository.save(new User("accountant", "accountant", "ACCOUNTANT"));
	}
}
