package com.libertymutual.goforcode.invoicify.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepository;

@Configuration
@Profile("development") //will only load this configuration (bean) if active spring profile is named "development"
public class SeedData {
	
	
	public SeedData(UserRepository userRepository, PasswordEncoder encoder) {
		userRepository.save(new User("admin", encoder.encode("admin"), "ADMIN" ));
		userRepository.save(new User("clerk", encoder.encode("clerk"), "CLERK" ));
		userRepository.save(new User("accountant", encoder.encode("accountant"), "ACCOUNTANT"));
	}
}
