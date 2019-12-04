package java_20191204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://news.naver.com:/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=421&aid=0004340528");
		String protocol = url.getProtocol();
		String host	= url.getHost();
		int port = url.getPort();
		String path = url.getPath();
		String query = url.getQuery();
		String ref =url.getRef();
		System.out.printf("protocol: ");
		System.out.println(protocol);
		System.out.print("host: ");
		System.out.println(host);
		System.out.print("port: ");
		System.out.println(port);
		System.out.print("path: ");
		System.out.println(path);
		System.out.print("query: ");
		System.out.println(query);
		System.out.print("ref: ");
		System.out.println(ref);
		
		InputStream in = url.openStream();
		System.out.println(in);
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String readline = null;
		while((readline = br.readLine()) != null){
			System.out.println(readline);
		}
		
	}

}
