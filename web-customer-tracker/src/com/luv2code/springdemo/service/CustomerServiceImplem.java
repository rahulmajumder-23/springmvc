package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.DAO.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImplem implements CustomerService 
{
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomers(Customer customer) 
	{
		// TODO Auto-generated method stub
		customerDAO.saveCustomers(customer);
	}
    
	
	@Override
	@Transactional
	public Customer fetchCustomer(int initid) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(initid);
	}

	@Override
	@Transactional
	public void deleteCustomer(int initid) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(initid);
		
	}

	@Override
	@Transactional
	public List<Customer> getSearch(String theSearchName) {
		// TODO Auto-generated method stub
		return customerDAO.getSearch(theSearchName);
	}

}
