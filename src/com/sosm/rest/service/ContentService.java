package com.sosm.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sosm.rest.entity.Content;

@Service
public interface ContentService {

	public List<Content> getContents();

	public void saveContent(Content content);

	public Content getContent(int id);

	public void deleteContent(int id);
	
}
