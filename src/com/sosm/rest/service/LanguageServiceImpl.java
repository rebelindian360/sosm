package com.sosm.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sosm.rest.dao.ContentDAO;
import com.sosm.rest.dao.LanguageDAO;
import com.sosm.rest.entity.Languages;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageDAO languageDAO;
	
	@Override
	@Transactional
	public List<Languages> getLanguages() {
		
		return languageDAO.getLanguages();
	}

	@Override
	@Transactional
	public void saveLanguages(Languages languages) {
		languageDAO.saveLanguages(languages);

	}

	@Override
	@Transactional
	public Languages getLanguage(int id) {
		
		return languageDAO.getLanguage(id);
	}

	@Override
	@Transactional
	public void deleteLanguage(int id) {
		languageDAO.deleteLanguage(id);

	}

}
