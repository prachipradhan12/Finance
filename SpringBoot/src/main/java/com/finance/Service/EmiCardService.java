package com.finance.Service;

import java.util.List;

import com.finance.Model.EmiCard;

public interface EmiCardService {
	public List<EmiCard> getAllEmiCard();
	public boolean addEmiCard(EmiCard emiCard);

}
