package com.sfm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sfm.util.DBConnection;

public class LoggingDAOImpl implements LoggingDAO {
	
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement st=null;
	PreparedStatement preparedStatement = null;

	public boolean save(String event, String source, String userid) {
		boolean flag=false;
		try {
			String sql="insert into logging(event,Source,userid,time_stamp) values('"+event+"','"+source+"','"+userid+"',now())";
			
			connection = DBConnection.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();

			flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
