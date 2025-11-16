package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Employee;
import com.repository.EmpRepo;

@Service
public class Empservice {
	
	@Autowired
	EmpRepo repo;
	
	public boolean saveEmp(Employee e) {
//		System.out.println("Name "+e.getName()+" Email "+e.getEmail()+" Contact "+e.getContact());
		return repo.saveInDB(e);
	}
	public List<Employee> searchEmp(String name) {
//		System.out.println("Name:  "+name);
		return repo.searchEmp(name);
	}
	public boolean deleteEmp(int id) {
//		System.out.println(id);
		return repo.deleteEmployee(id);
	}
	public boolean updateEmp(int id,Employee e) {
//		System.out.print("ID: "+id);
//		System.out.println(" Name "+e.getName()+" Email: "+e.getEmail()+" Contact: "+e.getContact());
		return repo.updateEmpById(id,e);
		
	}
	public List<Employee> showEmployee(){
		return repo.showEmp();
	}

}
