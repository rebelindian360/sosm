package com.sosm.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sosm.rest.entity.Languages;

@Service
public interface LanguageService {

	public List<Languages> getLanguages();

	public void saveLanguages(Languages languages);

	public Languages getLanguage(int id);

	public void deleteLanguage(int id);
	
}