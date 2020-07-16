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
import com.sfm.model.FlatUser;
import com.sfm.model.InwardPayments;

public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InwardPaymentsDAO inwardpaymentdao=null;
	FlatUserDAO faltuserdao=null;

    public PaymentController() {
        super();
        inwardpaymentdao=new InwardPaymentsDAOImpl();
        faltuserdao=new FlatUserDAOImpl();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		InwardPayments inwardpayment=inwardpaymentdao.getRow(id);
//		System.out.println(inwardpayment.toString());
		request.setAttribute("inwardpayment",inwardpayment);
		
		FlatUser flatuser=faltuserdao.get(Integer.parseInt(request.getParameter("flatno")));
		request.setAttribute("flatuser",flatuser);
		RequestDispatcher disp=request.getRequestDispatcher("/Payments.jsp");
		disp.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flatno=Integer.parseInt(request.getParameter("flatno"));
		int issueid=Integer.parseInt(request.getParameter("issueid"));
		int money=Integer.parseInt(request.getParameter("money"));
		if(inwardpaymentdao.submit(issueid, money)) {
			request.setAttribute("message","Payment Done Successfully");
			String url="HomeController?flatno="+flatno;
			response.sendRedirect(url);
		}else {
			doGet(request, response);
		}
	}

}
