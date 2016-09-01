package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// 书名
	@Column(name = "NAME", nullable = false)
	private String name;

	// 书 封面
	@Column(name = "BOOK_FACE", nullable = false)
	private String bookFace;

	// 价格
	@Column(name = "BOOK_PRICE", nullable = false)
	private double bookPrice;

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

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

	public String getBookFace() {
		return bookFace;
	}

	public void setBookFace(String bookFace) {
		this.bookFace = bookFace;
	}

}