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
@Table(name = "CAR")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carid;

	private int carno;
	private String carName;
	private String model;
	private int capacity;
	private int price;
	private String Status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Adminid") 
	private Admin aobj;

	/*
	@ManyToMany( cascade = CascadeType.ALL,mappedBy = "crobj")
 private List<Customer> cobj = new ArrayList<Customer>();
	*/
	public Car() {
		super();
	}

public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public int getCarno() {
		return carno;
	}

	public void setCarno(int carno) {
		this.carno = carno;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Admin getAobj() {
		return aobj;
	}

	public void setAobj(Admin aobj) {
		this.aobj = aobj;
	}

	/*
	
	public List<Customer> getCobj() {
		return cobj;
	}

	public void setCobj(List<Customer> cobj) {
	this.cobj = cobj;
	}
*/
	@Override
	public String toString() {
		return "Car [carid=" + carid + ", carno=" + carno + ", carName=" + carName + ", model=" + model + ", capacity="
				+ capacity + ", price=" + price + ", Status=" + Status + ",aobj="+ aobj+"]";
	}	
}