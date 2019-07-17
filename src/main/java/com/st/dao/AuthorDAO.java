package com.st.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.st.models.Author;

public class AuthorDAO {
	
	private static AuthorDAO aDAO;
	
	private AuthorDAO() {}
	
	public static AuthorDAO getInstance() {
		return aDAO == null ? aDAO = new AuthorDAO() : aDAO;
	}		
	
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}		
	
	
	public List<Author> viewAllAuthors() {				
	
		String sql = "SELECT * FROM tbl_author;";
		List<Author> authList = new ArrayList<Author>();	
		try(Connection conn = getConnection();
				Statement cmd = conn.createStatement()){
			
			ResultSet result = cmd.executeQuery(sql);			
									
			while(result.next()) {
				Author auth = new Author(result.getInt("authorId"), result.getString("authorName"));				
				authList.add(auth);
			}			
			return authList;							
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return authList;
		}				
	}
	
	
	public boolean addAuthor(String name) {
		String sql = "INSERT INTO tbl_author (authorName) VALUES (?)";
		
		try(Connection conn = getConnection();
				PreparedStatement cmd = conn.prepareStatement(sql)){
			
			cmd.setString(1, name);			
			cmd.execute();	
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}				
	}
	
	public boolean deleteAuthor(int id) {
		String sql = "DELETE FROM tbl_author WHERE authorId = ?";
		
		try(Connection conn = getConnection();
				PreparedStatement cmd = conn.prepareStatement(sql)){
			
			cmd.setInt(1, id);
			cmd.execute();			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}		
	}
	
	public boolean updateAuthor(Author auth) {
		String sql = "UPDATE tbl_author SET authorName = ? WHERE authorId = ?";
		
		try(Connection conn = getConnection(); 
				PreparedStatement cmd = conn.prepareStatement(sql);){			
			cmd.setString(1, auth.getAuthName());			
			cmd.setInt(2, auth.getAuthId());
			
			cmd.execute();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}	
	}
	
	
	
}
