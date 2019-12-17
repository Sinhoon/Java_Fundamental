package java_20191205.file.client;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient {
	private String ip;
	private int port;

	public FileClient(String ip, int port) {
		// TODO Auto-generated constructor stub
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		try {
			String filename = "eclipse-inst-win64.exe";
			Socket socket = new Socket(ip, port);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(filename);
			bw.newLine();
			bw.flush();
			InputStream in = socket.getInputStream();
			FileOutputStream fos = new FileOutputStream("C:\\dev\\io\\2019\\12\\" + filename);
			byte[] readbytes = new byte[1024 * 8];
			int readcount = 0;
			while ((readcount = in.read(readbytes)) != -1) {
				fos.write(readbytes, 0, readcount);
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileClient("192.168.0.203",3033).run();
	}
}
