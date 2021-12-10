package com.finance.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.Model.ProductHistory;
import com.finance.Repository.ProductHistoryRepository;
@Service
@Transactional
public class ProductHistoryServiceImpl implements ProductHistoryService {
	@Autowired
	ProductHistoryRepository prodhistRepo;
	@Override
	public boolean addProduct(ProductHistory prodhist) {
		prodhistRepo.save(prodhist);//inserts
		return true;
	}
	@Override
	public List<ProductHistory> viewProduct() {
		// TODO Auto-generated method stub
		return prodhistRepo.findAll();

	}

}
