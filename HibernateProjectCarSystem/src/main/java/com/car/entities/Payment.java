package com.car.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentid;

	private int Amount;
	private String date;
	private int additionalcharges;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rentalid")
	private Rental robj;
	
	/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")
	private Customer cobj;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminid")
	private Admin aobj;
*/
	public Payment() {
		super();
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

		public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAdditionalcharges() {
		return additionalcharges;
	}

	public void setAdditionalcharges(int additionalcharges) {
		this.additionalcharges = additionalcharges;
	}

	public Rental getRobj() {
		return robj;
	}

	public void setRobj(Rental robj) {
		this.robj = robj;
	}
	/*
	public Customer getCobj() {
		return cobj;
	}

	public void setCobj(Customer cobj) {
		this.cobj = cobj;
	}

	public Admin getAobj() {
		return aobj;
	}

	public void setAobj(Admin aobj) {
		this.aobj = aobj;
	}
*/
	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", Amount=" + Amount + ", date=" + date + ", additionalcharges="
				+ additionalcharges + ", robj="+robj+ "]";
	}
}