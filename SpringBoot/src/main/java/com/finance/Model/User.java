package com.finance.Model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class User {
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	  @SequenceGenerator(sequenceName = "userid_sequence1", allocationSize = 1, name = "CUST_SEQ")
	  
	  @Id
	  @Column(name = "regid")
	  private long regid;
		private String uname;
		private Long phone;
		private String email;
		private String upass;
		private String address;
		private String cardtype;
		private String bankname;
		private long acc_no;
		private String ifsc_code;
		@Column(name="isverified")
		private String isVerified="False";
		@Column(name="applied_on")
		private Date applied_on=Date.valueOf(LocalDate.now());
		
		public User() {
			super();
		}

		public String getIsVerified() {
			return isVerified;
		}

		public void setIsVerified(String isVerified) {
			this.isVerified = isVerified;
		}

		public void setPhone(Long phone) {
			this.phone = phone;
		}

		public User(long regid, String uname, long phone, String email, String upass, String address,
				String cardtype, String bankname, long acc_no, String ifsc_code, Date applied_on) {
			super();
			this.regid = regid;
			this.uname = uname;
			this.phone = phone;
			this.email = email;
			this.upass = upass;
			this.address = address;
			this.cardtype = cardtype;
			this.bankname = bankname;
			this.acc_no = acc_no;
			this.ifsc_code = ifsc_code;
			this.applied_on = applied_on;
		}

		public long getRegid() {
			return regid;
		}

		public void setRegid(long regid) {
			this.regid = regid;
		}

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUpass() {
			return upass;
		}

		public void setUpass(String upass) {
			this.upass = upass;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCardtype() {
			return cardtype;
		}

		public void setCardtype(String cardtype) {
			this.cardtype = cardtype;
		}

		public String getBankname() {
			return bankname;
		}

		public void setBankname(String bankname) {
			this.bankname = bankname;
		}

		public long getAcc_no() {
			return acc_no;
		}

		public void setAcc_no(long acc_tno) {
			this.acc_no = acc_tno;
		}

		public String getIfsc_code() {
			return ifsc_code;
		}

		public void setIfsc_code(String ifsc_code) {
			this.ifsc_code = ifsc_code;
		}

		public Date getApplied_on() {
			return applied_on;
		}

		public void setApplied_on(Date applied_on) {
			this.applied_on = applied_on;
		}
		
	  
	
	
	

}
