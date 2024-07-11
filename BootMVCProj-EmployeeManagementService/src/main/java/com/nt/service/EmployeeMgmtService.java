package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtService implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository  empRepo;
	
	@Override
	public Iterable<Employee> showAllEmployees() {
		
		return empRepo.findAll();
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		
		return "Employee is saved with id value ::"+empRepo.save(emp).getEmpno();
	}
 @Override
public Employee fetchEmployeeById(int id) {
	
	return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid number"));
}
 
@Override
public String modifyEmployee(Employee emp) {
	
	return "Employee is updated with employee having id value::"+empRepo.save(emp).getEmpno();
}
	@Override
	public String deleteEmployeeById(int eno) {
		empRepo.deleteById(eno);
		return eno+" employee id of Employee will be deleted ";
	}

}
