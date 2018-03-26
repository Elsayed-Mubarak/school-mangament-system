package com.cms.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cms.entity.Role;
import com.cms.entity.User;
import com.cms.repository.RoleRepository;
import com.cms.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired UserRepository userRepository;

	@Autowired RoleRepository roleRepository;
	
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
	
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.getOne(1);
        System.out.println(Arrays.asList(userRole)+"Arrays.asList(userRole)");                               
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findById(id);
	}

}
