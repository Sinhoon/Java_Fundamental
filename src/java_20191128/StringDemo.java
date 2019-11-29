package java_20191128;

public class StringDemo {
	public static void main(String[] args) {
		String str = "abcdefg";
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		str = str.concat("abcd"); // str+ "abcd"

		System.out.println(str);

		String fileName = "abc.zip";
		if (fileName.endsWith("zip")) {
			System.out.println("zip파일입니다.");
		} else if (fileName.endsWith("ppt")) {
			System.out.println("ppt파일입니다.");
		}
		
		String url = "artist/index.jsp";
		if (url.startsWith("artist")) {
			System.out.println("artist페이지입니다.");
		} else if (url.startsWith("exhibition")) {
			System.out.println("exhibition페이지입니다.");
		}
		
		System.out.println("abc".equalsIgnoreCase("aBc"));
		
		System.out.println("a".getBytes().length);
		System.out.println("ㄱ".getBytes().length);

		System.out.println("가나다".indexOf("다"));
		fileName = "abc.bde.fafd.ppt";
		/*
		char[] printfile = fileName.toCharArray();
		for (int i = 0 ; i<fileName.lastIndexOf(".");i++){
			System.out.print(printfile[i]);
		}
		*/
		String printfile = fileName.substring(0,fileName.lastIndexOf("."));
		System.out.println(printfile);
		String printextend = fileName.substring(fileName.lastIndexOf(".")+1);
		System.out.println(printextend);
		
		String content = "abc\nabc\nabc";
		System.out.println(content);
		System.out.println(content.replaceAll("\n","<br>"));
		
		String a = "abc";
		String b = "abc ";
		System.out.println(a.trim().equals(b.trim()));
		
		Integer as = Integer.valueOf(10);
		String ad = String.valueOf(10);
		double aff = as.doubleValue();
		double asd = Integer.parseInt(ad);
		
		
		String phone = "010-2324-3253";
		String[] temp = phone.split("-");
		for (String string : temp) {
			System.out.println(string);
		}
		
		str =String.format("%3$,10.2f %d %d",10000,20,30000.24);
		System.out.print("\n");
		System.out.printf("%n");
		System.out.println(str);
		
		int c = (byte)1000;
		System.out.println(c+"\b"+"dd");
		
	}
}
