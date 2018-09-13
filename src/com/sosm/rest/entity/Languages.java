package com.sosm.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class Languages {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="language_id")
	private int language_Id;
	
	@Column(name="language_code")
	private String language_Code;
	
	public Languages() {
		super();
	}

	public Languages(int language_Id, String language_Code) {
		super();
		this.language_Id = language_Id;
		this.language_Code = language_Code;
	}

	public int getLanguage_Id() {
		return language_Id;
	}

	public void setLanguage_Id(int language_Id) {
		this.language_Id = language_Id;
	}

	public String getLanguage_Code() {
		return language_Code;
	}

	public void setLanguage_Code(String language_Code) {
		this.language_Code = language_Code;
	}
}
