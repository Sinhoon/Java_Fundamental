package java_20191125;

public class MemberDemo {
	public static void main(String[] args) {
		Member m = new Member();
		m.setName("sinhoon");
		m.setAddress1("서울");
		m.setAddress2("성동구");
		m.setAge(20);
		m.setHeight(178.5);
		m.setEmail("losee@naver.com");
		m.setPassword("1234");
		m.setSsn("1234-567");
		m.setZipcode("25121");
		
		System.out.println(m.getName());
	}
}
