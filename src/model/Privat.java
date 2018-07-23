package model;

import java.util.Date;

public class Privat {
	private int num;
	private String name;
	private String subject;
	private String content;
	private int readcnt;
	private String family_num;
	private Date regdate;
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getFamily_num() {
		return family_num;
	}
	public void setFamily_num(String family_num) {
		this.family_num = family_num;
	}
	@Override
	public String toString() {
		return "Privat [num=" + num + ", name=" + name + ", subject=" + subject + ", content="
				+ content + ", readcnt=" + readcnt + ", family_num=" + family_num + "]";
	}
	
}
