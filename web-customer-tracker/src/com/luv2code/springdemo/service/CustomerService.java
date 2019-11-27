package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService 
{
	public List<Customer> getCustomers();

	public void saveCustomers(Customer customer);

	public Customer fetchCustomer(int initid);

	public void deleteCustomer(int initid);

	public List<Customer> getSearch(String theSearchName);

}
