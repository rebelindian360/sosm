package com.sosm.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sosm.rest.dao.ContentDAO;
import com.sosm.rest.entity.Content;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentDAO contentDAO;
	
	@Override
	@Transactional
	public List<Content> getContents() {
		
		return contentDAO.getContents();
	}

	@Override
	@Transactional
	public void saveContent(Content content) {
		contentDAO.saveContent(content);
	}

	@Override
	@Transactional
	public Content getContent(int id) {
		
		return contentDAO.getContent(id);
	}

	@Override
	@Transactional
	public void deleteContent(int id) {
		contentDAO.deleteContent(id);
	}

}
