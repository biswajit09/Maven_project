package com.legato.service;

import java.util.List;

import com.legato.demo.pojo.User;

public interface UserService {
	
	public User saveUser(User user);

	public User getUserById(Integer id);

	public User updateUser(User user);

	public void deleteUserById(Integer id);

	List<User> getAlluser(User user);




}
