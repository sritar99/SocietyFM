package com.sfm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfm.dao.FlatUserDAO;
import com.sfm.dao.FlatUserDAOImpl;
import com.sfm.dao.InwardPaymentsDAO;
import com.sfm.dao.InwardPaymentsDAOImpl;
import com.sfm.dao.LoggingDAO;
import com.sfm.dao.LoggingDAOImpl;
import com.sfm.model.FlatUser;
import com.sfm.model.InwardPayments;

public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InwardPaymentsDAO inwardpaymentdao=null;
	FlatUserDAO faltuserdao=null;
	LoggingDAO loggingdao=null;

    public PaymentController() {
        super();
        inwardpaymentdao=new InwardPaymentsDAOImpl();
        faltuserdao=new FlatUserDAOImpl();
        loggingdao=new LoggingDAOImpl();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		InwardPayments inwardpayment=inwardpaymentdao.getRow(id);
		request.setAttribute("inwardpayment",inwardpayment);
		
		FlatUser flatuser=faltuserdao.get(Integer.parseInt(request.getParameter("flatno")));
		request.setAttribute("flatuser",flatuser);
		if(loggingdao.save("Reviewing Payment","FlatUser",request.getParameter("flatno"))) {
			System.out.println("logging event inserted");
		}
		RequestDispatcher disp=request.getRequestDispatcher("/Payments.jsp");
		disp.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flatno=Integer.parseInt(request.getParameter("flatno"));
		int issueid=Integer.parseInt(request.getParameter("issueid"));
		int money=Integer.parseInt(request.getParameter("money"));
		boolean delay=Boolean.parseBoolean((request.getParameter("delayed")));
		if(inwardpaymentdao.submit(issueid, money)) {
			request.setAttribute("message","Payment Done Successfully");
			if(loggingdao.save("Processing of Payment","FlatUser",request.getParameter("flatno"))) {
				System.out.println("logging event inserted");
			}
			String url="HomeController?flatno="+flatno;
			response.sendRedirect(url);
		}else {
			response.sendRedirect("HomeController?flatno="+flatno);
		}
	}

}
