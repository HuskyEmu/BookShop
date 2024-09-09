package demo.example.model;

public class MemberMapper {
	   public static MemberDto  mapToMemberDto(Member mem)
	   {
		   MemberDto dto=new MemberDto();

		   dto.setMemberId(mem.getMemberId());
		   dto.setMemberName(mem.getMemberName());
		   dto.setPhone(mem.getPhone());
		   dto.setMemberLevel(mem.getMemberLevel());
		   dto.setAccount(mem.getAccount());
		   dto.setPassword(mem.getPassword());
		   dto.setEmail(mem.getEmail());
		   dto.setTotalAmount(mem.getTotalAmount());
		  
		   // Dto才有多的
		   dto.setShoppingCartId(1);
		   dto.setOrdersId("1");
		   return dto;
	   }
	  
	   public static Member  mapToMember(MemberDto mem)
	   {
		   Member m=new Member();
		   m.setMemberId(mem.getMemberId());
		   m.setMemberName(mem.getMemberName());
		   m.setPhone(mem.getPhone());
		   m.setMemberLevel(mem.getMemberLevel());
		   m.setAccount(mem.getAccount());
		   m.setPassword(mem.getPassword());
		   m.setEmail(mem.getEmail());
		   m.setTotalAmount(mem.getTotalAmount()); 
		   
		   return m;
	   }

}
