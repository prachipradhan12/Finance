package com.finance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.Model.NamePass;
import com.finance.Model.User;
import com.finance.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/userRest/api")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/userfind/{uname}")
	public User finUserByUname(@PathVariable(value="uname") String uname) {
		return userService.findUserByUname(uname);
	}
	
	@GetMapping("/user")
	public List<User> findAllUser() {
		return userService.getAllUsers();
	}

	@PostMapping("/user")
	public boolean addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	@GetMapping("/userexists/{uname}")
	public boolean findUserExists(@PathVariable(value="uname") String uname) {
		User u=null;
		u=userService.findUserByUname(uname);
		if(u!=null) {
			return true;
		}
		return false;
	}
	@GetMapping("/uservalidate/{uname}/{upass}")
	public int validateUser(@PathVariable(value="uname") String uname,@PathVariable(value="upass") String upass) {
		User u;
		u=userService.findUserByUname(uname);
		if(u==null) {
//			username does not exist
			return 1;
		}
		else if(u.getUpass().equals(upass)) {
//			correct password
			return 2;
		}
//		wrong credentials
		return 3;
	}
	
	@PutMapping("/changepass")
	public boolean changePass(@RequestBody NamePass namepass) {
		User u;
		System.out.println(namepass.getName());
		System.out.println(namepass.getPassword());
		u=userService.findUserByUname(namepass.getName());
		u.setUpass(namepass.getPassword());
		userService.addUser(u);
		return true;
	}
	@GetMapping("/getId/{uname}")
	public long findIdByUname(@PathVariable(value="uname") String uname) {
		User u=null;
		u=userService.findUserByUname(uname);
		return u.getRegid();
		
	
	}
}
