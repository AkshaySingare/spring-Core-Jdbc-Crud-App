package com.repository;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public class EmpRepo {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public boolean saveInDB(Employee e) { // Add EMployee Method 
		int val = jdbc.update("insert into Emp(id,name,email,contact) values('0',?,?,?)",new Object[] {e.getName(),e.getEmail(),e.getContact()});
	   return val>0?true:false;
	}
	
	public List<Employee> searchEmp(String name){
		List<Employee> list = jdbc.query("select *from Emp where name like ?",new Object[]{"%"+name+"%"},new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int  num) throws SQLException {

				Employee e = new Employee();
				
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setContact(rs.getString("contact"));
				
				return e;
			}
			
			
		});
		return list;
	}
	public boolean updateEmpById(int id,Employee e) { //Update Employee Method
		
		int val = jdbc.update("update Emp set name=?,email=?,contact=? where id=?",new Object[] {e.getName(),e.getEmail(),e.getContact(),id});
		return val>0?true:false;
	}
	
	public boolean deleteEmployee(int id) { //Delete Method
		return jdbc.update("delete from Emp where id=?",new Object[] {id})>0?true:false;
	}
	
	public List<Employee> showEmp(){ //Show All Employee Method
		
		List<Employee> list = jdbc.query("select *from Emp", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int num) throws SQLException {
				
				Employee e = new Employee();
				
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setContact(rs.getString("contact"));
				
				return e;
			}
		});
		return list;
	}
	

}
