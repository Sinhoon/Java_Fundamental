package java_20191204;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketDemo {
	public static void main(String[] args) {
		ServerSocket serverSocekt = null;
		for(int i=1;i<65536;i++){
			//Serversocket port 아무것도 안쓰고있으면 객체 생성 가능
			try {
				serverSocekt = new ServerSocket(i);
				System.out.println(i+"번호 사용가능");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(i+"번호 사용 못함");
			}
		}
	}
}
