package com.sfm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sfm.model.MonthlyActivities;
import com.sfm.util.DBConnection;

public class MonthlyActivitiesDAOImpl implements MonthlyActivitiesDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement st=null;

	public List<MonthlyActivities> get() {
		List<MonthlyActivities> activitylist=null;
		MonthlyActivities activity=null; 
		
		try {
			activitylist=new ArrayList<MonthlyActivities>();
			String sql="select * from monthlyactivities;";
			
			connection = DBConnection.openConnection();
			st=connection.createStatement();
			resultSet = st.executeQuery(sql);
			
			while(resultSet.next()) {
				activity=new MonthlyActivities();
				activity.setId(resultSet.getInt("id")); 
				activity.setActivityname(resultSet.getString("name"));
				activity.setMonth(resultSet.getString("monthyear"));
				activity.setLastdate(resultSet.getString("lastdate"));
				activity.setAmount(resultSet.getInt("amount"));
				activitylist.add(activity);
				System.out.println(activity.toString());
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activitylist;
	}

}
