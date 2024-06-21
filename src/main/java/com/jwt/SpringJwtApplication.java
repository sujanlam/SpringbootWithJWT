package com.jwt;

import com.jwt.entity.User;
import com.jwt.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringJwtApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUsers(){
		List<User> users = Stream.of(
				new User(101, "frank", "lampard", "fl@chealsea.com"),
				new User(102, "john", "terry", "fl@chealsea.com"),
				new User(103, "juan", "mata", "fl@chealsea.com"),
				new User(104, "didier", "drogba", "fl@chealsea.com"),
				new User(105, "ricardo", "carvalho", "fl@chealsea.com"),
				new User(106, "jose", "bosingwa", "fl@chealsea.com")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
		System.out.println("JWT App is running!!!");
	}

}
