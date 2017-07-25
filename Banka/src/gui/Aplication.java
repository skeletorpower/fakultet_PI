package gui;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Aplication {

	public static void main(String[] args) {
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
//		Login login = new Login();
//		login.setVisible(true);
		MainFrame mainFrame = new MainFrame();
		mainFrame.show();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
