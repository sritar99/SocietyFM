package com.sfm.model;

public class MonthlyActivities {
	
	
	private Integer id;
	private String activityname;
	private String month;
	private String lastdate;
	private Integer amount;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
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
	@Override
	public String toString() {
		return "MonthlyActivities [id=" + id + ", activityname=" + activityname + ", month=" + month + ", lastdate="
				+ lastdate + ", amount=" + amount + "]";
	}
}
