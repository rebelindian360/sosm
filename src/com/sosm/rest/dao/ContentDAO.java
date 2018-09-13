package com.sosm.rest.dao;

import java.util.List;

import com.sosm.rest.entity.Content;

public interface ContentDAO {

	public List<Content> getContents();

	public void saveContent(Content content);

	public Content getContent(int id);

	public void deleteContent(int id);
	
}