package demo.example.service;

import java.util.List;
import java.util.Map;

import demo.example.model.Member;

public interface MemberService {
	List<Member> getAllMember();
	
	Member creatMember(Member member);
	
	Member getMemberById(String memberId);
	
	Member updateMember (String memberId,Member member);
	
	void deleteMember(String memberId);
	
	List<String> getmNameByLevel(char level);
	
	
	List<Member> getAllMembers();
	Member createMember(Member member);

	//登入比對資料庫用
	boolean existsByAccount(String account);
	boolean existsByPassword(String password);
	boolean existsByEmail(String email);
	Map<String, Boolean> checkUserExists(String account, String email);
	Map<String, Boolean> checkUserLogin(String account, String password);
	
	//登入時確認是否為管理者帳號
	boolean existsByAccountAdmin(String account);
	boolean existsByPasswordAdmin(String password);
	Map<String, Boolean> checkUserAdmin(String account, String password);
	
	//忘記密碼=>藉由帳號信箱比對=>更新密碼
	Member findByAccountAndEmail(String account, String email);
	Member updateMemberByAccountAndEmail(String account,String email, Member member);
	
	//已登入=>藉由帳號比對=>更新姓名/手機/信箱
	Member findByAccount(String account);
	Member updateMemberByAccount(String account, Member member);

	//註冊時寄出確認電子郵件
	void sendSimpleMessage(String to, String subject, String text);
}

