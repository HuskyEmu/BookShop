package demo.example.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingcartlist")
public class ShoppingcartView {

	@Id
	String memberId;
	String memberName;
	String bookId;
	String bookName;
	String author;
	String publisherName;
	String category;
	int quantity;
	BigDecimal price;
	public ShoppingcartView() {
		super();
	}
	public ShoppingcartView(String memberId, String memberName, String bookId, String bookName, String author,
			String publisherName, String category, int quantity, BigDecimal price) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publisherName = publisherName;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
