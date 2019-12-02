package java_20191202;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileDemo {
	public static void main(String[] args) {
		File f1 = new File("c:\\dev\\io\\2019\\12");
		boolean isSuccess = f1.mkdirs();
		System.out.println(isSuccess);

		File f2 = new File(f1, "jdk-11.0.3_windows-x64_bin.exe");
		long fileSize = f2.length();
		System.out.println(fileSize / 1024);
		long lastModified = f2.lastModified();

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(lastModified);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);

		System.out.printf("%d,%d,%d", year, month, day);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd a hh:mm:ss E요일");
		String date = sdf.format(c.getTime());
		System.out.println(date);

		File f3 = new File("c:\\");
		// list() 모든 파일 string 배열로
		String[] list = f3.list();
		for (String i : list) {
			File f4 = new File(f3, i);
			if (f4.isDirectory()) {
				System.out.println("디렉토리" + i);
			} else if (f4.isFile()) {
				System.out.println("파일" + i);
			} else {
				System.out.println("?" + i);
			}
		}

		
		File f5 = new File(f1,"jdk.exe");
		f2.renameTo(f5);
		
		File f6= new File(f1,"jdk.exe");
		System.out.println(f6.getName());
		System.out.println(f6.getParent());
		System.out.println(f6.getPath());
		
	
		File f7 = new File(f1,"a.txt");
		String extension= f7.getName().substring(f7.getName().lastIndexOf(".")+1);
		long a= System.currentTimeMillis();
		String b = String.valueOf(a);
		File f8 = new File(f1,b+extension);
		f7.renameTo(f8);
		
		
	}

}
