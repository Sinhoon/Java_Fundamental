package java_20191119;

public class CharLiteralDemo {
	public static void main(String[] args) {
		//1. 유니코드 표현 = > '\u0000'
		char c1 ='\uC2E0';
		char c2 ='\uD6C8';
		System.out.print(c1);
		System.out.println(c2);
		
		//2. 아스키코드 표현   
		// 48 57  > 0 9
		// 65 90  > A Z
 		// 97 122 > a z
		char c3 = 97;
		System.out.println(c3);
		
		//3. 문자 표현법 " ' 
		char c4 = 'a';
		System.out.println(c4);
		
		//4.escape char
		// \t  tab   \n  line feed
		
		String path= "C:\\dev";
		
		
	}
}
