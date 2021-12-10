package com.finance.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.Model.EmiCard;
import com.finance.Repository.EmiCardRepository;
@Service
@Transactional
public class EmiCardServiceImpl implements EmiCardService {


	@Autowired
	EmiCardRepository emicardrepo;
	
	@Override
	public List<EmiCard> getAllEmiCard() {
		return emicardrepo.findAll();
	}

	@Override
	public boolean addEmiCard(EmiCard emiCard) {
		emicardrepo.save(emiCard);
		return true;
	}
}
