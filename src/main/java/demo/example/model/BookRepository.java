package demo.example.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	@Query(value = "SELECT category FROM bookshop.book group by category;", nativeQuery = true)
	public List<String> getAllCategory();

	@Query(value = "SELECT * FROM bookshop.book where category='商業理財';", nativeQuery = true)
	public List<Book> get();

//	如果需要執行原生 SQL 查詢，可以使用 nativeQuery 屬性將查詢指定為原生 SQL。
//	@Query(value = "SELECT * FROM employees WHERE last_name = :lastName", nativeQuery = true)
//	List<Employee> findCustomByLastName(@Param("lastName") String lastName);

	// 查詢最後一筆資料
	@Query(value = "SELECT * FROM `book` ORDER BY bookid DESC LIMIT 1;", nativeQuery = true)
	public Book getLastData();
	
	
}
