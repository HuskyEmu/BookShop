package demo.example.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import demo.example.model.Book;
import demo.example.model.BookForm;
import demo.example.model.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	LocalDateTime currentDateTime = LocalDateTime.now();

	@Autowired
	private BookRepository dao;

	/**
	 * 展示所有書
	 * 
	 * @param void
	 * @return all entities(book)
	 */
	public List<Book> showAllBook() {
		// 返回List<Book> Json格式
		return dao.findAll();
	}

	/**
	 * 上架書(含圖片)
	 * 
	 * @param BookForm
	 * @return entities(book)
	 */
	public Book createBook(BookForm bookForm) {	
		Book b2sql = new Book(); 
		b2sql.setBookId("");
		b2sql.setBookName(bookForm.getBookName());
		b2sql.setAuthor(bookForm.getAuthor());
		b2sql.setPrice(bookForm.getPrice());
		b2sql.setIsbn(bookForm.getIsbn());
		b2sql.setCategory(bookForm.getCategory());
		b2sql.setPublisherId(bookForm.getPublisherId());
		b2sql.setDescriptioned(bookForm.getDescriptioned());
		b2sql.setAddedTime(currentDateTime);
		try {
			if (bookForm.getImgData() != null) {
				try {
					MultipartFile imgData =bookForm.getImgData();
					String originalFilename = imgData.getOriginalFilename();
					// 本機存放圖檔的位置
					Path bookPath = Paths
							.get("C:/workspace-web2024/bookshop/src/main/resources/static/img/book/" + originalFilename);
					// 生成書的圖檔
					imgData.transferTo(new File(bookPath.toString()));
					//將前端路徑存入sql
					b2sql.setImage("/img/book/" + originalFilename);
				} catch (IOException e) {
					System.out.println("bookForm" + e);
				}	
			}
			dao.save(b2sql);
			b2sql = dao.getLastData(); // 獲取最新資料
			System.out.println(bookForm.getBookName() + " : Saved");
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
		return b2sql;
	}

	/**
	 * 靠書id尋找書
	 * 
	 * @param String
	 * @return entities(book)
	 */
	public Book getBookById(String bookId) {
		Book b = null;
		try {
			b = dao.findById(bookId).orElseThrow(() -> new Exception("Book not exist with id: " + bookId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 靠id修改書
	 * 
	 * @param String , Book
	 * @return 修改成功返回entities(book)否則返回null
	 */
	public Book updateBook(String bookId, Book book) {
//		1.id獲取資料
//		2.同id物件 br.save(book);會直接修改內容
		Book b = null; // 建立空物件
		b = getBookById(bookId); // 透過id找物件如果有則放入b
		if (b != null) {
			b = book; // 將參數物件book覆蓋b
			dao.save(b); // 將物件存入sql
		}
		return (b != null) ? b : null; // 返回物件或null
	}

	/**
	 * 靠id刪除書
	 * 
	 * @param String
	 * @return boolean
	 */
	public boolean deleteBook(String bookId) {
		Book b = null; // 建立空物件
		boolean flag = false;
		b = getBookById(bookId); // 透過id找物件如果有則放入b
		if (b != null) {
			dao.delete(b); // 如果b有value則刪除
			flag = true; // 刪除成功設為true
		}
		return flag;
	}

	/**
	 * 靠出版社id尋找書
	 * 
	 * @param publisherId
	 * @return List<Book>
	 */
	public List<Book> getBookByPublisherId(String publisherId) {
		List<Book> bList = dao.findAll().stream().filter(e1 -> e1.getPublisherId().equals(publisherId))
				.collect(Collectors.toList());
		return bList;
	}

	/**
	 * 靠類別名尋找書
	 * 
	 * @param String
	 * @return List<Book>
	 */
	@Override
	public List<Book> getBookByCategory(String category) {
		List<Book> bList = dao.findAll().stream().filter(e1 -> e1.getCategory().equals(category))
				.collect(Collectors.toList());
		return bList;
	}

	/**
	 * 2024/08/19 sql設定triggers 會自增id 這方法暫時不用 產生符合指定格式並補足數字部分的字串編號
	 * 
	 * @param sqlCount 目前sql內的資料筆數
	 * @return 如果編號符合格式則返回補足後的編號，否則返回 null
	 */
	private String bookIdMaker(Long sqlCount) {
		StringBuilder sb = new StringBuilder();
		// 定義正則表達式，匹配四位數字的編號
		String idPattern = "^(\\d{1,4})$";
		// 將sql筆數+1 設為新增的id
		sqlCount += 1;

		String sqlCountStr = sqlCount.toString();
		// 使用正則表達式進行匹配
		Pattern pattern = Pattern.compile(idPattern);
		Matcher matcher = pattern.matcher(sqlCountStr);

		if (matcher.matches()) {
			String numberPart = matcher.group(1);
			// 補足"b"+數字部分，確保為四位數字
			return "b" + String.format("%04d", Integer.parseInt(numberPart));
		} else {
			return null; // 編號格式不正確
		}
	}
	
	//
	public List<String> getAllCategory() {
		return dao.getAllCategory();
	}

	@Override
	public List<Book> getBookByCategory() {

		return dao.get();
	}

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

}
