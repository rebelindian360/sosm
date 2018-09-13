package com.sosm.rest.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sosm.rest.entity.Categories;
import com.sosm.rest.entity.Content;
import com.sosm.rest.entity.Languages;
import com.sosm.rest.entity.Types;

@Repository
public class ContentDAOImpl implements ContentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Content> getContents() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query theQuery = 
				currentSession.createQuery("from Content order by content_Id",
						Content.class);
		
		// execute query and get result list
		List<Content> content = theQuery.getResultList();
				
		// return the results		
		return content;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveContent(Content content) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(content);

	}

	@Override
	public Content getContent(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Content content = currentSession.get(Content.class, id);
		
		return content;
	}

	@Override
	public void deleteContent(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Content where id=:content_Id");
		theQuery.setParameter("content_Id", id);
		
		theQuery.executeUpdate();

	}

}
