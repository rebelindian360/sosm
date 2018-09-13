package com.sosm.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sosm.rest.entity.Categories;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Categories> getCategories() {
		
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query  ... sort by last name
				Query theQuery = 
						currentSession.createQuery("from Categories order by category_Id",
								Categories.class);
				
				// execute query and get result list
				List<Categories> categories = theQuery.getResultList();
						
				// return the results		
				return categories;
	}

	@Override
	public void saveCategory(Categories category) {
				// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// save/upate the customer ... finally LOL
				currentSession.saveOrUpdate(category);
				
	}

	@Override
	public Categories getCategory(int id) {
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// now retrieve/read from database using the primary key
				Categories category = currentSession.get(Categories.class, id);
				
				return category;
	}

	@Override
	public void deleteCategory(int id) {
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery("delete from Categories where id=:category_Id");
				theQuery.setParameter("category_Id", id);
				
				theQuery.executeUpdate();

	}

}
