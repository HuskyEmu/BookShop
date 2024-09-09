package demo.example.model;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;
//表單接收上傳的資料

public class BookForm {
	private String bookId;

	private String bookName;

	private String author;

	private String isbn;

	private String category;

	private String publisherId;
	
	private BigDecimal price;

	private String descriptioned;

	//接收圖片
	private MultipartFile imgData;

	public BookForm() {
		super();
	}

	public BookForm(String bookId, String bookName, String author, String isbn, String category, String publisherId,
			BigDecimal price, String descriptioned, MultipartFile imgData) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.isbn = isbn;
		this.category = category;
		this.publisherId = publisherId;
		this.price = price;
		this.descriptioned = descriptioned;
		this.imgData = imgData;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescriptioned() {
		return descriptioned;
	}

	public void setDescriptioned(String descriptioned) {
		this.descriptioned = descriptioned;
	}

	public MultipartFile getImgData() {
		return imgData;
	}

	public void setImgData(MultipartFile imgData) {
		this.imgData = imgData;
	}
	

	


	
}
