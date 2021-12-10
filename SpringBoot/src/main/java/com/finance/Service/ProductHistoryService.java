package com.finance.Service;

import java.util.List;

import com.finance.Model.Product;
import com.finance.Model.ProductHistory;

public interface ProductHistoryService {
	
	public boolean addProduct(ProductHistory prodhist);
	public List<ProductHistory> viewProduct();
	

}
