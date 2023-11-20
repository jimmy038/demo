package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity				  //托管Entity,entity內的這包Menu當作塞資料的媒介
@Table(name = "menu") //menu對應到資料庫內的menu
public class Menu {
	
	@Id					   //Id 對應到資料庫的Pk
	@Column(name = "name") //Column欄位 Column裡面的name對應到資料庫資料表內的欄位名稱
	private String name;
	
	@Column(name = "price")//Column欄位 Column裡面的name price對應到資料庫資料表內的欄位價格
	private int price;
	
	public Menu() {
		super();
	}
	
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
