package model;

import java.util.Date;

public class Reply {
	private int bnum;
	private int renum;
	private String writer;
	private String content;
	private Date regdate;
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getRenum() {
		return renum;
	}
	public void setRenum(int renum) {
		this.renum = renum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Reply [bnum=" + bnum + ", renum=" + renum + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
}
