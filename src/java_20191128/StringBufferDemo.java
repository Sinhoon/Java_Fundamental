package java_20191128;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("test");
		StringBuffer s2 = new StringBuffer("test");
		// stringbuffer object의 equal()메소드 overriding 하지 않았다.
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.toString().equals(s2.toString()));

		StringBuffer sql = new StringBuffer();
		sql.append("select name,age");
		sql.append(" from member");
		System.out.println(sql);
		sql.setLength(0);
		System.out.println(sql);
		

	}
}
