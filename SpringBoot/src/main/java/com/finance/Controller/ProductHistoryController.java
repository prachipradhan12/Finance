package com.finance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.Model.ProductHistory;
import com.finance.Service.ProductHistoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
@RequestMapping("/producthistory/api")
public class ProductHistoryController {
	@Autowired
	ProductHistoryService prodhistService;
	@PostMapping("/ph")
	public boolean addProduct(@RequestBody ProductHistory prodhist) {
		return prodhistService.addProduct(prodhist);
				
	}
	@GetMapping("/ph")
	public List<ProductHistory> getAll(){
		return prodhistService.viewProduct();
	}
	
}
