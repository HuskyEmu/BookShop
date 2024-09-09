package demo.example.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.example.model.*;
import demo.example.service.*;
import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/mem")
public class MemberControllerTwo {

	@Autowired
	private MemberService ms;

	@Autowired
	private MemberRepository mr;

	// getAllMembers
	@GetMapping
	public ResponseEntity<List<Member>> getAllMembers() {
		List<Member> members = ms.getAllMembers();
		return ResponseEntity.ok(members);
	}

	// build create member REST API
	@PostMapping
	public ResponseEntity<Member> creatMember(@RequestBody Member member) {
		Member m = ms.createMember(member);
		return new ResponseEntity<>(m, HttpStatus.CREATED);
	}

	// build get member by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable("id") String memberId) {
		Member m = ms.getMemberById(memberId);
		return ResponseEntity.ok(m);
	}

	// build update member REST API
	@PutMapping("{id}")
	public ResponseEntity<Member> updateMember(@PathVariable("id") String memberId, @RequestBody Member member) {
		Member m = ms.updateMember(memberId, member);
		return ResponseEntity.ok(m);
	}

	// build delete member REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteMember(@PathVariable("id") String memberId) {
		ms.deleteMember(memberId);
		return ResponseEntity.ok("Member：" + memberId + " deleted successfully!");
	}

	
	
	// 比對有此組帳號&信箱的方法
	@PostMapping("/checkUser")
	public Map<String, Boolean> checkUserExists(@RequestBody Member member) {
		String account = member.getAccount();
		String email = member.getEmail();

		boolean existsByAccount = ms.existsByAccount(account);
		boolean existsByEmail = ms.existsByEmail(email);

		return Map.of("existsByAccount", existsByAccount, "existsByEmail", existsByEmail);
	}

	// 比對有此組帳號&密碼的方法-尚未加上admin版本的
	@PostMapping("/checkLogin")
	public Map<String, Boolean> checkUserLogin(@RequestBody Member member) {
		String account = member.getAccount();
		String password = member.getPassword();

		boolean existsByAccount = ms.existsByAccount(account);
		boolean existsByPassword = ms.existsByPassword(password);

		return Map.of("existsByAccount", existsByAccount, "existsByPassword", existsByPassword);
	}
	
	// 比對有此組帳號&密碼的方法-admin版
	@PostMapping("/checkLoginAdmin")
	public Map<String, Boolean> checkUserLoginAdmin(@RequestBody Member member) {
		String account = member.getAccount();
		String password = member.getPassword();

		boolean isAdminAccount = "admin".equals(account);
		boolean isAdminPassword = "admin".equals(password);
		boolean isSuccess = "admin".equals(account)&& "admin".equals(password);
		

		return Map.of(
				"isAdminAccount", isAdminAccount, 
				"isAdminPassword", isAdminPassword,
				"success",isSuccess);
	}

	
	
	//忘記密碼=>更新密碼
	@GetMapping("/find/{account}/{email}")
	public List<Member> getByAccountAndEmail(@PathVariable("account") String account,
			@PathVariable("email") String email) {
		return mr.findByAccountAndEmail(account, email);
	}
	
	//已登入=>以帳號更新會員資料
    @GetMapping("/find/{account}")
    public Member getByAccount(@PathVariable("account") String account) {
        return mr.findByAccount(account);
    }
    
	//藉由帳號信箱比對=>更新密碼
    @PutMapping("/update/{account}/{email}")
    public ResponseEntity<Member> updateMemberByAccountAndEmail(
            @PathVariable("account") String account,
            @PathVariable("email") String email, 
            @RequestBody Member member) {

        Member updatedMember = ms.updateMemberByAccountAndEmail(account, email, member);
        if (updatedMember == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(updatedMember);
        }
    }
    
	//藉由帳號比對=>更新會員(姓名/手機/信箱)
    @PutMapping("/update/{account}")
    public ResponseEntity<Member> updateMemberByAccount(
            @PathVariable("account") String account,
            @RequestBody Member member) {

        Member updatedMember = ms.updateMemberByAccount(account, member);
        if (updatedMember == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(updatedMember);
        }
    }

    //////////////////////////
    ////在登入成功後設定 HttpSession 屬性  沒用到後端session
    @PostMapping("/login")
    public ResponseEntity<Map<String, Boolean>> login(@RequestBody Member member, HttpSession session) {
    	 // 確認帳號和密碼
        Map<String, Boolean> loginResult = ms.checkUserLogin(member.getAccount(), member.getPassword());

        // 確保 loginResult 預設也有值
        boolean isAccountExist = loginResult.getOrDefault("existsByAccount", false);
        boolean isPasswordCorrect = loginResult.getOrDefault("existsByPassword", false);

        boolean isAuthenticated = isAccountExist && isPasswordCorrect;
        
        if (isAuthenticated) {
            // 獲取會員資料
            Member authenticatedMember = mr.findByAccount(member.getAccount());

            // 設定 session 屬性
            session.setAttribute("loginstatus", "user");
            session.setAttribute("account", authenticatedMember.getAccount());
            session.setAttribute("memberName", authenticatedMember.getMemberName());
            session.setAttribute("memberLevel", authenticatedMember.getMemberLevel());
            session.setAttribute("email", authenticatedMember.getEmail());
            session.setAttribute("phone", authenticatedMember.getPhone());
            session.setAttribute("totalAmount", authenticatedMember.getTotalAmount());
            
            return ResponseEntity.ok(Map.of("existsByAccount", true, "existsByPassword", true));
            //return ResponseEntity.ok("登入成功");
        } else {
            //return ResponseEntity.status(401).body("登入失敗: 帳號或密碼錯誤");
        	 return ResponseEntity.ok(Map.of("existsByAccount", isAccountExist, "existsByPassword", isPasswordCorrect));
        }
    }
    
    
    /*   後端session-postman可成功
    @GetMapping("/profile")
    public ResponseEntity<Map<String, String>> getProfile(HttpSession session) {
        // 確保帳號存在於 session 中
        String account = (String) session.getAttribute("account");
        if (account == null) {
            // 用戶未登入，返回 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "未登入"));
        }

        // 根據帳號從資料庫中查詢會員資料
        Member member = mr.findByAccount(account);
        if (member == null) {
            // 如果會員資料為 null，返回 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "會員資料不存在"));
        }

        // 構建會員資料
        Map<String, String> profile = new HashMap<>();
        profile.put("account", member.getAccount());
        profile.put("memberName", member.getMemberName());
        profile.put("memberLevel", String.valueOf(member.getMemberLevel()));
        profile.put("phone", member.getPhone());
        profile.put("email", member.getEmail());
        profile.put("totalAmount", String.valueOf(member.getTotalAmount()));

        // 返回會員資料
        return ResponseEntity.ok(profile);
    }*/
    
    // 獲取會員資料-後端-沒用到先放著
    @GetMapping("/profile")
    public ResponseEntity<Member> getProfile(HttpSession session) {
    	
        String account = (String) session.getAttribute("account");

        if (account == null) {
            return ResponseEntity.status(401).body(null); // 用戶未登入
        }

        // 根據帳號從資料庫中查詢會員資料
        Member member = mr.findByAccount(account);
        if (member == null) {
            // 如果會員資料為 null，返回錯誤響應
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(member);
    }
    
    
    ////更新資料-後端-沒用到先放著
    @PostMapping("/updateProfile")
    public ResponseEntity<String> updateProfile(@RequestBody Member updatedMember, HttpSession session) {
        String account = (String) session.getAttribute("account");

        if (account == null) {
            return ResponseEntity.status(401).body("用戶未登入");
        }

        Member existingMember = mr.findByAccount(account);
        if (existingMember == null) {
            return ResponseEntity.status(404).body("找不到會員");
        }

        // 更新資料
        existingMember.setMemberName(updatedMember.getMemberName());
        existingMember.setPhone(updatedMember.getPhone());
        existingMember.setEmail(updatedMember.getEmail());
        // 如果需要更新 totalAmount，請確保這是合理的
        existingMember.setTotalAmount(updatedMember.getTotalAmount());

        mr.save(existingMember); // 保存更新後的資料

        return ResponseEntity.ok("會員資料已更新");
    }


  
    ////確認登入狀態-沒用到先放著
    @GetMapping("/checkLoginStatus")
    public ResponseEntity<String> checkLoginStatus(HttpSession session) {
        String loginStatus = (String) session.getAttribute("loginstatus");
        if ("user".equals(loginStatus)) {
            return ResponseEntity.ok("用戶已登入");
        } else {
            return ResponseEntity.status(401).body("用戶未登入");
        }
    }
}
