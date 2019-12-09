package java_20191205.file.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileServerThread implements Runnable {
	private Socket socket;
	public FileServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		String readline = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			readline = br.readLine();
			System.out.println(readline+"전송");
			FileInputStream in = new FileInputStream("C:\\dev\\io\\2019\\12"+readline);
			
			byte[] readbytes = new byte[1024*8];
			int readcount = 0;
			OutputStream out = socket.getOutputStream();
			while((readcount= in.read(readbytes)) != -1 ){
				out.write(readbytes,0,readcount);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
