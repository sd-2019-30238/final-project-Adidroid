package com.a2.springboot.web.Assignment2.Model.DAO;


import com.a2.springboot.web.Assignment2.Model.Data.User;

public interface UserDAOInterface extends CRUD<User> {

    User findByUsername(String username);
}
