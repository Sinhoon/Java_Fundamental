package java_20191205.multicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServer{

	private int port;
	private ArrayList<MulticastServerThread> list ;
	
	public MulticastServer(int port) {
		this.port = port;
		list = new ArrayList<MulticastServerThread>();
	}

	public void run() {
		ServerSocket serverSocket = null;
		MulticastServerThread ust = null;
		// 1. 서브객체 생성
		try {
			serverSocket = new ServerSocket(port);

		while (true) {
			System.out.println("클라이언트 접속을 기다리고 있습니다");
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트 접속 : " + socket.getInetAddress().getHostAddress());
			ust = new MulticastServerThread(socket,list);
			list.add(ust);
			System.out.println("클라이언트 접속수" + list.size());
			Thread t = new Thread(ust);
			t.start();

		}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MulticastServer us = new MulticastServer(3000);
		us.run();
		
	}
}
