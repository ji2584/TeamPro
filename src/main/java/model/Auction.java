package model;

import java.util.Date;

public class Auction {
		// TODO Auto-generated method stub
		private int pnum;
		private String pname;
		private String price;
		private String picture;
		private String subject;
		private String content;
		private String pass;
		private String boardid;
		private int readcnt;	
		private String file1;
		private Date regdate;
		private String userid;
		public int getPnum() {
			return pnum;
		}
		public void setPnum(int pnum) {
			this.pnum = pnum;
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
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getBoardid() {
			return boardid;
		}
		public void setBoardid(String boardid) {
			this.boardid = boardid;
		}
		public int getReadcnt() {
			return readcnt;
		}
		public void setReadcnt(int readcnt) {
			this.readcnt = readcnt;
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
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		@Override
		public String toString() {
			return "Auction [pnum=" + pnum + ", pname=" + pname + ", price=" + price + ", picture=" + picture
					+ ", subject=" + subject + ", content=" + content + ", pass=" + pass + ", boardid=" + boardid
					+ ", readcnt=" + readcnt + ", file1=" + file1 + ", regdate=" + regdate + ", userid=" + userid + "]";
		}
		
	
	
		
	}