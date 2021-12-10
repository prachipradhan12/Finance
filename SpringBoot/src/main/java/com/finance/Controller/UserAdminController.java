package com.finance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.Model.CardDetails;
import com.finance.Model.User;
import com.finance.Service.AuthenticateUserService;
import com.finance.Service.CardDetailsService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/UserDetailsRest/api")

public class UserAdminController {
	
	@Autowired
	AuthenticateUserService adService;
	@Autowired
	CardDetailsService cdService;
	@GetMapping("/userDetails")
	public List<User> getAll(){
		return adService.getUserdetails();
	}
	@GetMapping("/userDetails/{regid}")
	public User getUserById(@PathVariable(value = "regid") long regid) {
		return adService.findUser(regid);
		
	}
	@PostMapping("/userDetails")
	public boolean addUser(@RequestBody User user) {
	return adService.addUser(user);
	}
	
	@PutMapping("/userDetails/{regid}")
	public boolean updateuserById(@PathVariable(value="regid") long regid) {
		return adService.updateUser(regid);
	}
	@DeleteMapping("/userDetails/{regid}")
	public boolean deleteUser(@PathVariable(value="regid") long regid) {
		return adService.deleteUser(regid);
		//return prodService.deleteProduct(product);
	}
	@DeleteMapping("/userDetails")
	public boolean deleteUser(@RequestBody User user, long regid) {
		return adService.deleteUser(regid);
	}
	@GetMapping("/cardDetails")
	public List<CardDetails> getAllCards(){
		return cdService.getCarddetails();
	}
	@GetMapping("/cardDetails/{regid}")
	public CardDetails getCardById(@PathVariable(value = "regid") long regid) {
		return cdService.findCard(regid);
		
	}
	@PostMapping("/cardDetails")
	public boolean addCard(@RequestBody CardDetails card) {
		
	return cdService.addCard(card);
	}
	
	@PutMapping("/cardDetails/{regid}")
	public boolean updatecardById(@PathVariable(value="regid")long regid) {
		return cdService.updateCard(regid);
	}
	@DeleteMapping("/cardDetails/{regid}")
public boolean deleteCard(@PathVariable(value="regid") long regid) {
	return cdService.deleteCard(regid);
	//return prodService.deleteProduct(product);
	}
	

}
