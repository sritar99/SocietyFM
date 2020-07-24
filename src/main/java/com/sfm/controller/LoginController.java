package com.sfm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sfm.dao.LoggingDAO;
import com.sfm.dao.LoggingDAOImpl;
import com.sfm.dao.LoginDAO;
import com.sfm.dao.LoginDAOImpl;
import com.sfm.model.FlatUser;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDAO logindao=null;
	LoggingDAO loggingdao=null;
    public LoginController() {
        logindao=new LoginDAOImpl();
        loggingdao=new LoggingDAOImpl();

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		FlatUser loginfu=new FlatUser();
		loginfu.setFlatno(Integer.parseInt(request.getParameter("flatno")));
		loginfu.setPassword(request.getParameter("password"));
		String status =logindao.authenticate(loginfu);
		if(status.equals("true")) {
			session.setAttribute("flatsession",request.getParameter("flatno"));
			request.setAttribute("userid",Integer.parseInt(request.getParameter("flatno")));
			String userid=request.getParameter("flatno");
			String url="HomeController?flatno="+userid;
			
			if(loggingdao.save("Login Process","FlatUser",request.getParameter("flatno"))) {
				System.out.println("logging event inserted");
			}
			
			RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		if(status.equals("false")) {
			response.sendRedirect("loginprocess?status=InvalidCredentials");
		}
		if(status.equals("error")) {
			response.sendRedirect("IndexController?status=error");
		}
		
	}

}
