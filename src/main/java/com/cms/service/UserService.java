package com.cms.service;

import java.util.List;

import com.cms.entity.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public User createUser(User user);
	public List<User> findAllUsers();
	public User findUserById(int id);

}
