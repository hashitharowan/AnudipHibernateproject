package com.car.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.entities.Car;


public class CardaoImpl  implements Cardao {

	private Session session;

	public CardaoImpl(Session session) {
		super();
		this.session = session;
	}
	public void insert(Car  crobj)
	{
		try {
			Transaction tx = session.beginTransaction();  
			session.save(crobj);
			tx.commit();
			System.out.println(crobj);
			System.out.println("Record inserted into Car table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Car>Display()
	{
		Transaction tx = session.beginTransaction();
		Query qobj = session.createQuery("select crobj from Car crobj");
		@SuppressWarnings("unchecked")
		List<Car> list = (List<Car>) qobj.getResultList();
		tx.commit();
	    return list;
	}		
	
	public  Car getbycarid(int carid) {
	    try {
	        return session.createQuery("FROM Car WHERE carid =: carid ", Car.class)
	        		.setParameter("carid", carid)
	                .uniqueResult();
	    } catch (Exception e) {
	        System.out.println("Error retrieving Price Details: " + e.getMessage());
	        return null;
	    }
	}
	public void delete(int carid)
	{
		try
		{
		Car crobj = session.find(Car.class,carid);// Find the Student object by its ID
			if (crobj == null)// Check if the record exists
				System.out.print("Record not found");
			else {
				Transaction tx = session.beginTransaction();
				session.remove(crobj);   // Remove the Student object from the database
				tx.commit();
				System.out.println(crobj); // Print the deleted Student object and a message
				System.out.println("Record deleted from student table");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

	/*
	
	public void update(int carid, int carno, String carName, String model, int capacity, int price, String status)
	{
		try {
		
			Car crobj = session.find(Car.class, carid);
			if (crobj == null)
				System.out.print("Record not found");
			else {
				crobj.setCarName(carName);;
				crobj.setCarno(carno);
				crobj.setModel(model);
				crobj.setCapacity(capacity);
				crobj.setPrice(price);
				crobj.setStatus(status);
				
				Transaction tx = session.beginTransaction();
				session.merge(crobj);
		      	tx.commit();
				System.out.println(crobj);
				System.out.println("Record updated into Car table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search(int carid)
	{
		try
		{
			Car crobj = session.find(Car.class, carid);
			if (crobj == null)
				System.out.print("Record not found");
			else
				System.out.println(crobj);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	











