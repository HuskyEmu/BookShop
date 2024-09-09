package demo.example.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="activity")
public class Activity {

	@Id
	String activityId;
	String category;
	String info;
	String activityName;
	@Column(columnDefinition = "decimal")
	double discountRate;
	int discountAmount;
	Date beginTime;
	Date endTime;
	boolean status;
	public List<Activity> orElse(List<Object> emptyList) {
		// TODO Auto-generated method stub
		return null;
	}
	public Activity() {
		super();
	}
	public Activity(String activityId, String category, String info, String activityName, double discountRate,
			int discountAmount, Date beginTime, Date endTime, boolean status) {
		super();
		this.activityId = activityId;
		this.category = category;
		this.info = info;
		this.activityName = activityName;
		this.discountRate = discountRate;
		this.discountAmount = discountAmount;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.status = status;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public int getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
