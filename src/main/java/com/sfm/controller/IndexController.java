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
import com.sfm.model.FlatUser;


public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoggingDAO loggingdao=null;

	FlatUserDAO flatuserdao =null;
    public IndexController() {
    	flatuserdao=new FlatUserDAOImpl();
    	loggingdao=new LoggingDAOImpl();
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
			HttpSession session=request.getSession();
			session.setAttribute("flatsession",request.getParameter("flatno"));
			System.out.println("UserAdded Successfully");
			request.setAttribute("userid",Integer.parseInt(request.getParameter("flatno")));
			String userid=request.getParameter("flatno");
			String url="HomeController?flatno="+userid;
			RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			if(loggingdao.save("Registration Process","FlatUser",request.getParameter("flatno"))) {
				System.out.println("logging event inserted");
			}
		}else {
			System.out.println("UserRegistration is  UnSuccessfull");
			doGet(request, response);
		}
		
	}

}
