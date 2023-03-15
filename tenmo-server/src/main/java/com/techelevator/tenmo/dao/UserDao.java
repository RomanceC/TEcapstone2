package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;

import java.util.List;

public abstract class UserDao {

    public abstract List<User> findAll();

    public abstract List<User> findAllExceptCurrentUser(String name);

    public abstract User findByUsername(String username);

    public abstract int findIdByUsername(String username);

    public abstract boolean create(String username, String password);
}
