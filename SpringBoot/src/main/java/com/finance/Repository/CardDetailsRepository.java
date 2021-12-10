package com.finance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finance.Model.CardDetails;


@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {
	
//	@Query("update Carddetails u set u.availbal = :u.availbal-?2 where u.regid = :?1")
//	void updateBalance(int id,int price);
	 CardDetails findByRegid(Long regid);
}
