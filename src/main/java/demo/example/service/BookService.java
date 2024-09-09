package demo.example.service;

import java.util.List;

import demo.example.model.Book;

public interface BookService {
	
	List<Book> showAllBook();
	
	Book createBook(Book book);
	
	Book getBookById(String bookId);
	
	Book updateBook(String bookId, Book book);
	
	boolean deleteBook(String bookId);
	
	List<Book> getBookByPublisherId(String publisherId);
	
	List<Book> getBookByCategory(String category);
	
	public List<String> getAllCategory();
	
	public List<Book> getBookByCategory();
}
