package com.sosm.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sosm.rest.entity.Types;

@Repository
public class TypeDAOImpl implements TypeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Types> getTypes() {
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query  ... sort by last name
				Query theQuery = 
						currentSession.createQuery("from Types order by Type_Id",
								Types.class);
				
				// execute query and get result list
				List<Types> types = theQuery.getResultList();
						
				// return the results		
				return types;
	}

	@Override
	public void saveTypes(Types type) {
				// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// save/upate the customer ... finally LOL
				currentSession.saveOrUpdate(type);
		
	}

	@Override
	public Types getType(int id) {
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// now retrieve/read from database using the primary key
				Types type = currentSession.get(Types.class, id);
				
				return type;
	}

	@Override
	public void deleteType(int id) {
				// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery("delete from Types where id=:type_Id");
				theQuery.setParameter("type_Id", id);
				
				theQuery.executeUpdate();
		
	}

}
