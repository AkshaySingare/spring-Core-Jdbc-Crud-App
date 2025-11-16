package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.model.Company;

public class Main {
	public static void main(String x[]) {
		
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(MainConfig.class);
		
		Company company = (Company) context.getBean("company");
		company.Button(); // Call Crud Application Method
	}
}
