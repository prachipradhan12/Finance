package com.finance.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminlogin")
public class AdminLogin {
	@Id
    private long adminid;
    private String aname;
    private String apass;
	public long getAdminid() {
		return adminid;
	}
	public void setAdminid(long adminid) {
		this.adminid = adminid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}
	public AdminLogin(long adminid, String aname, String apass) {
		super();
		this.adminid = adminid;
		this.aname = aname;
		this.apass = apass;
	}
	public AdminLogin() {
		super();
	}
    

}
