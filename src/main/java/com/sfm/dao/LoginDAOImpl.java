package com.sfm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sfm.model.FlatUser;
import com.sfm.util.DBConnection;

public class LoginDAOImpl implements LoginDAO {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	public String authenticate(FlatUser loginuser) {
		String sql="select * from flatuser where flatno=? and password=?";
		try {
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,loginuser.getFlatno());
			preparedStatement.setString(2,loginuser.getPassword());
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return "true";
			}else {
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
