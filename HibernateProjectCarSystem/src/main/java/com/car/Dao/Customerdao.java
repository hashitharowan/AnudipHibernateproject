package com.car.Dao;

import java.util.List;

import com.car.entities.Customer;

public interface Customerdao {
	void insert(Customer  cobj);// insert
	void update(int customerid,String name,String  address,String pancardno,String contact,String liscenseno);//update
	List<Customer> select();//select
	void search(int customerid);//retrieve
}
