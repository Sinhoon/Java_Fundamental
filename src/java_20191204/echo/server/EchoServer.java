package java_20191204.echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private int port;
	public EchoServer(int port){
		this.port = port;
	}
	public void run(){
		ServerSocket serverSocket = null ;

		//1. 서브객체 생성
		try {
			serverSocket = new ServerSocket(port);
			while(true){
				System.out.println("클라이언트 접속을 기다리고 있습니다");
				//    acppet메소드는 클라이언트 접속 기다리다가 접속하면 클라이언트와 통신 할수있는 socket 객체로 반환
				// 2. 서버소켓으로 클라이언트 접속대기
				// 5. 클라이언트가 통신할 수 있는 소켓 객체 반환한다.
				Socket socket = serverSocket.accept();
				
				System.out.println("클라이언트 접속 : "+socket.getInetAddress().getHostAddress());
				
				// 7. 소켓으로 입력 스트림을 생성한다.
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String readline = null;
				readline = br.readLine();
				System.out.println(readline);
				
				//8. 소켓으로 출력 스트림을 생성한다.
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(readline);
				bw.newLine();
				bw.flush();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EchoServer(3000).run();
	}
}
