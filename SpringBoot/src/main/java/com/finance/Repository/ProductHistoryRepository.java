package com.finance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.Model.ProductHistory;

@Repository
public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long>{
	 public List<ProductHistory> findByRegid(long regid);
	
}
