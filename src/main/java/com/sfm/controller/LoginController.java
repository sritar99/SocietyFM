package com.sfm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.dao.LoginDAO;
import com.sfm.dao.LoginDAOImpl;
import com.sfm.model.FlatUser;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDAO logindao=null;
    public LoginController() {
        logindao=new LoginDAOImpl();

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlatUser loginfu=new FlatUser();
		loginfu.setFlatno(Integer.parseInt(request.getParameter("flatno")));
		loginfu.setPassword(request.getParameter("password"));
		String status =logindao.authenticate(loginfu);
		if(status.equals("true")) {
			response.sendRedirect("home.jsp");
		}
		if(status.equals("false")) {
			response.sendRedirect("IndexController?status=false");
		}
		if(status.equals("error")) {
			response.sendRedirect("IndexController?status=error");
		}
		
	}

}
