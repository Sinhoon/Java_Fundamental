package java_20191205.multicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MulticastClient implements ActionListener {
	private JFrame jframe;
	JTextArea jta;
	private JButton jbtn;
	private JTextField jtf;
	private String id;
	private String ip;
	private int port;
	private BufferedWriter bw;
	BufferedReader br;

	public MulticastClient(String id, String ip, int port) {
		super();
		this.port = port;
		this.id = id;
		this.ip = ip;
		jframe = new JFrame("chat");
		// **********북
		JPanel j1 = new JPanel();
		JLabel jl1 = new JLabel("user id [" + id + "]");
		JLabel jl2 = new JLabel("sever ip " + ip + " : " + port + "");
		j1.setLayout(new BorderLayout());
		j1.add(jl1, BorderLayout.CENTER);
		j1.add(jl2, BorderLayout.EAST);
		// **********

		// **************************
		jta = new JTextArea("", 20, 50);
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jta.setBackground(new Color(222, 222, 225));
		// ***************************

		// **********남
		JPanel j2 = new JPanel();
		jtf = new JTextField(30);
		jbtn = new JButton("send");
		j2.setLayout(new BorderLayout());
		j2.add(jtf, BorderLayout.CENTER);
		j2.add(jbtn, BorderLayout.EAST);
		// **********

		jframe.add(j1, BorderLayout.NORTH);
		jframe.add(j2, BorderLayout.SOUTH);
		jframe.add(jsp, BorderLayout.CENTER);
		jframe.pack();
		jframe.setResizable(true);
		jframe.setVisible(true);

		jbtn.addActionListener(this);
		jtf.addActionListener(this);

		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					bw.write("exit");
					bw.flush();
					bw.newLine();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});
	}

	public void connect() {
		try {
			Socket socket = new Socket(ip, port);
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			MulticastClientThread mct= new MulticastClientThread(this);
			Thread t = new Thread(mct);
			t.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new MulticastClient("신훈", "192.168.0.211", 3000).connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String message = null;
		message = jtf.getText();
		if (obj == jbtn) {
			try {
				bw.write(id+":"+message);
				bw.newLine();
				bw.flush();

				jtf.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (obj == jtf) {
			try {
				bw.write(id+":"+message);
				bw.newLine();
				bw.flush();

				jtf.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
