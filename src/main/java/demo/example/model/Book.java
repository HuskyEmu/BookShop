package demo.example.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;



@Entity
@Table(name="book")
public class Book {
	@Id
	private String bookId;
	
	private String bookName;
	
	private String author;
	
	private String isbn;
	
	private String category;
	
	private String publisherId;
	
	private String image;
	
	private BigDecimal price;
	
	private String descriptioned;
	
	private Integer salesQuantity;
	
	private BigDecimal totalRating;
	
	private LocalDateTime addedTime;

	public Book() {}
	
	@Override
	public int hashCode() {
		return Objects.hash(addedTime, author, bookId, bookName, category, descriptioned, image, isbn, price, publisherId,
				salesQuantity, totalRating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(addedTime, other.addedTime) && Objects.equals(author, other.author)
				&& Objects.equals(bookId, other.bookId) && Objects.equals(bookName, other.bookName)
				&& Objects.equals(category, other.category) && Objects.equals(descriptioned, other.descriptioned)
				&& Objects.equals(image, other.image) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(price, other.price) && Objects.equals(publisherId, other.publisherId)
				&& Objects.equals(salesQuantity, other.salesQuantity) && Objects.equals(totalRating, other.totalRating);
	}

	@Override
	public String toString() {
		return "book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", isbn=" + isbn
				+ ", category=" + category + ", publisherId=" + publisherId + ", image=" + image + ", price=" + price
				+ ", description=" + descriptioned + ", salesQuantity=" + salesQuantity + ", totalRating=" + totalRating
				+ ", addedTime=" + addedTime + "]";
	}

	public Book(String bookId, String bookName, String author, String isbn, String category, String publisherId,
			String image, BigDecimal price, String description, Integer salesQuantity, BigDecimal totalRating,
			LocalDateTime addedTime) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.isbn = isbn;
		this.category = category;
		this.publisherId = publisherId;
		this.image = image;
		this.price = price;
		this.descriptioned = description;
		this.salesQuantity = salesQuantity;
		this.totalRating = totalRating;
		this.addedTime = addedTime;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescriptioned() {
		return descriptioned;
	}

	public void setDescriptioned(String description) {
		this.descriptioned = description;
	}

	public Integer getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(Integer salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public BigDecimal getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(BigDecimal totalRating) {
		this.totalRating = totalRating;
	}

	public LocalDateTime getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(LocalDateTime addedTime) {
		this.addedTime = addedTime;
	}
	
	
}
