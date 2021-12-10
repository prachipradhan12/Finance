package com.finance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.Model.EmiCard;
import com.finance.Service.EmiCardService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/emicardRest/api")
public class EmiCardController {
	@Autowired
	EmiCardService emicardservice;
	
	@GetMapping("/cards")
	public List<EmiCard> getAllEmiCard(){
		return emicardservice.getAllEmiCard();
	}
	@PostMapping("/cards")
	public boolean addEmiCard( @RequestBody  EmiCard emiCard) {
		return emicardservice.addEmiCard(emiCard);
	}

}
