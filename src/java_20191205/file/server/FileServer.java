package java_20191205.file.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	private int port;
	public FileServer(int port){
		this.port = port;
	}
	public void run(){
		ServerSocket serversocket = null;
		try {
			while(true){
				System.out.println("클라이언트 접속 대기...");
				serversocket =new ServerSocket(port);
				Socket socket = serversocket.accept();
				System.out.println("클라이언트 접속했습니다.");
				
				FileServerThread fst = new FileServerThread(socket);
				Thread t = new Thread(fst);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileServer(21).run();
	}
}
