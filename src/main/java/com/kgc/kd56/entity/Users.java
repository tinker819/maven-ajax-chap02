package com.kgc.kd56.entity;

public class Users {
	private String uid;   		//用户id
	private String uname; 		//用户名
	private String borndate; 	//出生日期
	private int sex;            //性别, 0:男  1:女
	private int status;         //用户状态: 0 正常使用   1 禁用
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBorndate() {
		return borndate;
	}
	public void setBorndate(String borndate) {
		this.borndate = borndate;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Users() {}
	
	public Users(String uid, String uname, String borndate, int sex, int status) {
		this.uid = uid;
		this.uname = uname;
		this.borndate = borndate;
		this.sex = sex;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", borndate=" + borndate + ", sex=" + sex + ", status="
				+ status + "]";
	}
	
	
	
	
	
}
