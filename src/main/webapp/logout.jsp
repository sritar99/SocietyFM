<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.sfm.dao.LoggingDAO" %>
<%@ page import="com.sfm.dao.LoggingDAOImpl" %>
<%
	String user=(String)session.getAttribute("flatsession");
	LoggingDAO loggingdao=null;
	loggingdao=new LoggingDAOImpl();
	if(loggingdao.save("Logout Process","FlatUser",user)) {
		System.out.println("logging event inserted");
	}
	session.invalidate();
	response.sendRedirect("login.jsp");
%>