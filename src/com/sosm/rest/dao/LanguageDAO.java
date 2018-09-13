package com.sosm.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sosm.rest.entity.Languages;

@Repository
public interface LanguageDAO {

	public List<Languages> getLanguages();

	public void saveLanguages(Languages languages);

	public Languages getLanguage(int id);

	public void deleteLanguage(int id);
	
}