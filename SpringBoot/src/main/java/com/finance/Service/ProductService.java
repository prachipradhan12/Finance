package com.finance.Service;

import java.util.List;

import com.finance.Model.Product;
import com.finance.Model.ProductHistory;



public interface ProductService {
	public List<Product> viewProduct();
	public Product findProduct(int prodid);
	public String addProducts(Product product);
	public List<Product> viewProductByName(String prodname);

}
