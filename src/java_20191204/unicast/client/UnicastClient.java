package java_20191204.unicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnicastClient implements ActionListener {
	private JFrame jframe;
	private JTextArea jta;
	private JButton jbtn;
	private JTextField jtf;
	private String id;
	private String ip;
	private int port;
	public UnicastClient(String id, String ip ,int port ) {
		super();
		this.port=port;
		this.id=id;
		this.ip=ip;
		jframe = new JFrame("chat");
		// **********북
		JPanel j1 = new JPanel();
		JLabel jl1 = new JLabel("user id [" + id + "]");
		JLabel jl2 = new JLabel("sever ip " + ip +" : "+ port + "");
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

		jframe.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			public void windowOpened(WindowEvent e){
				jtf.requestFocus();
			}
		});
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new UnicastClient("신훈","192.168",3000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String message = jtf.getText();
		if (obj == jbtn) {
			jta.append(id+":"+message+"\n");
			jtf.setText("");
		}else if (obj == jtf){
			jta.append(id+":"+message+"\n");
			jtf.setText("");
		}

	}
}
