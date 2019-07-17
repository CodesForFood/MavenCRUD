package com.st.services;

import java.util.List;

import com.st.dao.AuthorDAO;
import com.st.models.Author;

public class AuthorService {

	
	private static AuthorService aService;
	
	private AuthorService() {
		
	}
	
	public static AuthorService getInstance() {
		return aService == null ? aService = new AuthorService() : aService;
	}
	
	public boolean addAuthor(String authName) {
		return AuthorDAO.getInstance().addAuthor(authName);
	}
	
	public boolean updateAuthor(Author auth) {
		return AuthorDAO.getInstance().updateAuthor(auth);
	}
	
	public boolean deleteAuthor(int authId) {
		return AuthorDAO.getInstance().deleteAuthor(authId);
	}
	
	public List<Author> viewAll() {
		return AuthorDAO.getInstance().viewAllAuthors();
	}
	
	
}
