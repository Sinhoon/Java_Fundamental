package java_20191204.unicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer{

	private int port;

	public UnicastServer(int port) {
		this.port = port;
	}

	public void run() {
		ServerSocket serverSocket = null;
		UnicastServerThread ust = null;
		// 1. 서브객체 생성
		try {
			serverSocket = new ServerSocket(port);

		while (true) {
			System.out.println("클라이언트 접속을 기다리고 있습니다");
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트 접속 : " + socket.getInetAddress().getHostAddress());
			ust = new UnicastServerThread(socket);
			Thread t = new Thread(ust);
			t.start();

		}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UnicastServer us = new UnicastServer(3000);
		us.run();
		
	}
}
