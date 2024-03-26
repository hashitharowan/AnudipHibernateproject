package com.car;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.hibernate.Session;

import com.car.Dao.Admindao;
import com.car.Dao.AdmindaoImpl;
import com.car.Dao.Cardao;
import com.car.Dao.CardaoImpl;
import com.car.Dao.Customerdao;
import com.car.Dao.CustomerdaoImpl;
import com.car.Dao.Logindao;
import com.car.Dao.LogindaoImpl;
import com.car.Dao.Paymentdao;
import com.car.Dao.PaymentdaoImpl;
import com.car.Dao.Registrationdao;
import com.car.Dao.RegistrationdaoImpl;
import com.car.Dao.Rentaldao;
import com.car.Dao.RentaldaoImpl;
import com.car.entities.Admin;
import com.car.entities.Car;
import com.car.entities.Customer;
import com.car.entities.Login;
import com.car.entities.Payment;
import com.car.entities.Registration;
import com.car.entities.Rental;
import com.car.utils.CarUtils;


public class Menu {

//	org.hibernate.SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//	org.hibernate.Session session = factory.openSession();
	
	Logindao logindao;
	Admindao admindao; 
	Customerdao ciobj;
	Cardao cardao ;
	Rentaldao rentalDao;
	Paymentdao paymentDao ;
	Registrationdao registationDao;
	
	private Session session;
	public Menu(Session session) {
		super();
		this.session = session;
	 logindao=new LogindaoImpl(session);
		 admindao = new AdmindaoImpl(session); 
		 ciobj=new CustomerdaoImpl(session);
		 cardao = new CardaoImpl(session);
		 rentalDao = new RentaldaoImpl(session);
		paymentDao = new PaymentdaoImpl(session);
		 registationDao=new RegistrationdaoImpl(session);
	}

	Carcrud crud=new Carcrud();
	Scanner scanner=new Scanner(System.in);

	
	Admin aobj = new Admin();
	
	public void createAdminAccount() {
		try {
			System.out.println("***** Admin Registration *****");
			System.out.println("Enter Admin details");
			System.out.print("Enter admin name: ");
			String name = scanner.next();
			System.out.print("Enter username: ");
			String username = scanner.next();
			System.out.print("Enter your password: ");
			String password = scanner.next();
			System.out.println("Enter your Contact: ");
			String contact = scanner.next();
		
			aobj.setName(name);
			aobj.setPassword(password);
			aobj.setUsername(username);
			aobj.setContact(contact);	
						
			Registration reobj = new Registration();	
			aobj.setReobj(reobj);
			reobj.setAobj(aobj);
			admindao.addAdmin(aobj);
			System.out.println(aobj);
			System.out.println(reobj);
			System.out.println("Admin Registration successful!");
		} catch (Exception e) {
			System.out.println("Admin Registration failed. Please try again.");
			e.printStackTrace();
		}
	}

	public void login() {
		System.out.println("*****  LOGIN *****");
		System.out.println("Enter username:");
		String username = scanner.next();
		System.out.println("Enter Password:");
		String password = scanner.next();

		// Use AdminDAO to fetch admin details by username
		Admin aobj = admindao.getLoginByusernameAndpassword(username, password);
		System.out.println(aobj);

		if (aobj == null) 
		{
			System.out.println("Login failed. Invalid username or password.");
		}
		else 
			{
			logindao.addLoginByusernameAndpassword(aobj);
				System.out.println("Admin login successful!");
				Login lobj=new Login();
				lobj.setAobj(aobj);
			;
      		Adminmenu();
      		
		}
	}
// rentalObj,customerObj,payment
	
	public void  rentCar()
	{ 
		try
		{
		Customer cobj = customerDetails();
		Rental robj = rentalDetails();
		Payment pobj = paymentdetails(robj);
		System.out.print(pobj.toString());
		ciobj.insert(cobj);
		rentalDao.insert(robj);
		paymentDao.insert(pobj);
			pobj.setRobj(robj);
	} catch (Exception e) {
		System.out.println("Back to Admin Menu");
		e.printStackTrace();
	}
}

	public Customer customerDetails() {
		System.out.println("************** Create New Customer Account ************");

		System.out.println("Enter customer details");
		 scanner.nextLine();
		System.out.println("Enter customer name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter customer address: ");
		String address = scanner.nextLine();

		System.out.println("Enter customer Pancardno: ");
		String panCardNo = scanner.nextLine();

		System.out.println("Enter customer Contact: ");
		String contact = scanner.nextLine();

		System.out.println("Enter your licenseNo: ");
		String licenseno = scanner.nextLine();

		Customer cobj= new Customer();
		cobj.setName(name);
		cobj.setAddress(address);
		cobj.setPanCardNo(panCardNo);
		cobj.setContact(contact);
		cobj.setLicenseno(licenseno);
		cobj.setAobj(aobj);
		return cobj;
			}

	public Rental rentalDetails() {
		System.out.println(" Enter the Rental, car  and customer Details ");
		System.out.print(" Enter Car id ");
		int carid=scanner.nextInt();
		Car crobj = cardao.getbycarid(carid);
		System.out.print(" Enter Rental Date(yyyy-mm-dd)  ");
		String rentalDate=scanner.next();

		System.out.print(" Enter Rental Time (hh:mm:ss) ");
		String rentalTime=scanner.next();

		System.out.print(" Enter Return Date (yyyy-mm-dd)  ");
		String returnDate=scanner.next();

		System.out.print(" ReturnTime  (hh:mm:ss)");
		String returnTime=scanner.next();
		
		Rental robj=new Rental();
		robj.setRentalDate(rentalDate);
		robj.setRentalTime(rentalTime);
		robj.setReturnDate(returnDate);
		robj.setReturnTime(returnTime);
		robj.setCrobj(crobj);
		return robj;

	}

	public Payment paymentdetails(Rental robj) {
		Payment pobj = new Payment();
		LocalDateTime rentalDateTime = CarUtils.convertStringToDate(robj.getRentalDate(), robj.getRentalTime());
		LocalDateTime returnDateTime = CarUtils.convertStringToDate(robj.getReturnDate(), robj.getReturnTime());
		int  rentedHours = CarUtils.getRentedHours(rentalDateTime,returnDateTime);
		pobj.setDate(CarUtils.getCurrentDate());
		int totalPayment = rentedHours * robj.getCrobj().getPrice();
		pobj.setAmount(totalPayment);
		pobj.setRobj(robj);
		return pobj;
		
	}

	public void Adminmenu(){
			System.out.println(" Welcome to Admin Side");
		System.out.println("1) View Cars");
		System.out.println("2)  Add cars");
		System.out.println("3) rental cars");
		System.out.println("4)  Delete cars");		
		System.out.println("5) Exit to main menu ");
		System.out.println(" Enter  the choice ");
		int  ch=scanner.nextInt();
		switch (ch) {
		case 1:
			System.out.println(" Display  Car details ");	
			crud.Display();
			Adminmenu();
			break;
		case 2: 
			System.out.println(" Add  Car details ");	
			crud.insert();
			Adminmenu();
		case 3:
			System.out.println(" Rent the Car");
			rentCar();
			Adminmenu();
			break;
		case 4:
			System.out.println(" Delete the Car");
			crud.delete();
			Adminmenu();
			break;
			case 5:
				System.out.print(" Return to main page ");
				System.exit(0);
				break;
		default:
			break;
		}
	}

}
