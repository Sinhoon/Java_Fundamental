package java_20191202;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ex {
	public static void main(String[] args) {
		InputStream fis = null;
		OutputStream fos = null;

		try {
			fis = new FileInputStream("C:\\dev\\io\\2019\\12\\jdk.exe");
			fos = new FileOutputStream("C:\\dev\\io\\2019\\12\\jdk1.exe");
			byte[] readbytes = new byte[1024];
			int readcount = 0;
			while ((readcount = fis.read(readbytes)) != -1) {
				fos.write(readbytes, 0, readcount);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
