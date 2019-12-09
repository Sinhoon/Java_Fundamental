package java_20191204.unicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable {
	private Socket socket;

	public UnicastServerThread(Socket socket) {
		super();
		this.socket = socket;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			boolean isStop = false;
			while (!isStop) {
				String readline = br.readLine();
				System.out.println(readline);

				if (readline.equals("exit")) {
					try {
						bw.write("exit");
						bw.flush();
						bw.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					isStop = true;
				}
				bw.write(readline.substring(readline.indexOf(":")));
				bw.newLine();
				bw.flush();

			}
			System.out.println("클라이언트가 정상적으로 종료되었습니다.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
