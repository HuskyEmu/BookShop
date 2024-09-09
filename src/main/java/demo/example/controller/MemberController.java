package demo.example.controller;

import java.util.List;

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

import demo.example.model.Member;
import demo.example.service.MemberService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService ms;

	@GetMapping
	public ResponseEntity<List<Member>> getAllMembers() {
		List<Member> members = ms.getAllMember();
		return ResponseEntity.ok(members);
	}

	// build create employee REST API
	@PostMapping
	public ResponseEntity<Member> creatMember(@RequestBody Member member) {
		Member m = ms.creatMember(member);
		return new ResponseEntity<>(m, HttpStatus.CREATED);
	}

	// build get employee by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable("id") String memberId) {
		Member m = ms.getMemberById(memberId);
		return ResponseEntity.ok(m);
	}
	
	@GetMapping("/MemberName/{id}")
	public ResponseEntity<String> getMemberNameById(@PathVariable("id") String memberId) {
		Member m = ms.getMemberById(memberId);
		return ResponseEntity.ok(m.getMemberName());
	}

	// build update employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Member> updateMember(@PathVariable("id") String memberId, @RequestBody Member member) {
		Member m = ms.updateMember(memberId, member);
		return ResponseEntity.ok(m);
	}

	// build delete employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteMember(@PathVariable("id") String memberId) {
		ms.deleteMember(memberId);
		return ResponseEntity.ok("Member：" + memberId + " deleted successfully!");
	}
	
	@GetMapping("/test/{level}")
	public ResponseEntity<List<String>> getmName(@PathVariable("level") char level) {
		List<String> m = ms.getmNameByLevel(level);
		return ResponseEntity.ok(m);
	}
}
