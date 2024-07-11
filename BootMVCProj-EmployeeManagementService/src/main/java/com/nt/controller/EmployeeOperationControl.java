package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeOperationControl {
	
	@Autowired
	private IEmployeeMgmtService empService;
	@Autowired
	private EmployeeValidator empValidator;
	
	@GetMapping("/")
	public String showHomePage() {
		//return LVN
		return "welcome";
	}
	
	@GetMapping("/report")
	public String fetchAllEmployees(Map<String, Object> map) {
		System.out.println("EmployeeOperationControl.fetchAllEmployees()");
		//use service
		Iterable<Employee> it=empService.showAllEmployees();
		//keeps the result in Model class attributes
		map.put("empList", it);
		//return LVN
		return "show_report";
	}
	
	@GetMapping("emp_add")		//for form launching
	public String showFormForSaveEmployee(@ModelAttribute("emp")Employee emp) {
		//return lvn
		return"register_employee";
	}
	
	/*	@PostMapping("emp_add")     //for form submission
		public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
			//use services
			String msg= empService.registerEmployee(emp);
			Iterable<Employee> itEmps=empService.showAllEmployees();
			//keep the result in model attributes
			map.put("empList", itEmps);
			map.put("resultMsg", msg);
			//return lvn
			return "show_report";
		}*/
	
	
	/*	@PostMapping("emp_add")     //for form submission with PGR Pattern
		public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
			System.out.println("EmployeeOperationControl.saveEmployee()");
			//use services
			String msg= empService.registerEmployee(emp);
			//keep the result in model attributes
			map.put("resultMsg", msg);
			//return lvn
			return "redirect:report";
		}*/
	
		@PostMapping("emp_add")     //for form submission with PGR Pattern with Flash Attributes
		public String saveEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attr , BindingResult errors) {
			System.out.println("EmployeeOperationControl.saveEmployee()");
			
			// enabled server side form validation only when client side validation are not done
			if(emp.getCsvStatus().equalsIgnoreCase("disabled")){
				//perform form validation
				if(empValidator.supports(emp.getClass())) {
						empValidator.validate(emp, errors);
						if(errors.hasErrors())
							return "register_employee";
					}
			}
			//use services
			String msg= empService.registerEmployee(emp);
			//keep the result as flash attributes
			attr.addFlashAttribute("resultMsg",msg);
			//return lvn
			return "redirect:report";
		}
	
	/*	@PostMapping("emp_add")     //for form submission with PGR Pattern with HTTPSession
		public String saveEmployee(@ModelAttribute("emp") Employee emp,HttpSession ses) {
			System.out.println("EmployeeOperationControl.saveEmployee()");
			//use services
			String msg= empService.registerEmployee(emp);
			//keep the result as HTTPSession
			ses.setAttribute("resultMsg", msg);
			//return lvn
			return "redirect:report";    //PGR support
		}*/
		@GetMapping("/emp_edit")     //for launching form for edit
		public String showEditEmployeeFormPage(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp) {
			// use service
			Employee emp1=empService.fetchEmployeeById(no);
			// copy data
			BeanUtils.copyProperties(emp1, emp);
			// return lvn
			return "update_employee";
		}
		
		
		@PostMapping("/emp_edit")    // for form submissin of edit
		public String editEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp , BindingResult errors) {
			System.out.println("EmployeeOperationControl.editEmployee()"+emp.getCsvStatus());
			// enabled server side form validation only when client side validation are not done
			if(emp.getCsvStatus().equalsIgnoreCase("disabled")){
				//perform form validation
					if(empValidator.supports(emp.getClass())) {
						empValidator.validate(emp, errors);
						if(errors.hasErrors())
							return "update_employee";
					}
			}
			//user service
			String msg= empService.modifyEmployee(emp);
			// add the result message as a flash attributes
			attrs.addFlashAttribute("resultMsg",msg);
			//redirect the redirect
			return "redirect:report";
		}
		
		@GetMapping("/emp_delete")
		public String deleteEmployee(RedirectAttributes attrs, @RequestParam int no) {
			//use service
			String msg= empService.deleteEmployeeById(no);
			//keep the result in flash attributes
			attrs.addFlashAttribute("resultMsg",msg);
			//redirect the request
			return "redirect:report";
		}
}
