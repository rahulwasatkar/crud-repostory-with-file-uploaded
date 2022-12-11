package com.main.java.project.with.spring.boot.crud.model;


public class Supplier {
	
	private int supllierId;
	private String supllierName;
	private long moNumber;
	private int age;
	
	@Override
	public String toString() {
		return "Supplier [supllierId=" + supllierId + ", supllierName=" + supllierName + ", moNumber=" + moNumber
				+ ", age=" + age + "]";
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(int supllierId, String supllierName, long moNumber, int age) {
		super();
		this.supllierId = supllierId;
		this.supllierName = supllierName;
		this.moNumber = moNumber;
		this.age = age;
	}
	public int getSupllierId() {
		return supllierId;
	}
	public void setSupllierId(int supllierId) {
		this.supllierId = supllierId;
	}
	public String getSupllierName() {
		return supllierName;
	}
	public void setSupllierName(String supllierName) {
		this.supllierName = supllierName;
	}
	public long getMoNumber() {
		return moNumber;
	}
	public void setMoNumber(long moNumber) {
		this.moNumber = moNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
