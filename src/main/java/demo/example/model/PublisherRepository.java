package demo.example.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PublisherRepository extends JpaRepository<Publisher, String> {

	@Query(value = "SELECT publisherName FROM bookshop.publisher;", nativeQuery = true)
	public List<String> getAllPublisherName();
	
	@Query(value = "SELECT publisherName FROM bookshop.publisher where publisherID = :publisherID;", nativeQuery = true)
	public String getPublisherNameById(@Param("publisherID") String publisherID);
}
