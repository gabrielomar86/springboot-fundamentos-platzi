package com.fundamentosplatzi.springboot.fundamentos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	@Qualifier("componentImplementation")
	@Autowired
	private ComponentDependency componentDependency;

	@Autowired
	private MyBean myBean;

	@Autowired
	private MyBeanWithProperties myBeanWithProperties;

	@Autowired
	private UserPojo userPojo;

	@Autowired
	private UserRepository userRepository;

	public FundamentosApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void saveUsersInDataBase() {
		User user = new User("gabriel", "gabriel@gabriel.com", LocalDate.of(2021, 12, 1));
		User user2 = new User("gabriel2", "gabriel2@gabriel.com", LocalDate.of(2021, 12, 2));
		User user3 = new User("gabriel3", "gabriel3@gabriel.com", LocalDate.of(2021, 12, 3));
		User user4 = new User("gabriel4", "gabriel4@gabriel.com", LocalDate.of(2021, 12, 4));
		User user5 = new User("gabriel5", "gabriel5@gabriel.com", LocalDate.of(2021, 12, 5));
		User user6 = new User("gabriel6", "gabriel6@gabriel.com", LocalDate.of(2021, 12, 6));

		List<User> userList = Arrays.asList(user, user2, user3, user4, user5, user6);
		userRepository.saveAll(userList);
		// userList.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores() {

		this.componentDependency.Saludar();
		this.myBean.print();
		this.myBeanWithProperties.printProperty();
		System.out.println("UserPojo: " + this.userPojo.getEmail());
		System.out.println("UserPojo: " + this.userPojo.getPassword());
		System.out.println("UserPojo: " + this.userPojo.getAge().toString());
		LOGGER.error("Error log");
		// RickAndMorty ejemplo = this.myBean.consumirEndpointRickyMorty();

	}

	private void getInformationJpqlFromUser() {
		LOGGER.warn("getInformationJpql"
				+ userRepository.findByUserEmail("gabriel@gabriel.com")
						.orElseThrow(() -> new RuntimeException("User not found")));
		LOGGER.warn("getInformationJpql"
				+ userRepository.findAndSort("gabriel", Sort.by("id").descending())
						.orElseThrow(() -> new RuntimeException("Users not found")));

	}
}
