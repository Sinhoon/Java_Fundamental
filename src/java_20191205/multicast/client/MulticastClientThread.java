package java_20191205.multicast.client;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class MulticastClientThread implements Runnable {
	private MulticastClient mc;

	public MulticastClientThread(MulticastClient mc) {
		// TODO Auto-generated constructor stub
		this.mc = mc;
	}

	public void run() {
		while (true) {
			try {
				String readline = mc.br.readLine();
				if (mc.br.readLine() == "exit") {
					System.exit(0);
				} else {
					mc.jta.append(readline + "\n");
					mc.jta.setCaretPosition(mc.jta.getDocument().getLength());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
