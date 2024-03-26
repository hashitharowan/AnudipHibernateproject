package com.car.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.entities.Rental;

public class RentaldaoImpl  implements Rentaldao {

		private Session session;

		public RentaldaoImpl(Session session) {
			super();
			this.session = session;
		}
		
		public void insert(Rental robj)
		{
			try {
				Transaction tx = session.beginTransaction();  
				session.save(robj);
				tx.commit();
				System.out.println(robj);
				System.out.println("Record inserted into Rental table");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void update(int rentalid,String rentalDate,String rentalTime,String returnDate,String returnTime)
		{
			try {
			
			Rental robj = session.find(Rental.class, rentalid);
				if (robj == null)
					System.out.print("Record not found");
				else {
				robj.setRentalDate(rentalDate);
				robj.setRentalTime(rentalTime);
				robj.setReturnDate(returnDate);
				robj.setReturnTime(returnTime);
					
					Transaction tx = session.beginTransaction();
					session.merge(robj);
			      	tx.commit();
					System.out.println(robj);
					System.out.println("Record updated into Rental table");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void search(int rentalid)
		{
			try
			{
				Rental robj = session.find(Rental.class, rentalid);
				if (robj == null)
					System.out.print("Record not found");
				else
					System.out.println(robj);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public List<Rental> select()
		{
			Transaction tx = session.beginTransaction();
			Query qobj = session.createQuery("select robj from Rental robj");
			@SuppressWarnings("unchecked")
			List<Rental> list = (List<Rental>) qobj.getResultList();
			tx.commit();
		    return list;
		}
		
}
