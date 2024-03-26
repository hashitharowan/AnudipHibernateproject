package com.car.Dao;

import java.util.List;

import com.car.entities.Payment;

public interface Paymentdao {

	void insert(Payment pobj);// insert
	List<Payment> select();//select
	void search(int paymentid);//retrieve
	 public void getPaymentById(int paymentid);
	 }
