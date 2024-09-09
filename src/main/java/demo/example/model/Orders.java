package demo.example.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ordersId;
	String bookId;
	int quantity;
	String memberId;
	Date purchaseTime;
	BigDecimal price;
	String activityId;
	public Orders() {
		super();
	}
	public Orders(int ordersId, String bookId, int quantity, String memberId, Date purchaseTime, BigDecimal price) {
		super();
		this.ordersId = ordersId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.memberId = memberId;
		this.purchaseTime = purchaseTime;
		this.price = price;
	}
	public Orders(int ordersId, String bookId, int quantity, String memberId, Date purchaseTime, BigDecimal price,
			String activityId) {
		super();
		this.ordersId = ordersId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.memberId = memberId;
		this.purchaseTime = purchaseTime;
		this.price = price;
		this.activityId = activityId;
	}
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
}
