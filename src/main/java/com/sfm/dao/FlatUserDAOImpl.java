package com.sfm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sfm.model.FlatUser;
import com.sfm.util.DBConnection;

public class FlatUserDAOImpl implements FlatUserDAO{
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	
	
	
	public boolean save(FlatUser flatuser) {
		boolean flag=false;
		try {
			String sql="insert into flatuser values"
		+"('"+flatuser.getFlatno()+"','"+flatuser.getName()+"','"+flatuser.getEmail()+"','"+flatuser.getPhone_no()+"','"+flatuser.getPassword()+"',now())";
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}




	public FlatUser get(int flatno) {
		FlatUser flatuser=null;
		LoggingDAO loggingdao=null;
		loggingdao=new LoggingDAOImpl();
		if(loggingdao.save("Retrieving User Profile","FlatUser",String.valueOf(flatno))) {
			System.out.println("logging event inserted");
		}
		try {
			String sql="select * from flatuser where flatno="+flatno;
			connection = DBConnection.openConnection();
			statement=connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				flatuser=new FlatUser();
				flatuser.setFlatno(resultSet.getInt("flatno"));
				flatuser.setName(resultSet.getString("name"));
				flatuser.setEmail(resultSet.getString("email"));
				flatuser.setPhone_no(resultSet.getString("mobile"));
				flatuser.setDatejoin(resultSet.getDate("dateandtimejoined"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flatuser;
	}

}