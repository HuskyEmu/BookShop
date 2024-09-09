package demo.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@Column(name = "memberID")
	private String memberId;
	
	@Column(name = "memberName")
	private String memberName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "memberLevel")
	private char memberLevel;
	
	@Column(name = "account")
	private String account;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "totalAmount")
	private Double totalAmount;

	public Member() {
		super();
	}

	public Member(String memberId, String memberName, String phone, char memberLevel, String account, String password,
			String email, Double totalAmount) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.memberLevel = memberLevel;
		this.account = account;
		this.password = password;
		this.email = email;
		this.totalAmount = totalAmount;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(char memberLevel) {
		this.memberLevel = memberLevel;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", phone=" + phone + ", memberLevel="
				+ memberLevel + ", account=" + account + ", password=" + password + ", email=" + email
				+ ", totalAmount=" + totalAmount + "]";
	}
}
