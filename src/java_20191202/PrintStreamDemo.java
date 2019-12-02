package java_20191202;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) {
		PrintStream ps = System.out; // DESTNATION을 출력장치에 연결하겠다.

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps1 = null;
		long starttime = System.currentTimeMillis();
		try {
			fis = new FileInputStream("C:\\dev\\io\\2019\\12\\pdf.zip");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("C:\\dev\\io\\2019\\12\\pdf1.zip");
			bos = new BufferedOutputStream(fos);
			ps1 = new PrintStream(bos, true); // destination file 출력

			int readbyte = 0;
			while ((readbyte = bis.read()) != -1) {
				ps1.write(readbyte);
			}
			long endtime = System.currentTimeMillis();
			ps.println(endtime - starttime);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (bis != null)
					bis.close();
				if (ps1 != null)
					ps1.close();
				if (fos != null)
					fos.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
