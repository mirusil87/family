package model;

public class Member {
	private String name;
	private String family_num;
	private String pass;
	private String relation;
	private String tel;
	private String address;
	private String picture;
	private String birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamily_num() {
		return family_num;
	}
	public void setFamily_num(String family_num) {
		this.family_num = family_num;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", family_num=" + family_num + ", pass=" + pass + ", relation=" + relation
				+ ", tel=" + tel + ", address=" + address + ", picture=" + picture + ", birth="
				+ birth + "]";
	}
}
