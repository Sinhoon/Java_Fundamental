package java_20191205.multicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServerThread implements Runnable {
	private Socket socket;
	private ArrayList<MulticastServerThread> list;
	private BufferedWriter bw;

	public MulticastServerThread(Socket socket, ArrayList<MulticastServerThread> list) {
		super();
		this.socket = socket;
		this.list = list;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String readline = null;
			boolean isStop = false;
			while (!isStop) {
				readline = br.readLine();
				System.out.println(readline);

				if (readline.equals("exit")) {
					isStop = true;
					sendMessage(readline);
				} else {
					broadCast(readline);
				}

			}
			list.remove(this);
			System.out.println("클라이언트가 정상적으로 종료되었습니다.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			list.remove(this);
			System.out.println("클라이언트가 비정상적으로 종료되었습니다.");
		}

	}

	public void broadCast(String message) throws IOException {
		for (MulticastServerThread mst : list) {
			mst.sendMessage(message);
		}
	}

	public void sendMessage(String message) throws IOException {
		bw.write(message);
		bw.newLine();
		bw.flush();
	}
}
