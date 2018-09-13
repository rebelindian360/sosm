package com.sosm.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Categories {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int category_Id;
	
	@Column(name="category_code")
	private String category_Code;
	
	public Categories() {
		super();
	}
	
	public Categories(int category_Id, String category_Code) {
		super();
		this.category_Id = category_Id;
		this.category_Code = category_Code;
	}
	
	public int getCategory_Id() {
		return category_Id;
	}
	
	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}
	
	public String getCategory_Code() {
		return category_Code;
	}
	
	public void setCategory_Code(String category_Code) {
		this.category_Code = category_Code;
	}
}
