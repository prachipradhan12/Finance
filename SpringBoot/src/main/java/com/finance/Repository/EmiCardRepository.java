package com.finance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.Model.EmiCard;

@Repository
public interface EmiCardRepository extends JpaRepository<EmiCard, String>{

}