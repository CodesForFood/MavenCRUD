package com.st.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.st.models.Author;
import com.st.services.AuthorService;

@WebServlet({"/add", "/update", "/delete", "/viewAll"})
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Result() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		
		List<Author> authList = AuthorService.getInstance().viewAll();
		
		response.setContentType("application/json");
	     
		PrintWriter out = response.getWriter();
		  
		out.print(gson.toJson(authList));
		out.flush();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String name = "";
		int id = 0;

		response.setContentType("text/plain");
		
		switch(path) {
		case "/add":
			name = request.getParameter("authName");
			if(AuthorService.getInstance().addAuthor(name)) {
				response.getWriter().append("Author was added successfully");
			}
			else {
				response.getWriter().append("Author was NOT added");
			}
			break;
		case "/update":
			name = request.getParameter("authName");
			try {
				id = Integer.parseInt(request.getParameter("authId"));
				Author auth = new Author(id, name);
				if(AuthorService.getInstance().updateAuthor(auth)) {
					response.getWriter().append("Author was updated successfully");
				}
				else {
					response.getWriter().append("Author was NOT updated");
				}
			}
			catch(Exception ex) {
				response.getWriter().append("Invalid character for author Id");
			}										
			break;
		case "/delete":		
			try {
				id = Integer.parseInt(request.getParameter("authId"));
			
				if(AuthorService.getInstance().deleteAuthor(id)) {
					response.getWriter().append("Author was deleted successfully");
				}
				else {
					response.getWriter().append("Author was NOT deleted");
				}
			}
			catch(Exception ex) {
				response.getWriter().append("Invalid character for author Id");
			}
			break;
		default:
			response.getWriter().append(path + " was not part of the switch");
			break;
			
		}

	}

}
