package com.sfm.controller;

import java.io.IOException;
import java.util.List;

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


public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	InwardPaymentsDAO inwardpaymentdao=null;
	FlatUserDAO flatuserdao=null;

    public HomeController() {
        super();
        inwardpaymentdao=new InwardPaymentsDAOImpl();
        flatuserdao=new FlatUserDAOImpl();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String getFlatId=request.getParameter("flatno");
		if(getFlatId!=null) {
			List<InwardPayments> list=inwardpaymentdao.get(Integer.parseInt(getFlatId));
			request.setAttribute("list",list);
			
			FlatUser flatuser=flatuserdao.get(Integer.parseInt(getFlatId));
			request.setAttribute("flatuser",flatuser);
			
			List<InwardPayments> paidlist=inwardpaymentdao.getPaidList();
			request.setAttribute("paidlist",paidlist);
			request.setAttribute("donecount",paidlist.size());
			
			List<InwardPayments> duelist=inwardpaymentdao.getDueList();
			request.setAttribute("duelist",duelist);
			request.setAttribute("duecount",duelist.size());
			
			Integer amountpaid=inwardpaymentdao.getPaidAmount();
			request.setAttribute("paidamount",amountpaid);
			
			RequestDispatcher disp=request.getRequestDispatcher("/home.jsp");
			disp.forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
