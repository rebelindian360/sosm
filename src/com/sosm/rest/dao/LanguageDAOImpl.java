package com.sosm.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sosm.rest.entity.Languages;

@Repository
public class LanguageDAOImpl implements LanguageDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Languages> getLanguages() {
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query  ... sort by last name
				Query theQuery = 
						currentSession.createQuery("from Languages order by language_Id",
								Languages.class);
				
				// execute query and get result list
				List<Languages> languages = theQuery.getResultList();
						
				// return the results		
				return languages;
	}

	@Override
	public void saveLanguages(Languages languages) {
				// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// save/upate the customer ... finally LOL
				currentSession.saveOrUpdate(languages);

	}

	@Override
	public Languages getLanguage(int id) {
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// now retrieve/read from database using the primary key
				Languages language = currentSession.get(Languages.class, id);
				
				return language;
	}

	@Override
	public void deleteLanguage(int id) {
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery("delete from Languages where id=:language_Id");
				theQuery.setParameter("language_Id", id);
				
				theQuery.executeUpdate();

	}

}
