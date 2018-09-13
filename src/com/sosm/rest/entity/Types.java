package com.sosm.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="content_type")
public class Types {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="type_id")
	private int type_Id;
	
	@Column(name="type_code")
	private String type_Code;
	
	public Types() {
		super();
	}
	
	public Types(int type_Id, String type_Code) {
		super();
		this.type_Id = type_Id;
		this.type_Code = type_Code;
	}

	public int getType_Id() {
		return type_Id;
	}

	public void setType_Id(int type_Id) {
		this.type_Id = type_Id;
	}

	public String getType_Code() {
		return type_Code;
	}

	public void setType_Code(String type_Code) {
		this.type_Code = type_Code;
	}
}
