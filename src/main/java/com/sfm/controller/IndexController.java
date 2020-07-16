package com.sfm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.dao.FlatUserDAO;
import com.sfm.dao.FlatUserDAOImpl;
import com.sfm.model.FlatUser;

/**
 * Servlet implementation class IndexController
 */
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FlatUserDAO flatuserdao =null;
    public IndexController() {
    	flatuserdao=new FlatUserDAOImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FlatUser fu=new FlatUser();
		fu.setFlatno(Integer.parseInt(request.getParameter("flatno")));
		fu.setName(request.getParameter("name"));
		fu.setEmail(request.getParameter("email"));
		fu.setPhone_no(request.getParameter("phone_number"));
		fu.setPassword(request.getParameter("password"));		
		if(flatuserdao.save(fu)) {
			System.out.println("UserAdded Successfully");
			request.setAttribute("userid",Integer.parseInt(request.getParameter("flatno")));
			String userid=request.getParameter("flatno");
			String url="HomeController?flatno="+userid;
			RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else {
			System.out.println("UserRegistration is  UnSuccessfull");
			doGet(request, response);
		}
		
	}

}
