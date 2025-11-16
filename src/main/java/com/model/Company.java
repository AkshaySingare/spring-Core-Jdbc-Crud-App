package com.model;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.Empservice;

@Component
public class Company {
	Scanner sc = new Scanner(System.in);

	@Autowired
	Empservice service; // Empservice Class reference

	public void Button() {
		System.out.println("------ Select CRUD Operation On Employee -----");
		System.out.println("\n 1.Add \n 2.Search \n 3.Update \n 4.Delete \n 5.ShowEmployee ");
		int button = sc.nextInt();
		sc.nextLine(); // consume leftover newline

		switch (button) {

		case 1: // Save Employee In Database
			if (service.saveEmp(AddEmp()))
				System.out.println("Employee Saved..."); // pass object to service
			else
				System.out.println("Employee Failed...");

			break;

		case 2: // Search Employee Using Name
			System.out.println("Enter Employee Name ");
			List<Employee> list = service.searchEmp(sc.next());

			Iterator<Employee> i = list.iterator();
			System.out.println("Id \t Name \t Email \t\t Conatct");
			while (i.hasNext()) {
				Employee e = i.next();
				System.out.println(e.getId() + " \t " + e.getName() + " \t " + e.getEmail() + " \t " + e.getContact());
			}
			break;

		case 3: // Update Employee Using Id
			System.out.print("Enter Employee Id For change data");
			int id = sc.nextInt();
			sc.nextLine();
			if (service.updateEmp(id, AddEmp())) {

				System.out.println("Updated Successfully...\n Doyou Want See Data click y if not click n ");
				int val = sc.next().charAt(0);
				if (val == 'y' || val == 'Y') {
					showAllEmp();
				}
				// Called Function
			} else
				System.out.println("Failed Updation...");
			break;

		case 4: // Employee Deletion using Id
			System.out.println("Enter Employee Id");
			if (service.deleteEmp(sc.nextInt()))
				System.out.println("Deleted...");
			else
				System.out.println("Failed Deletion...");
			break;

		case 5:
			showAllEmp();
			break;
		default:
			System.out.println("Option not implemented yet.");
			break;
		}
	}

	public Employee AddEmp() { // This method takes input and returns Employee object
		System.out.println("Enter Name: ");
		String name = sc.nextLine();

		System.out.println("Enter Email: ");
		String email = sc.nextLine();

		System.out.println("Enter Contact: ");
		String contact = sc.nextLine();

		return new Employee(name, email, contact);

	}

	public void showAllEmp() {

		List<Employee> list = service.showEmployee();

		Iterator<Employee> i = list.iterator();

		System.out.println("Id \t Name \t Email \t\t Conatct");
		while (i.hasNext()) {
			Employee e = i.next();
			System.out.println(e.getId() + " \t " + e.getName() + " \t " + e.getEmail() + " \t " + e.getContact());
		}
	}
}
