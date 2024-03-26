package com.car;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.car.Dao.Cardao;
import com.car.Dao.CardaoImpl;
import com.car.entities.Admin;
import com.car.entities.Car;
	

	public class Carcrud {
					
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=meta.getSessionFactoryBuilder().build();	// Create a SessionFactory object
		Session session=sf.openSession();
		Scanner sc = new Scanner(System.in);
		Admin aobj=new Admin();
	Cardao cardao = new CardaoImpl(session);

		public void insert() {
			
			System.out.println("==Enter car details==");   
			 System.out.print("Enter car Number: ");
		    int carno = sc.nextInt();
			
	        System.out.println(" Enter car Name: ");
	        String carName = sc.next();
	        sc.nextLine();
	       
	        System.out.println("Enter car model: ");
	        String model = sc.nextLine();
	        
	        System.out.print("Enter capacity ");
	        int capacity = sc.nextInt();
	        	        
	        System.out.print("Enter price ");
	        int price = sc.nextInt();
	        
	        System.out.print("Is car available? (yes/no): ");
	        String status = sc.next();
	        
	        Car crobj = new Car();

	        crobj.setCarno(carno);
	        crobj.setCarName(carName);
	        crobj.setModel(model);
	        crobj.setCapacity(capacity);
	        crobj.setPrice(price);
	        crobj.setStatus(status);
	        cardao.insert(crobj);
	        crobj.setAobj(aobj);
		}
		/*
		public void update() {
	        System.out.println("Enter the Car ID to update details:");
	 int carid= sc.nextInt();

	        // Check if the car with the given ID exists
	        Car crobj =  session.find(Car.class, carid);

	        if (crobj != null) {
	            System.out.println("Enter updated car details:");
	            System.out.print("Enter car Number: ");
	            int carno = sc.nextInt();
	            System.out.print("Enter car Name: ");
	            String carName = sc.nextLine();
	            System.out.print("Enter car model: ");
	            String model = sc.nextLine();
	            System.out.print("Enter car capacity: ");
	            int capacity = sc.nextInt();
	            System.out.print("Enter car price: ");
	            int price = sc.nextInt();
	            System.out.print("Enter  Car Status): ");
	            String status = sc.nextLine();
	            
	            System.out.print("Is car available? (yes/no): ");
	            String status1 = sc.next();
	            sc.nextLine(); // Consume newline character

	            // Call updateCarDetails method from CarDAO
	            cardao.update(carid, carno, carName, model, capacity, price,status);

	            System.out.println("Car details updated successfully.");
	        } else {
	            System.out.println("Car with ID " + carid+ " not found.");
	        }
	    }
*/		
		public void Display() 
		{
	        List<Car> allCars = cardao.Display ();

	        if (allCars != null && !allCars.isEmpty())
	        {
	            System.out.println("All Car Details:");

	            for (Car crobj : allCars) 
	            {
	            	System.out.println("-----------------------------");
	                System.out.print("Car ID: " + crobj.getCarid());
	                System.out.print("Car no: " + crobj.getCarno());
	                System.out.print("Car Name: " + crobj.getCarName());
	                System.out.print("Car Model: " + crobj.getModel());
	                System.out.print("Car capacity: " + crobj.getCapacity());
	                System.out.print("Car  status : " + crobj.getStatus());
	            	System.out.println("-----------------------------");
	            	
	            }
	        } else 
	        {
	            System.out.println("No cars found.");
	        }
		}

		public void Search() {
	        System.out.println("Enter the Car ID to retrieve details:");
	     
	        String carid = sc.nextLine();

	        Car crobj =  session.find(Car.class, carid);

	        if (crobj != null) {
	            System.out.println("Car Details for ID " + carid + ":");
	            System.out.println("Car ID: " + crobj.getCarid());
	            System.out.println("Car no: " + crobj.getCarno());
                System.out.println("Car Name: " + crobj.getCarName());
                System.out.println("Car Model: " + crobj.getModel());
                System.out.println("Car capacity: " + crobj.getCapacity());
                System.out.println("Car  status : " + crobj.getStatus());
                System.out.println("---------");
	           
	            
	        } else {
	            System.out.println("Car with ID " + carid + " not found.");
	        }
	    }
		
	public void delete() {
		   System.out.println("Enter the Car ID to delete:");
	        int carid = sc.nextInt();
	        Car crobj =  session.find(Car.class, carid);
	        if (crobj != null) {
	        	cardao.delete(carid);
	        	 System.out.println("car details deleted succesfuly");
	        }
	        else
	        {
	        	 System.out.println("Enter the Car ID not Found:");
	        }
	}
	   }
