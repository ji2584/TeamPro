package model;

public class Amem {
/*
 * create table kicmember (
id varchar(20) primary key,
pass varchar(20),
name varchar(20),
gender number(1),
tel varchar(20),
email varchar(50),
picture varchar(200));
 * 
 */
	
	private String id;
	private String nickname;
	private String pass;
	private String name;
	private String tel;
	private String email;
	private String address;
	private String bank;
	private String account;
	private String adminchk;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAdminchk() {
		return adminchk;
	}
	public void setAdminchk(String adminchk) {
		this.adminchk = adminchk;
	}
	@Override
	public String toString() {
		return "Amem [id=" + id + ", nickname=" + nickname + ", pass=" + pass + ", name=" + name + ", tel=" + tel
				+ ", email=" + email + ", address=" + address + ", bank=" + bank + ", account=" + account
				+ ", adminchk=" + adminchk + "]";
	}
	
	
	
	

}


