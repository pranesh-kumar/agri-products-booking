package com.spring.agrimart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FertilizerModel {
	@Id
	public int id;
	public String name;
	public int quantity;
	public int prize;  
	FertilizerModel(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	@Override
	public String toString() {
		return "FertilizerModel [id=" + id + ", name=" + name + ", quantity=" + quantity + ", prize=" + prize + "]";
	}
	
	
	

}
