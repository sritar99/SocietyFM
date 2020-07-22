package com.sfm.dao;

import java.util.List;

import com.sfm.model.InwardPayments;

public interface InwardPaymentsDAO {
	
	List<InwardPayments> get(int id);
	
	InwardPayments getRow(int issueid);
	

	List<InwardPayments> getPaidList();
	List<InwardPayments> getDueList();
	Integer getPaidAmount();
	
	boolean submit(int issueid,int money);
	
	List<InwardPayments> getdefaulters();
}
