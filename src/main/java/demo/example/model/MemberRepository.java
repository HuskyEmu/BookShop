package demo.example.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, String> {

	@Query(value = "SELECT memberName FROM bookshop.member where memberLevel = :level;", nativeQuery = true)
	public List<String> getmNameByLevel(@Param("level") char lastName);

	// 自定義
	List<Member> findByAccountAndEmail(String account, String email);

	Member findByAccount(String account);
}
