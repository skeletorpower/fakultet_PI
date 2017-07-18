package gui;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.ScrollPane;
import java.sql.SQLException;
import java.awt.Point;
import java.awt.Panel;

public class UpravljanjeRacunima extends GenerickaForma{
	private JTable tblGrid = new JTable();
	public UpravljanjeRacunima() {
		
		
		
		JScrollPane scrollPane = new JScrollPane(tblGrid);
		middlePanel.add(scrollPane, "spanx ,grow,wrap");

//		try {
//			tableModel.open();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		tblGrid.setRowSelectionAllowed(true);
		tblGrid.setColumnSelectionAllowed(false);
		tblGrid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblGrid.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting())
							return;
						//sync();
					}
				});
		setJTableColumnsWidth(tblGrid, 1500, 10, 10, 10, 10, 15, 17.5, 17.5, 10);
	}
		
		
		
	

}
