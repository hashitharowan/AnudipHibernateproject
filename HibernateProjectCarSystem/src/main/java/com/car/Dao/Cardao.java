package com.car.Dao;

import java.util.List;

import com.car.entities.Car;

public interface Cardao {

	void insert(Car crobj);
	List<Car> Display();
	
	/*void search(int carid);
	void update(int carid, int carno, String carName, String model, int capacity, int price, String status);
		*/
	void delete(int carid );
	public  Car getbycarid(int carid);
}

