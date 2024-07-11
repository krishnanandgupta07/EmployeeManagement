package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.entity.Employee;

@Component
public class EmployeeValidator implements Validator {
	
@Override
public boolean supports(Class<?> clazz) {
	System.out.println("EmployeeValidator.supports()");
	return clazz.isAssignableFrom(Employee.class);
}

@Override
	public void validate(Object model, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		Employee emp=(Employee)model;
		if(emp.getEname()==null || emp.getEname().equals("") || emp.getEname().length()==0)  //required rule
			errors.rejectValue("ename", "emp.name.required");
		else if(emp.getEname().length()<5 || emp.getEname().length()>=15)  //length rule
			errors.rejectValue("ename", "emp.name.length");
		
		if(emp.getJob()==null || emp.getJob().isBlank())  //required rule
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<5 || emp.getJob().length()>=10)  //length rule
			errors.rejectValue("job", "emp.job.length");
		
		if(emp.getSal()==null)  //required rule
			errors.rejectValue("sal", "emp.salary.required");
		else if(emp.getSal()<10000.0|| emp.getSal()>=200000.0)  //range rule
			errors.rejectValue("sal", "emp.salary.range");
		
		if(emp.getDeptno()==null)
			errors.rejectValue("deptno", "emp.deptno.required");
		else if(emp.getDeptno()<10 || emp.getDeptno()>=50)
			errors.rejectValue("deptno", "emp.deptno.range");
	}
}
