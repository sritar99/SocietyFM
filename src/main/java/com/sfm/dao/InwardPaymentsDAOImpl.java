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
		LoggingDAO loggingdao=null;
		loggingdao=new LoggingDAOImpl();
		if(loggingdao.save("Retrieving User InwardPayments","FlatUser",String.valueOf(id))) {
			System.out.println("logging event inserted");
		}

		
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
		LoggingDAO loggingdao=null;
		loggingdao=new LoggingDAOImpl();
		
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
			if(loggingdao.save("Retrieving User InwardPayment for Payment Process","FlatUser",String.valueOf(inwardpayment.getFlatno()))) {
				System.out.println("logging event inserted");
			}
		} catch (Exception e) {

		}

		return inwardpayment;
	}

	public boolean submit(int issueid, int money) {
		boolean flag=false;
		LoggingDAO loggingdao=null;
		loggingdao=new LoggingDAOImpl();
		try {
			String sql="update inwardpayments set amountpaid='"+money+"',ispaid=true,datepaid=now() where issueid="+issueid;
			
			
			connection = DBConnection.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();

			flag=true;
			if(loggingdao.save("Payment Processing of User InwardPayment","Payment IssueId",String.valueOf(issueid))) {
				System.out.println("logging event inserted");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<InwardPayments> getdefaulters() {
		
		List<InwardPayments> inwardlist=null;
		InwardPayments inwardpayment=null;
		
		try {
			
			inwardlist=new ArrayList<InwardPayments>();
			String sql="select * from inwardpayments where ispaid=false or amount!=amountpaid or ispaid is null";
			
			connection = DBConnection.openConnection();
			st=connection.createStatement();
			resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				inwardpayment=new InwardPayments();
				inwardpayment.setName(resultSet.getString("name"));
				inwardpayment.setAmount(resultSet.getInt("amount"));
				inwardpayment.setActivityid(resultSet.getInt("activityid"));
				inwardpayment.setAmountpaid(resultSet.getInt("amountpaid"));
				inwardpayment.setDatepaid(resultSet.getDate("datepaid"));
				inwardpayment.setFlatno(resultSet.getInt("flatno"));
				inwardpayment.setIspaid(resultSet.getBoolean("ispaid"));
				inwardpayment.setIssueid(resultSet.getInt("issueid"));
				inwardpayment.setLastdate(resultSet.getString("lastdate"));
				inwardpayment.setMonthyear(resultSet.getString("monthyear"));
				inwardlist.add(inwardpayment);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return inwardlist;
		
		
	}


}
