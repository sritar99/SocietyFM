package com.sfm.dao;

import com.sfm.model.FlatUser;

public interface LoginDAO {
	String authenticate(FlatUser loginuser);
}
