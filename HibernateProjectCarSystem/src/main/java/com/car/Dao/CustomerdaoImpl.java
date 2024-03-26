package com.car.Dao;

import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.entities.Customer;

public class CustomerdaoImpl  implements Customerdao
{
	private Session session;

	public CustomerdaoImpl(Session session) {
		super();
		this.session = session;
	}
	public void insert(Customer cobj)
	{
		try {
			Transaction tx = session.beginTransaction();  
			session.save(cobj);
			tx.commit();
			System.out.println(cobj);
			System.out.println("Record inserted into Customer table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(int customerid,String name,String  address,String pancardno,String contact,String liscenseno)
	{
		try {
			Customer cobj = session.find(Customer.class, customerid);
			if (cobj == null)
				System.out.print("Record not found");
			else {
				cobj.setName(name);
				cobj.setAddress(address);
				cobj.setPanCardNo(pancardno);
				cobj.getContact();
				cobj.setLicenseno(liscenseno);
				
				Transaction tx = session.beginTransaction();
				session.merge(cobj);
		      	tx.commit();
				System.out.println(cobj);
				System.out.println("Record updated into Customer table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search(int customerid)
	{
		try
		{
			Customer cobj = session.find(Customer.class, customerid);
			if (cobj == null)
				System.out.print("Record not found");
			else
				System.out.println(cobj);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<Customer> select()
	{
		Transaction tx = session.beginTransaction();
		Query qobj = session.createQuery("select cobj from Customer cobj");
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) qobj.getResultList();
		tx.commit();
	    return list;
	}
}
