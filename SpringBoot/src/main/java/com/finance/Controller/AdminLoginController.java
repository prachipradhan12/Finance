package com.finance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.Model.AdminLogin;
import com.finance.Service.AdminLoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/adminRest/api")
public class AdminLoginController {
    @Autowired
    AdminLoginService adminloginservice;
    @GetMapping("/validate/{aname}/{apass}")
	public int validateAdmin(@PathVariable(value="aname") String aname,@PathVariable(value="apass") String apass) {
    	AdminLogin a;
    	a=adminloginservice.findAdmin(aname) ;
		if(a==null) {
//			username does not exist
			return 1;
		}
		else if(a.getApass().equals(apass)) {
//			correct password
			return 2;
		}
//		wrong credentials
		else
		return 3;
	}
}
