package _02_Chat_Application;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import _00_Click_Chat.gui.ButtonClicker;
import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp{

	Server server;
	Client client;
	
	static JFrame frame;
	static JPanel panel;
	static JTextField field;
	static JTextArea area;

	public static void main(String[] args) {
		ChatApp chat = new ChatApp();
		frame = new JFrame();
		panel = new JPanel();
		field = new JTextField();
		area = new JTextArea();

	}

	public ChatApp() {

		int response = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "Buttons!",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			
			
			server = new Server(8080);

			JOptionPane.showMessageDialog(null,
					"Server started at: " + server.getIPAddress() + "\nPort: " + server.getPort());

			server.start();
			
			frame.setPreferredSize(new Dimension(400, 500));
			frame.add(panel);
			panel.add(field);
			panel.add(area);
			frame.setTitle("Chat App");
			frame.setVisible(true);
			

		} else {

			String ipStr = JOptionPane.showInputDialog("Enter the IP Address");
			String prtStr = JOptionPane.showInputDialog("Enter the port number");
			int port = Integer.parseInt(prtStr);
			client = new Client(ipStr, port);

			client.start();
		}
	}

}
