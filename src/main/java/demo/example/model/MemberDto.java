package demo.example.model;

public class MemberDto {
	private String memberId;
	private String memberName;
	private String phone;
	private Character memberLevel;

	private String account;
	private String password;
	private String email;
	private Double totalAmount;
	
	//shoppingCartId , ordersId
	private Integer shoppingCartId;
	private String ordersId;
	public MemberDto() {
		super();
	}
	public MemberDto(String memberId, String memberName, String phone, Character memberLevel, String account,
			String password, String email, Double totalAmount, Integer shoppingCartId, String ordersId) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.memberLevel = memberLevel;
		this.account = account;
		this.password = password;
		this.email = email;
		this.totalAmount = totalAmount;
		this.shoppingCartId = shoppingCartId;
		this.ordersId = ordersId;
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
	public Character getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(Character memberLevel) {
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
	public Integer getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(Integer shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public String getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(String ordersId) {
		this.ordersId = ordersId;
	}
	
	
}
