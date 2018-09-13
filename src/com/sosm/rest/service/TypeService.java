package com.sosm.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sosm.rest.entity.Types;

@Service
public interface TypeService {

	public List<Types> getTypes();

	public void saveTypes(Types type);

	public Types getType(int id);

	public void deleteType(int id);
	
}
