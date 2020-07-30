package com.sfm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sfm.dao.FlatUserDAO;
import com.sfm.dao.FlatUserDAOImpl;
import com.sfm.dao.LoggingDAO;
import com.sfm.dao.LoggingDAOImpl;


public class FlatUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoggingDAO loggingdao=null;
	FlatUserDAO flatuserdao=null;

    public FlatUserProfile() {
        super();
        loggingdao=new LoggingDAOImpl();
        flatuserdao=new FlatUserDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("updateprofile.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String userid=(String) session.getAttribute("flatsession");
		String url="HomeController?flatno="+userid;
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("phone_number");
		
		if(flatuserdao.updateprofile(Integer.parseInt(userid), name, email, mobile)) {
			if(loggingdao.save("Update Profile","FlatUser",userid)) {
				System.out.println("logging event inserted");
			}
		}
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
