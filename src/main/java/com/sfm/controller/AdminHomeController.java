package com.sfm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.dao.MonthlyActivitiesDAO;
import com.sfm.dao.MonthlyActivitiesDAOImpl;
import com.sfm.model.MonthlyActivities;

public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MonthlyActivitiesDAO monthlyactivitydao=null;
	
    public AdminHomeController() {
    	monthlyactivitydao=new MonthlyActivitiesDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MonthlyActivities> list= monthlyactivitydao.get();
		
		request.setAttribute("activitylist",list);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/adminhome.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
