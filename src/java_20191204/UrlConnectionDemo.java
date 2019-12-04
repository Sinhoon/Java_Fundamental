package java_20191204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://news.naver.com:/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=421&aid=0004340528");
		URLConnection urlCon = url.openConnection();
		
		String cacheControl = urlCon.getHeaderField("cache-control");
		String contentType = urlCon.getHeaderField("content-type");
		String date = urlCon.getHeaderField("date");
		System.out.println("cache control : "+cacheControl);
		System.out.println("content -type : "+contentType);
		System.out.println("date : "+date);		
		
		InputStream in = urlCon.getInputStream();
		System.out.println(in);
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String readline = null;
		while((readline = br.readLine()) != null){
			System.out.println(readline);
	}
}
}
