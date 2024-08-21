package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reservation {
	@Id
	private int reservation_id;
	private String name;
	private String roomNo;
	private String phoneNo;
	private String adharNo;
	private String joiningDate;
	private String roomType;
	private int noOfDays;
	private int noOfPersons;
	private double money;
	public Reservation() {
		super();
	}
	public Reservation(int reservation_id, String name, String roomNo, String phoneNo, String adharNo,
			String joiningDate, String roomType, int noOfDays, int noOfPersons, double money) {
		super();
		this.reservation_id = reservation_id;
		this.name = name;
		this.roomNo = roomNo;
		this.phoneNo = phoneNo;
		this.adharNo = adharNo;
		this.joiningDate = joiningDate;
		this.roomType = roomType;
		this.noOfDays = noOfDays;
		this.noOfPersons = noOfPersons;
		this.money = money;
	}
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public int getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Reservation [reservation_id=" + reservation_id + ", name=" + name + ", roomNo=" + roomNo + ", phoneNo="
				+ phoneNo + ", adharNo=" + adharNo + ", joiningDate=" + joiningDate + ", roomType=" + roomType
				+ ", noOfDays=" + noOfDays + ", noOfPersons=" + noOfPersons + ", money=" + money + "]";
	}
}
