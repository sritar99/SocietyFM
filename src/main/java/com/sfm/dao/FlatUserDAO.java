package com.sfm.dao;

import java.util.List;

import com.sfm.model.FlatUser;

public interface FlatUserDAO {
	boolean save(FlatUser flatuser);
	
	FlatUser get(int flatno);
	
	List<Integer> getAllFlatusers();
	
	boolean updateprofile(int flatno,String name,String email,String mobile);

}
