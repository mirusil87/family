package model;

public class Pic {
	private int familynum;
	private String familyname;
	public String picture;
	
	public int getFamilynum() {
		return familynum;
	}
	public void setFamilynum(int familynum) {
		this.familynum = familynum;
	}
	public String getFamilyname() {
		return familyname;
	}
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Pic [familynum=" + familynum + ", familyname=" + familyname + ", picture=" + picture + "]";
	}
}
