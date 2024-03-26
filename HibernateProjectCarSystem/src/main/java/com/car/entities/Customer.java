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
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int customerid;

    private String name;
    private String address;
    private String panCardNo;
    private String contact;
      private String licenseno;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Adminid") 
    private Admin aobj; 

	/*
   @ManyToMany( cascade = CascadeType.ALL,mappedBy = "cobj")
    private List<Car> crobj = new ArrayList<Car>();
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy="robj") 
	private List<Rental> rentals;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="cobj") 
	private List<Payment> pobj=new ArrayList<Payment>();
*/
	public Customer() {
		super();
		
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLicenseno() {
		return licenseno;
	}

	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}

	public Admin getAobj() {
		return aobj;
	}

	public void setAobj(Admin aobj) {
		this.aobj = aobj;
	}
	
	/*

//	public List<Car> getCrobj() {
//		return crobj;
//	}

//	public void setCrobj(List<Car> crobj) {
//		this.crobj = crobj;
//	}
	/*
public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public List<Payment> getPobj() {
		return pobj;
	}

	public void setPobj(List<Payment> pobj) {
		this.pobj = pobj;
	}
*/

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", name=" + name + ", address=" + address + ", panCardNo="
				+ panCardNo + ", contact=" + contact + ", licenseno=" + licenseno + ", aobj="+aobj+  "]";
	}
	
}

