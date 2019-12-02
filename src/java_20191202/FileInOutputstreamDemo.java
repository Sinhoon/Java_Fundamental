package java_20191202;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutputstreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("C:\\dev\\io\\2019\\12\\jdk.exe");
			fos = new FileOutputStream("C:\\dev\\io\\2019\\12\\jdk-4.exe");
			/*
			 * int readByte = 0; //read() :한바이트씩 반환 while((readByte= fis.read())
			 * != -1){ //write() :한바아트씩 쓰기 fos.write(readByte);
			 */
			long startTime = System.currentTimeMillis();

			byte[] readBytes = new byte[1024 * 8];
			int readByteCount = 0;
			// read(readbytes) :1024 바이트 읽어서 readbytes에 저장하고 읽은 바이트수를 반환
			while ((readByteCount = fis.read(readBytes)) != -1) {
				// write(readBytes,0,readByteCount) = readbytes 배열에 있는 데이터를 출력하되
				// 처음(0)부터 readbytescount만큼 출력
				fos.write(readBytes, 0, readByteCount);
			}
			long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);

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
