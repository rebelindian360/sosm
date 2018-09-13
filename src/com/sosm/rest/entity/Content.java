package com.sosm.rest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="content")
public class Content {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="content_id")
	private int content_Id;
	
	@Column(name="language_id")
	/*@OneToMany(cascade=CascadeType.ALL, targetEntity=Languages.class)
	@JoinColumn(name="language_id")
	//private Languages languages;
	private Set<Languages> languages = new HashSet<>();
	*/
	private int language_Id;
	
	
	@Column(name="type_id")
	/*@OneToMany(cascade=CascadeType.ALL, targetEntity=Types.class)
	@JoinColumn(name="type_id")
	//private Types types;
	private Set<Types> types = new HashSet<>();
	*/
	private int type_Id;
	
	@Column(name="category_id")
	/*@OneToMany(cascade=CascadeType.ALL, targetEntity=Categories.class)
	@JoinColumn(name="category_id")
	//private Categories categories;
	private Set<Categories> categories = new HashSet<>();
	*/
	private int category_Id;
	
	@Column(name="content")
	private String content;
	
	public Content() {
		super();
	}
	
	
	
	public int getContent_Id() {
		return content_Id;
	}
	
	public void setContent_Id(int content_Id) {
		this.content_Id = content_Id;
	}
	
/*	public Set<Languages> getLanguages() {
		return languages;
	}
	
	public void setLanguages(Set<Languages> languages) {
		this.languages = languages;
	}
	
	public Set<Types> getTypes() {
		return types;
	}
	
	public void setTypes(Set<Types> types) {
		this.types = types;
	}
	
	public Set<Categories> getCategories() {
		return categories;
	}
	
	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}
	
	public Content(int content_Id, Set<Languages> languages, Set<Types> types, Set<Categories> categories,
			String content) {
		super();
		this.content_Id = content_Id;
		this.languages = languages;
		this.types = types;
		this.categories = categories;
		this.content = content;
	}

*/

	public String getContent() {
		return content;
	}
	
	public Content(int content_Id, int language_Id, int type_Id, int category_Id, String content) {
		super();
		this.content_Id = content_Id;
		this.language_Id = language_Id;
		this.type_Id = type_Id;
		this.category_Id = category_Id;
		this.content = content;
	}



	public int getLanguage_Id() {
		return language_Id;
	}



	public void setLanguage_Id(int language_Id) {
		this.language_Id = language_Id;
	}



	public int getType_Id() {
		return type_Id;
	}



	public void setType_Id(int type_Id) {
		this.type_Id = type_Id;
	}



	public int getCategory_Id() {
		return category_Id;
	}



	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}



	public void setContent(String content) {
		this.content = content;
	}
}
