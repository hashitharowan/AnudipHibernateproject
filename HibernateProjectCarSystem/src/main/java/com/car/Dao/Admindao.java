package com.car.Dao;

import com.car.entities.Admin;

public interface Admindao {

	//void insert(Admin aobj);// insert
	//void update(int adminid,String name,String username,String password,String contact);//update
	  
	
	Admin getAdminById(int adminid);
  Admin getAdminByusernameAndpassword(String username, String password);
	   void addAdmin(Admin aobj);
	   void updateAdmin(Admin aobj);
	    void deleteAdmin(int adminid);
		Admin getLoginByusernameAndpassword(String username, String password);	

}
