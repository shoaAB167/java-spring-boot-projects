package com.s_project_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.s_project_hibernate.repository")
@SpringBootApplication
public class SpringJpaHibernateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateProjectApplication.class, args);
	}

}
