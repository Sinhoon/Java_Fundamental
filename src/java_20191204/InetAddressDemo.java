package java_20191204;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress i = InetAddress.getLocalHost();
		System.out.printf("호스트이름 %s \n",i.getHostName());
		System.out.printf("ip address%s \n ",i.getHostAddress());
		InetAddress j = InetAddress.getByName("www.naver.com");
		System.out.printf("호스트이름 %s \n ",j.getHostName());
		System.out.printf("ip address%s \n  ",j.getHostAddress());
	}
}
