package com.car.Dao;

import com.car.entities.Admin;

public interface Logindao
 {
    void getLoginById(int loginid);
    void getLoginByusernameAndpassword(String username, String password);
        void addLoginByusernameAndpassword(Admin lobj);
}