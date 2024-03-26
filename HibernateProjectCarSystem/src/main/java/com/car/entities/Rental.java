package com.car.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "RENTAL")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rentalid;

	private String  rentalDate;
	private String rentalTime;
	private String returnDate;
	private String returnTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carid")
	private Car crobj;
/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")
	private Customer cobj;
*/	
//	@OneToMany(cascade = CascadeType.ALL) 
//	@JoinColumn(name = "paymentid")
//		private Payment pobj;
	
	
	public Rental() {
		super();
	}

		public int getRentalid() {
		return rentalid;
	}

	public void setRentalid(int rentalid) {
		this.rentalid = rentalid;
	}

	public String getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getRentalTime() {
		return rentalTime;
	}

	public void setRentalTime(String rentalTime) {
		this.rentalTime = rentalTime;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public Car getCrobj() {
		return crobj;
	}

	public void setCrobj(Car crobj) {
		this.crobj = crobj;
	}
	/*
	public Customer getCobj() {
		return cobj;
	}

	public void setCobj(Customer cobj) {
		this.cobj = cobj;
	}
*/
//	public Payment getPobj() {
//		return pobj;
//	}
//
//	public void setPobj(Payment pobj) {
//		this.pobj = pobj;
//	}
	

	@Override
	public String toString() {
		return "Rental [rentalid=" + rentalid + ", rentalDate=" + rentalDate + ", rentalTime=" + rentalTime
				+ ", returnDate=" + returnDate + ", returnTime=" + returnTime + ", crobj=" + crobj + "]";
	}


	
}
