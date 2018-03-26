package com.cms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.User;
import com.cms.service.UserService;


@RestController
public class CmsRestController {

	@Autowired UserService userService;
	
	@PostMapping("/addUser")
	public void addUser(User user) {
		 userService.saveUser(user);
	}
	
	
	@GetMapping("/findAllUsers")
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	/*	@PostMapping("/findByOne")
	public List<CarDetail> findByOne(@RequestBody Map carId){
		return carDetailsService.findByOne(carId.get("carId").toString());
	}*/
	
	@PostMapping("/findUserById")
	public User findUserById(@RequestParam int id) {
		return userService.findUserById(id);
	}
	
	@PostMapping("/findUserByEmail")
	public User findUserByEmail(String email) {
		return userService.findUserByEmail(email);
	}
	
}

















