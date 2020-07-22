package com.sfm.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.dao.InwardPaymentsDAO;
import com.sfm.dao.InwardPaymentsDAOImpl;

import com.sfm.model.InwardPayments;


import java.io.IOException;


public class DefaultersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	InwardPaymentsDAO inwardpaymentdao=null;

    public DefaultersController() {
        super();
        inwardpaymentdao=new InwardPaymentsDAOImpl();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int getFlatId=Integer.parseInt(request.getParameter("flatno"));
		request.setAttribute("flatno",getFlatId);
		List<InwardPayments> inwardlist=inwardpaymentdao.getdefaulters();
		request.setAttribute("inwardlist",inwardlist);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/defaulters.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
