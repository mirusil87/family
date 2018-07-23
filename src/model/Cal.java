package model;

import java.util.Date;

public class Cal {
	private int num;
	private Date start_regdate;
	private String subject;
	private Date end_regdate;
	private String family_num;
	private String color;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getStart_regdate() {
		return start_regdate;
	}
	public void setStart_regdate(Date start_regdate) {
		this.start_regdate = start_regdate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getEnd_regdate() {
		return end_regdate;
	}
	public void setEnd_regdate(Date end_regdate) {
		this.end_regdate = end_regdate;
	}
	public String getFamily_num() {
		return family_num;
	}
	public void setFamily_num(String family_num) {
		this.family_num = family_num;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Cal [num=" + num + ", start_regdate=" + start_regdate + ", subject=" + subject + ", end_regdate="
				+ end_regdate + ", family_num=" + family_num + ", color=" + color + "]";
	}
	
	
}
