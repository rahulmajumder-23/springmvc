package com.luv2code.springdemo.DAO;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO 
{
	public List<Customer> getCustomers();

	public void saveCustomers(Customer customer);

	public Customer getCustomer(int initid);

	public void deleteCustomer(int initid);

	public List<Customer> getSearch(String theSearchName);

	
}
