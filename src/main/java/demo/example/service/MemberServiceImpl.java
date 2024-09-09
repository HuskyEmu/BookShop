package demo.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import demo.example.model.Member;
import demo.example.model.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository mr;

	@Autowired
	private JavaMailSender emailSender;


	//寄送郵件用
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("kofjerry@yahoo.com.tw"); // 發信信箱
		message.setTo(to); // 收信信箱
		message.setSubject(subject); // 信標題
		message.setText(text); // 信內容
		emailSender.send(message);
	}

	@Override
	public List<Member> getAllMember() {
		List<Member> members = mr.findAll();
		return members;
	}

	@Override
	public Member creatMember(Member member) {
		return mr.save(member);
	}

	@Override
	public Member getMemberById(String memberId) {
		return mr.findById(memberId).get();
	}

	@Override
	public Member updateMember(String memberId, Member member) {
		Member m = mr.findById(memberId).get();
		m.setMemberName(member.getMemberName());
		m.setPhone(member.getPhone());
		m.setMemberLevel(member.getMemberLevel());
		m.setAccount(member.getAccount());
		m.setPassword(member.getPassword());
		m.setEmail(member.getEmail());
		m.setTotalAmount(member.getTotalAmount());
		return mr.save(m);
	}

	@Override
	public void deleteMember(String memberId) {
		mr.deleteById(memberId);
	}

	@Override
	public List<String> getmNameByLevel(char level) {
		return mr.getmNameByLevel(level);
	}

	// getAllMembers
	@Override
	public List<Member> getAllMembers() {
		List<Member> members = mr.findAll();
		return members;
	}

	@Override
	public Member createMember(Member member) {
		// 取得當前最大的 memberId，並且將 "m" 字母去掉，只取數字部分
		int maxId = mr.findAll().stream().map(e -> e.getMemberId().substring(1)) // 移除 "m" 字母
				.mapToInt(Integer::parseInt).max().orElse(0); // 如果沒有會員，則預設從 0 開始

		// 將 maxId 加 1，並生成新的 ID 格式 "mXXX"
		String newMemberId = "m" + String.format("%03d", maxId + 1); // 保證數字部分是三位數

		member.setMemberId(newMemberId);
		member.setMemberLevel('A'); // 註冊會員預設等級A
		member.setTotalAmount(0.0); // 消費金額預設0.0
		
		System.out.println(member.getEmail());
		sendSimpleMessage(member.getEmail(), "註冊成功!", "成功註冊為煞氣の書店會員，歡迎光臨!!!");
		return mr.save(member);
	}

	// 比對方法-存在帳號
	@Override
	public boolean existsByAccount(String account) {
		return mr.findAll().stream().anyMatch(member -> member.getAccount().equals(account));
	}

	// 比對方法-存在信箱
	@Override
	public boolean existsByEmail(String email) {
		return mr.findAll().stream().anyMatch(member -> member.getEmail().equals(email));
	}

	// 比對方法-存在密碼
	@Override
	public boolean existsByPassword(String password) {
		return mr.findAll().stream().anyMatch(member -> member.getPassword().equals(password));
	}

	// 比對方法：帳號+信箱
	@Override
	public Map<String, Boolean> checkUserExists(String account, String email) {

		Map<String, Boolean> result = new HashMap<>();

		boolean existsByAccount = mr.findAll().stream().anyMatch(member -> member.getAccount().equals(account));
		boolean existsByEmail = mr.findAll().stream().anyMatch(member -> member.getEmail().equals(email));

		result.put("existsByAccount", existsByAccount);
		result.put("existsByEmail", existsByEmail);

		return result;
	}

	// 比對方法：帳號+密碼
	@Override
	public Map<String, Boolean> checkUserLogin(String account, String password) {
		Map<String, Boolean> result = new HashMap<>();

		boolean existsByAccount = mr.findAll().stream().anyMatch(member -> member.getAccount().equals(account));
		boolean existsByPassword = mr.findAll().stream().anyMatch(member -> member.getPassword().equals(password));

		result.put("existsByAccount", existsByAccount);
		result.put("existsByPassword", existsByPassword);

		return result;
	}

	// 比對方法-存在帳號-admin
	@Override
	public boolean existsByAccountAdmin(String account) {
		return "admin".equals(account);
	}

	// 比對方法-存在密碼-admin
	@Override
	public boolean existsByPasswordAdmin(String password) {
		return "admin".equals(password);
	}

	// 比對方法：帳號+密碼-admin
	@Override
	public Map<String, Boolean> checkUserAdmin(String account, String password) {
		Map<String, Boolean> result = new HashMap<>();

		boolean isAdminAccount = "admin".equals(account);
		boolean isAdminPassword = "admin".equals(password);

		result.put("existsByAccountAdmin", isAdminAccount);
		result.put("existsByPasswordAdmin", isAdminPassword);

		return result;
	}

	// 忘記密碼=>以帳號信箱查到該筆會員資料
	@Override
	public Member findByAccountAndEmail(String account, String email) {
		return mr.findByAccountAndEmail(account, email).stream().findFirst().orElse(null);
	}

	// 藉由帳號信箱比對=>更新密碼
	@Override
	public Member updateMemberByAccountAndEmail(String account, String email, Member member) {
		Member m = findByAccountAndEmail(account, email);
		if (m == null) {
			return null;
		}
		m.setPassword(member.getPassword()); // 設置新的密碼
		return mr.save(m);
	}

	// 忘記密碼=>以帳號信箱查到該筆會員資料
	@Override
	public Member findByAccount(String account) {
		return mr.findByAccount(account);
	}

	// 已登入=>藉由帳號比對=>更新姓名/手機/信箱
	@Override
	public Member updateMemberByAccount(String account, Member member) {
		Member m = findByAccount(account);
		if (m == null) {
			return null;
		}
		m.setMemberName(member.getMemberName()); // 更新姓名
		m.setEmail(member.getEmail()); // 更新信箱
		m.setPhone(member.getPhone()); // 更新手機
		return mr.save(m);
	}
}
