package java_20191202;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		long starttime = System.currentTimeMillis();
		try {
			fis = new FileInputStream("C:\\dev\\io\\2019\\12\\pdf.zip");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("C:\\dev\\io\\2019\\12\\pdf1.zip");
			bos = new BufferedOutputStream(fos);
/*			byte[] readbyte = new byte[1024];
			int readcount = 0;
			while((readcount = fis.read(readbyte)) != -1){
				fos.write(readbyte,0,readcount);
			}*/
			int readbyte = 0;
			while((readbyte = bis.read()) != -1){
				bos.write(readbyte);
			}
			bos.flush();
			long endtime = System.currentTimeMillis();
			System.out.println(endtime-starttime);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}finally{
			try {
				if (fis != null) fis.close();
				if (bis != null) bis.close();
				if (fos != null) fos.close();
				if (bos != null) bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		
		
		
		
	}

}
