package com.finance.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.Model.CardDetails;
import com.finance.Repository.CardDetailsRepository;
@Service
@Transactional
public class CardDetailsServiceImpl implements CardDetailsService {
	@Autowired
	CardDetailsRepository cardRepo;

	@Override
	public boolean updateBalance(long regid,int price) {
		// TODO Auto-generated method stub
		
		CardDetails card=cardRepo.findByRegid(regid);
		if(price>card.getAvailbal()) {
			return false;
		}else {
		int bal=card.getAvailbal()-price;
		card.setAvailbal(bal);
		cardRepo.save(card);

		return true;
		}
	}

	@Override
	public List<CardDetails> getProducts() {
		// TODO Auto-generated method stub
		return cardRepo.findAll();
	}
	
	
	////SNEHAAAA PART
	
	@Override
	public List<CardDetails> getCarddetails() {
		// TODO Auto-generated method stub
		return cardRepo.findAll();
	}

	@Override
	public boolean updateCard(long regid) {
		CardDetails newcrd=cardRepo.findById(regid).get();
		cardRepo.save(newcrd);
		return true;
		
		
	}

	@Override
	public CardDetails findCard(long regid) {
		// TODO Auto-generated method stub
		return cardRepo.findById(regid).get();
	}

	@Override
	public boolean deleteCard(long regid) {
		// TODO Auto-generated method stub
		CardDetails newusr=cardRepo.findById(regid).get();
		cardRepo.delete(newusr);
		return true;
	}

	@Override
	public boolean addCard(CardDetails card) {
//		
		
		
		if(card.getCardtype().equals("gold")) {
			Date d =Date.valueOf(LocalDate.now().plusYears(2));
			card.setValidity(d);
			
		}
		else {
			Date d =Date.valueOf(LocalDate.now().plusYears(3));
		card.setValidity(d);

			
		}
		
		
		cardRepo.save(card);
		return true;
		}
	
}
