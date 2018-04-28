package com.ctian.demo;

import com.ctian.demo.domain.User;
import com.ctian.demo.repository.UserRepository;
import java.util.stream.Stream;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Charlie Tian
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("Zhang San", "Li Si", "Wang wu").forEach(name -> {
				User user = new User();
				user.setName(name);
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}
}
