package com.lab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.lab.app.Employee;
import java.util.*;
@Configuration
@ComponentScan("com.lab.app")
@PropertySource("classpath:employee.properties")

public class JavaConfig {

	@Bean
	public SBU sbu() {
		Employee employee1 = new Employee();
		List<Employee>list = new ArrayList<Employee>();
		list.add(employee1);
		SBU sbu1 = new SBU();
		sbu1.setEmpList(list);
		return sbu1;
	}
	
}
