package com.sfm.dao;

import com.sfm.model.FlatUser;

public interface FlatUserDAO {
	boolean save(FlatUser flatuser);
	
	FlatUser get(int flatno);

}
