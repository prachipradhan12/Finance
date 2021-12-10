package com.finance.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ProductHistory")
public class ProductHistory {

	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    private long phistoryid;
	@Column(name = "regid")
	private long regid;
	@Column(name = "prodid")
	private int prodid;
	@Column(name = "prodname")
	private String prodname;
	@Column(name="amountpaid")
	private int amountpaid;
	@Column(name = "emi")
	private String emi;
	@Column(name="ammount_bal")
	private long ammount_bal;
	@Column(name="price")
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getPhistoryid() {
		return phistoryid;
	}
	public void setPhistoryid(long phistoryid) {
		this.phistoryid = phistoryid;
	}
	public long getRegid() {
		return regid;
	}
	public void setRegid(long regid) {
		this.regid = regid;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public int getAmountpaid() {
		return amountpaid;
	}
	public void setAmountpaid(int amountpaid) {
		this.amountpaid = amountpaid;
	}
	public String getEmi() {
		return emi;
	}
	public void setEmi(String emi) {
		this.emi = emi;
	}
	public long getAmmount_bal() {
		return ammount_bal;
	}
	public void setAmmount_bal(long ammount_bal) {
		this.ammount_bal = ammount_bal;
	}
	public ProductHistory() {
		super();
	}

	
}
