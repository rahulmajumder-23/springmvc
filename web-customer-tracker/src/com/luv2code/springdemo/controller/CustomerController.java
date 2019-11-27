package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	private CustomerService customerservice;
	 
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		List<Customer> customers= customerservice.getCustomers();
		model.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model model)
	{
		Customer customer= new Customer();
		model.addAttribute("customer",customer);
		return "customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("customer")Customer customer) 
	{
		customerservice.saveCustomers(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showCustomer(@RequestParam("customerId")int initid,Model model)
	{
		Customer customer = customerservice.fetchCustomer(initid);
		model.addAttribute("customer",customer);
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int initid,Model model)
	{
		customerservice.deleteCustomer(initid);
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/search")
	public String getSearch(@RequestParam("theSearchName")String theSearchName,Model model)
	{
		List<Customer> customers = customerservice.getSearch(theSearchName);
		model.addAttribute("customers",customers);
		return "one";
		
	}
	

}
