package com.luv2code.springdemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.DAO.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImplem implements CustomerDAO {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Customer> getCustomers() 
	{
		Session session = factory.getCurrentSession();
		Query<Customer> query= session.createQuery("from Customer",Customer.class);
		
		List<Customer> customers= query.getResultList();
		
		
		return customers;
	}

	@Override
	public void saveCustomers(Customer customer) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int initid) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Customer customer = session.get(Customer.class,initid);
		return customer;
	}

	@Override
	public void deleteCustomer(int initid) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", initid);
		query.executeUpdate();
		
		
	}

	@Override
	public List<Customer> getSearch(String theSearchName) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Query<Customer> query = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0)
		{
			query =session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            query.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		
		}
		else
		{
			query =session.createQuery("from Customer", Customer.class);
		}
		List<Customer> customers = query.getResultList();
		return customers;
	}

	
}
