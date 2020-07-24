package com.sfm.dao;

public interface LoggingDAO {
	
	boolean save(String event,String source,String userid);

}
