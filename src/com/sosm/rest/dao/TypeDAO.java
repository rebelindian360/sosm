package com.sosm.rest.dao;

import java.util.List;

import com.sosm.rest.entity.Types;

public interface TypeDAO {

	public List<Types> getTypes();

	public void saveTypes(Types type);

	public Types getType(int id);

	public void deleteType(int id);
	
}
