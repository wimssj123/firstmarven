package com.qianfeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianfeng.entity.Employee;
import com.qianfeng.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@RequestMapping("/add.do")
	public String addEmp(Employee emp){
		
		empService.addEmployee(emp);
		
		return "redirect:/list.do";
	}
	
	@RequestMapping("/list.do")
	public String listEmp(Model model){
		List<Employee> list = empService.findAllEemployee();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/delete.do")
	public String deleteEmp(int id){
		empService.deleteEmpById(id);
		
		return "redirect:/list.do";
	}
	
	@RequestMapping("/query.do")
	public String queryById(int id, Model model){
		Employee emp = empService.findEmpById(id);
		model.addAttribute("emp", emp);
		
		return "update";
		
	}
	
	@RequestMapping("/update.do")
	public String updateEmp(Employee emp){
		empService.updateEmp(emp);
		
		return "redirect:/list.do";
	}
	
}
