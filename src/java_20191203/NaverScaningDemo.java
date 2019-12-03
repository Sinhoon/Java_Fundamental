package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class NaverScaningDemo {
	public static void main(String[] args) 
			throws IOException {
		URL url = new URL("https://www.naver.com/");
		InputStream in = url.openStream();
		
		//1. InputStream을 InputstreamReader로 스트림체이닝.
		//2. InputStreamReader를 BufferedReader로 스트림체이닝.
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br  = new BufferedReader(isr);
		FileWriter fw = new FileWriter("C:\\dev\\io\\2019\\12\\naver.html");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw,true);
		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			System.out.println(readLine);
			pw.println(readLine);
		}

		if(in != null) in.close();
		if(br != null) br.close();
		if(bw != null) bw.close();
		if(isr != null) isr.close();
	}
}
