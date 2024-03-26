package com.car.Dao;

import java.util.List;

import com.car.entities.Rental;

public interface Rentaldao {

	void insert(Rental robj);// insert
	public void update(int rentalid,String rentalDate,String rentalTime,String returnDate,String returnTime);//update
	List<Rental> select();//select
	void search(int rentalid);//retrieve
	
}
