package com.kgc.kd56.entity;

public class Users {
	private String uid;   		//�û�id
	private String uname; 		//�û���
	private String borndate; 	//��������
	private int sex;            //�Ա�, 0:��  1:Ů
	private int status;         //�û�״̬: 0 ����ʹ��   1 ����
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
