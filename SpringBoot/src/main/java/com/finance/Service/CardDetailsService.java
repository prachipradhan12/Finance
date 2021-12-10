package com.finance.Service;

import java.util.List;

import com.finance.Model.CardDetails;



public interface CardDetailsService {
	public boolean updateBalance(long regid,int price);
	public List<CardDetails> getProducts();
	
	
	//SNEHA PART
	public List<CardDetails> getCarddetails();
	
	
	public boolean updateCard(long regid);
	
	public CardDetails findCard(long regid);
	public boolean deleteCard(long regid);
	
	public boolean addCard(CardDetails card);
}
