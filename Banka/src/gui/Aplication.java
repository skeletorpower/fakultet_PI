package gui;

import javax.swing.UIManager;

public class Aplication {

	public static void main(String[] args) {
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
//		Login login = new Login();
//		login.setVisible(true);
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

}
