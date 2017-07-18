package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.DBConnection;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	private JButton btnUpravljanjeRacunima = new JButton();
	
	
	//dodacu jos btn po zelji
	
	public MainFrame(){
		DBConnection.getConnection();
		setSize(566, 400);
		setMinimumSize(new Dimension(500, 300));
		setTitle("Banka");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new MigLayout("", "[][][][][][][]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("Upravljanje ranucima");
		getContentPane().add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		
		JLabel lblNalogZaTransfer = new JLabel("Nalozi");
		getContentPane().add(lblNalogZaTransfer, "cell 2 0,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Import stavki placanja");
		getContentPane().add(lblNewLabel_1, "cell 4 0,alignx center,aligny center");
		
		JButton btnUpRacunima = new JButton("Upravljanje racunima");
		btnUpRacunima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpravljanjeRacunima upravljanjeRacunima = new UpravljanjeRacunima();
				upravljanjeRacunima.setEnabled(true);
				
			}
		});
		getContentPane().add(btnUpRacunima, "cell 0 1,alignx center,aligny center");
		
		JButton btnNalogZaTransfer = new JButton("Nalog za transfer");
		getContentPane().add(btnNalogZaTransfer, "cell 2 1,alignx center,aligny center");
		
		JButton btnNewButton = new JButton("Import stavki placanja");
		getContentPane().add(btnNewButton, "cell 4 1,alignx center,aligny center");
		
		JButton btnNalogZaPrenos = new JButton("Nalog za prenos izvoda");
		getContentPane().add(btnNalogZaPrenos, "cell 2 2,alignx center,aligny center");
		
		btnUpravljanjeRacunima.setText("Upravljanje racunima");
		btnUpravljanjeRacunima.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//DUGME TREBA DA OTVORI DIJALOG ZA UNOS I BRISANJE RACUNA
			}
		});
		
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setVisible(boolean b) {
		
		
	}

}
