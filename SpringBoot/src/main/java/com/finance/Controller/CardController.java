package com.finance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.Model.CardDetails;
import com.finance.Service.CardDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
@RequestMapping("/cardapi")
public class CardController {
	@Autowired
	CardDetailsService cardService;
	@PutMapping("/updatebal/{regid}/{price}")
	public boolean updateBalance(@PathVariable(value="regid")int regid,@PathVariable(value ="price")int price) {
		
		return cardService.updateBalance(regid, price);
	}
	@GetMapping("/updatebal")
	public List<CardDetails> getAll(){
		return cardService.getProducts();
	}

}
