package com.finance.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emicard")
public class EmiCard {
	@Id
	private String cardtype;
	private int validity;
	private long cardlimit;
	
	public EmiCard() {
		super();
	}
	
	public EmiCard(String cardtype, int validity, long cardlimit) {
		super();
		this.cardtype = cardtype;
		this.validity = validity;
		this.cardlimit = cardlimit;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public long getCardlimit() {
		return cardlimit;
	}
	public void setCardlimit(long cardlimit) {
		this.cardlimit = cardlimit;
	}

}
