package com.finance.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	  @SequenceGenerator(sequenceName = "productid_seq", allocationSize = 1, name = "CUST_SEQ")
	@Column(name = "prodid")
	private int prodid;
	@Column(name = "prodname")
	private String prodname;
	@Column(name="proddesc")
	private String proddesc;
	@Column(name="prodimage")
	private String prodimage;
	@Column(name="price")
	private int price;
	@Column(name="emi_3m")
	private int emi_3m;
	@Column(name="emi_6m")
	private int emi_6m;
	@Column(name="emi_9m")
	private int emi_9m;
	@Column(name="emi_1y")
	private int emi_1y;
	
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
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	public String getProdimage() {
		return prodimage;
	}
	public void setProdimage(String prodimage) {
		this.prodimage = prodimage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getEmi_3m() {
		return emi_3m;
	}
	public void setEmi_3m(int emi_3m) {
		this.emi_3m = emi_3m;
	}
	public int getEmi_6m() {
		return emi_6m;
	}
	public void setEmi_6m(int emi_6m) {
		this.emi_6m = emi_6m;
	}
	public int getEmi_9m() {
		return emi_9m;
	}
	public void setEmi_9m(int emi_9m) {
		this.emi_9m = emi_9m;
	}
	public int getEmi_1y() {
		return emi_1y;
	}
	public void setEmi_1y(int emi_1y) {
		this.emi_1y = emi_1y;
	}
	
	public Product() {
		super();
	}
	

}
