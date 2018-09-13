package com.sosm.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sosm.rest.dao.LanguageDAO;
import com.sosm.rest.dao.TypeDAO;
import com.sosm.rest.entity.Types;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeDAO typeDAO;
	
	@Override
	@Transactional
	public List<Types> getTypes() {
		
		return typeDAO.getTypes();
	}

	@Override
	@Transactional
	public void saveTypes(Types type) {
		typeDAO.saveTypes(type);
	}

	@Override
	@Transactional
	public Types getType(int id) {
		return typeDAO.getType(id);
	}

	@Override
	@Transactional
	public void deleteType(int id) {
		typeDAO.deleteType(id);
	}

}
