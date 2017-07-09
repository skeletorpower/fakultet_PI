package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import database.DBConnection;

@SuppressWarnings("serial")
public class Login extends JFrame {

	JLabel lbUsername = new JLabel("Username: ");
	JLabel lbPassword = new JLabel("Password: ");
	JTextField tfUsername = new JTextField(20);
	JPasswordField tfPassword = new JPasswordField(20);
	JButton btnLogin = new JButton("Uloguj se");
	String loginQuery = "SELECT USERNAME, PASSWORD FROM RADNIK";
	boolean ulogovan;

	public Login() {
		setLayout(new MigLayout("fill"));
		setTitle("Logovanje");
		setSize(250, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel login = new JPanel(new MigLayout("insets 10"));
		login.add(lbUsername);
		login.add(tfUsername, "wrap");
		login.add(lbPassword);
		login.add(tfPassword, "wrap");

		add(login, "dock north, grow");

		JPanel button = new JPanel(new MigLayout("insets 10"));
		button.add(btnLogin, "align center");

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfUsername.getText().equals("")
						&& !tfPassword.getPassword().equals("")) {
					String username = tfUsername.getText();
					String password = "";
					for (char ch : tfPassword.getPassword()) {
						password += ch;
					}
					try {
						ulogovan = logIn(loginQuery, username, password);
						if (ulogovan == true) {
							MainFrame main = new MainFrame();
							main.setVisible(true);
						} else {
							JOptionPane
									.showMessageDialog(
											null,
											"Uneli ste neispravno korisnicko ime ili lozinku!",
											"Obavestenje",
											JOptionPane.WARNING_MESSAGE);

						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Molimo vas popunite sve podatke!", "Obavestenje",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		add(button, "dock south, grow");
	}

	public boolean logIn(String sql, String username, String password)
			throws SQLException {
		ArrayList<String> radnici = new ArrayList<String>();
		Statement stmt = DBConnection.getConnection().createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
			String usernameTemp = rset.getString("USERNAME");
			String passwordTemp = rset.getString("PASSWORD");
			radnici.add(usernameTemp);
			radnici.add(passwordTemp);
		}
		if (radnici.contains(username) && radnici.contains(password)) {
			return true;
		}
		return false;
	}

}
