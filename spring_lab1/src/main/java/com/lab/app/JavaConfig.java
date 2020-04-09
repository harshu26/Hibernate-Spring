package com.lab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.lab.app.Employee;

@Configuration
@ComponentScan("com.lab.app")
@PropertySource("classpath:employee.properties")

public class JavaConfig {

	
}
