package com.softstream.web.services.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.softstream.web.services.entities.Category;
import com.softstream.web.services.entities.Order;
import com.softstream.web.services.entities.User;
import com.softstream.web.services.repositories.CategoryRepository;
import com.softstream.web.services.repositories.OrderRepository;
import com.softstream.web.services.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "61994552247", "1234565",null);
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "61994556632", "1234565", null);

		Order o1 = new Order(null, Instant.parse("2023-11-02T19:53:07Z"), 1, u2);
		Order o2 = new Order(null, Instant.parse("2023-11-03T20:55:08Z"), 2, u1);
		Order o3 = new Order(null, Instant.parse("2023-11-04T18:56:05Z"), 2, u2);
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

	}

}
