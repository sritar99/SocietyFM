package com.sfm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sfm.model.InwardPayments;
import com.sfm.util.DBConnection;

public class InwardPaymentsDAOImpl implements InwardPaymentsDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement st=null;
	PreparedStatement preparedStatement = null;
	List<InwardPayments> paidlist=null;
	List<InwardPayments> duelist=null;
	Integer amountpaid;

	public List<InwardPayments> get(int id) {

		List<InwardPayments> inwardpaymentslist=null;
		InwardPayments inwardpayment=null;

		
		try {
			inwardpaymentslist=new ArrayList<InwardPayments>();
			duelist=new ArrayList<InwardPayments>();
			paidlist=new ArrayList<InwardPayments>();
			amountpaid=0;
			String sql="select * from inwardpayments where flatno="+id;
			
			connection = DBConnection.openConnection();
			st=connection.createStatement();
			resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				inwardpayment=new InwardPayments();
				inwardpayment.setIssueid(resultSet.getInt("issueid"));
				inwardpayment.setFlatno(resultSet.getInt("flatno"));
				inwardpayment.setActivityid(resultSet.getInt("activityid"));
				inwardpayment.setName(resultSet.getString("name"));
				inwardpayment.setMonthyear(resultSet.getString("monthyear"));
				inwardpayment.setLastdate(resultSet.getString("lastdate"));
				inwardpayment.setAmount(resultSet.getInt("amount"));  
				inwardpayment.setIspaid(resultSet.getBoolean("ispaid")); 
				inwardpayment.setDatepaid(resultSet.getDate("datepaid"));
				inwardpayment.setAmountpaid(resultSet.getInt("amountpaid"));
				amountpaid=amountpaid+resultSet.getInt("amountpaid");
//				System.out.println(inwardpayment.toString());
				if(resultSet.getBoolean("ispaid")==false) {
					duelist.add(inwardpayment);
				}else {
					paidlist.add(inwardpayment);
				}
				inwardpaymentslist.add(inwardpayment);
			}
			
;		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return inwardpaymentslist;
	}

	public List<InwardPayments> getPaidList() {

		return paidlist;
	}

	public List<InwardPayments> getDueList() {

		return duelist;
	}

	public Integer getPaidAmount() {

		return amountpaid;
	}

	public InwardPayments getRow(int issueid) {
		InwardPayments inwardpayment=null;
		try {
			String sql="select * from inwardpayments where issueid="+issueid;
			connection = DBConnection.openConnection();
			st=connection.createStatement();
			resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				inwardpayment=new InwardPayments();
				inwardpayment.setIssueid(resultSet.getInt("issueid"));
				inwardpayment.setFlatno(resultSet.getInt("flatno"));
				inwardpayment.setActivityid(resultSet.getInt("activityid"));
				inwardpayment.setName(resultSet.getString("name"));
				inwardpayment.setMonthyear(resultSet.getString("monthyear"));
				inwardpayment.setLastdate(resultSet.getString("lastdate"));
				inwardpayment.setAmount(resultSet.getInt("amount"));  
				inwardpayment.setIspaid(resultSet.getBoolean("ispaid")); 
				inwardpayment.setDatepaid(resultSet.getDate("datepaid"));
				inwardpayment.setAmountpaid(resultSet.getInt("amountpaid"));
			}
		} catch (Exception e) {

		}

		return inwardpayment;
	}

	public boolean submit(int issueid, int money) {
		boolean flag=false;
		try {
			String sql="update inwardpayments set amountpaid='"+money+"',ispaid=true,datepaid=now() where issueid="+issueid;
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