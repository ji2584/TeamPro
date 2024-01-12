package model;

import java.util.Date;

public class Cart {
	private int pnum;
    private String userid;
    private int itemid;
	private String pname;
    private String price;
    private String file1;
    private Date regdate;
    private int readcnt;
    private String subject;
    private String ser;
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSer() {
		return ser;
	}
	public void setSer(String ser) {
		this.ser = ser;
	}
	@Override
	public String toString() {
		return "Cart [pnum=" + pnum + ", userid=" + userid + ", itemid=" + itemid + ", pname=" + pname + ", price="
				+ price + ", file1=" + file1 + ", regdate=" + regdate + ", readcnt=" + readcnt + ", subject=" + subject
				+ ", ser=" + ser + "]";
	}
        
}