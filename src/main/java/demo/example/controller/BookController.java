package demo.example.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import demo.example.model.Book;
import demo.example.model.BookForm;
import demo.example.service.BookService;
import demo.example.service.BookServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bs;

	@GetMapping(value = "/category")
	public ResponseEntity<List<String>> getAllCategory() {
		List<String> cats = bs.getAllCategory();
		return ResponseEntity.ok(cats);
	}

	@Autowired
	private BookServiceImpl bsi;

	
	// BookServiceImpl 本機存放圖檔的位置 要手動改為本機地址
	
	
	//首頁點擊顯示一本書 ->view bookDetail2.html
	@GetMapping("/bookDetail2/{bookId}")
	public ModelAndView getImageByCode(@PathVariable("bookId") String bookId) {
		Book b =bsi.getBookById(bookId);
		ModelAndView mv = new ModelAndView("bookDetail2");
		mv.addObject("book", b);
		return mv;
	}
	

	
	
	//-----------------------------------------------------------------
	
	

	/**
	 * 展示所有書
	 * 
	 * @param void
	 * @return all entities(book)
	 */
	@GetMapping(value = "/showall")
	public List<Book> showAllBook() {
		System.out.println("showall called");
		List<Book> bList = bsi.showAllBook();
		Collections.shuffle(bList); //打亂順序
		// 返回List<Book> Json格式
		return bList;
	}

	
	/**
	 * 靠書id尋找書
	 * 
	 * @param bookId
	 * @return entities(book)
	 */
	@GetMapping("/bi/{bookId}")
	public Book getBookById(@PathVariable("bookId") String bookId) {
		Book book = bsi.getBookById(bookId);
		return book;
	}

	/**
	 * 靠出版社id尋找書
	 * 
	 * @param publisherId
	 * @return List<Book>
	 */
	@GetMapping("/pi/{publisherId}")
	public List<Book> getBookByPublisherId(@PathVariable("publisherId") String publisherId) {
		List<Book> bList = null;
		bList = bsi.getBookByPublisherId(publisherId);
		return bList;
	}

	/**
	 * 上架書(含圖片)
	 * 
	 * @param BookForm
	 * @return entities(book)
	 */
	@PostMapping("/upload")
	public Book createBook(@ModelAttribute("bookForm") BookForm bookForm) {
		Book b = bsi.createBook(bookForm);
		return b;
	}

	/**
	 * 靠id修改書
	 * 
	 * @param String bookId , Book book
	 * @return 修改成功返回entities(book)否則返回null
	 */
	@PutMapping("/put/{bookId}")
	public Book updateBook(@PathVariable("bookId") String bookId, @RequestBody Book book) {
		Book b = bsi.updateBook(bookId, book);
		return (b != null) ? b : null; // 返回物件或null
	}

	/**
	 * 靠id刪除書
	 * 
	 * @param String bookId
	 * @return boolean
	 */
	@DeleteMapping("/delete/{bookId}")
	public boolean deleteBook(@PathVariable("bookId") String bookId) {

		return bsi.deleteBook(bookId);
	}

	/**
	 * 靠類別名尋找書
	 * 
	 * @param String
	 * @return List<Book>
	 */
	@GetMapping("/cg/{category}")
	public List<Book> getBookByCategory(@PathVariable("category") String category) {
		List<Book> bList = null;
		bList = bsi.getBookByCategory(category);
		return bList;
	}


}
