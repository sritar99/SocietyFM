package com.sfm.model;

import java.sql.Date;

public class InwardPayments {

	private Integer issueid;
	private Integer flatno;
	private Integer activityid;
	private String name;
	private String monthyear;
	private String lastdate;
	private Integer amount;
	private Integer amountpaid;
	private boolean ispaid;
	private Date datepaid;
	public Integer getIssueid() {
		return issueid;
	}
	public void setIssueid(Integer issueid) {
		this.issueid = issueid;
	}
	public Integer getFlatno() {
		return flatno;
	}
	public void setFlatno(Integer flatno) {
		this.flatno = flatno;
	}
	public Integer getActivityid() {
		return activityid;
	}
	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMonthyear() {
		return monthyear;
	}
	public void setMonthyear(String monthyear) {
		this.monthyear = monthyear;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getAmountpaid() {
		return amountpaid;
	}
	public void setAmountpaid(Integer amountpaid) {
		this.amountpaid = amountpaid;
	}
	public boolean isIspaid() {
		return ispaid;
	}
	public void setIspaid(boolean ispaid) {
		this.ispaid = ispaid;
	}
	public Date getDatepaid() {
		return datepaid;
	}
	public void setDatepaid(Date datepaid) {
		this.datepaid = datepaid;
	}
	@Override
	public String toString() {
		return "InwardPayments [issueid=" + issueid + ", flatno=" + flatno + ", activityid=" + activityid + ", name="
				+ name + ", monthyear=" + monthyear + ", lastdate=" + lastdate + ", amount=" + amount + ", amountpaid="
				+ amountpaid + ", ispaid=" + ispaid + ", datepaid=" + datepaid + "]";
	}
	

	
}
