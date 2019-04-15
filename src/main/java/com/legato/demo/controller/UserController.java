package com.legato.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.legato.demo.pojo.User;
import com.legato.service.UserService;



@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody User User) {
		User e = userService.saveUser(User);
		ResponseEntity<User> res = new ResponseEntity<User>(e,HttpStatus.OK);
		return res;
	}
	
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Integer id) {
		User e = userService.getUserById(id);
		ResponseEntity<User> res = new ResponseEntity<User>(e,HttpStatus.OK);
		return res;
	}
  
	//@GetMapping("")
	@RequestMapping(value = "/getAllEmp", method = RequestMethod.GET)
	public List<User> getAllEmp() {
		User usr=new User();
        return userService.getAlluser(usr);
    
	}
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable ("id")Integer id, @RequestBody User User) {
		User e = userService.updateUser(User);
		if(User!=null) {
		return new  ResponseEntity<User>(User,HttpStatus.OK);
		}
		else {
			return new  ResponseEntity<String>("Details not found",HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteUser(@PathVariable ("id")Integer id) {
		userService.deleteUserById(id);
		return ResponseEntity.ok("Deleted Successfully");
	}
	
}
