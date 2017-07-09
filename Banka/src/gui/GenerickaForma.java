package gui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.TableColumn;

import net.miginfocom.swing.MigLayout;
import util.ColumnList;

public abstract class GenerickaForma extends JDialog {

	private static final long serialVersionUID = 1L;

	protected JTable tblGrid = new JTable();

	protected JButton btnFind, btnReload, btnPikup, btnHelp, btnFirst, btnPrev,
			btnNext, btnLast, btnAdd, btnRemove, btnNextForm, btnCommit,
			btnRollback, btnReport;

	protected JLabel lblMode = new JLabel();
	protected JToolBar bar;
	protected JPanel rezimi;
	protected JPanel topPanel;
	protected JPanel middlePanel;
	protected JPanel bottomPanel;
	protected JPanel dataPanel;
	protected JPanel buttons;

	protected static final int MODE_EDIT = 1;
	protected static final int MODE_ADD = 2;
	protected static final int MODE_SEARCH = 3;
	protected int mode;

	protected ColumnList columnList = new ColumnList();

	public ColumnList getColumnList() {
		return columnList;
	}

	public GenerickaForma() {
		getContentPane().setLayout(new MigLayout("fill"));
		lblMode.setText("Rezim pregleda/izmene");
		lblMode.setFont(new Font("Serif", Font.PLAIN, 24));
		lblMode.setForeground(Color.BLUE);

		btnFind = new JButton();
		btnFind.setToolTipText("Pronađi");
		btnFind.setIcon(new ImageIcon(getClass().getResource(
				"/images/Search.png")));
		btnFind.setFocusable(false);

		btnReload = new JButton();
		btnReload.setToolTipText("Osveži");
		btnReload.setIcon(new ImageIcon(getClass().getResource(
				"/images/Refresh.png")));
		btnReload.setFocusable(false);

		btnPikup = new JButton();
		btnPikup.setToolTipText("Prethodna stranica");
		btnPikup.setIcon(new ImageIcon(getClass().getResource(
				"/images/Pickup.png")));
		btnPikup.setFocusable(false);

		btnHelp = new JButton();
		btnHelp.setToolTipText("Pomoć");
		btnHelp.setIcon(new ImageIcon(getClass()
				.getResource("/images/Help.png")));
		btnHelp.setFocusable(false);

		btnFirst = new JButton();
		btnFirst.setToolTipText("Prvi slog");
		btnFirst.setIcon(new ImageIcon(getClass().getResource(
				"/images/First.png")));
		btnFirst.setFocusable(false);

		btnPrev = new JButton();
		btnPrev.setToolTipText("Prethodni slog");
		btnPrev.setIcon(new ImageIcon(getClass()
				.getResource("/images/Previous.png")));
		btnPrev.setFocusable(false);

		btnNext = new JButton();
		btnNext.setToolTipText("Sledeći slog");
		btnNext.setIcon(new ImageIcon(getClass()
				.getResource("/images/Next.png")));
		btnNext.setFocusable(false);

		btnLast = new JButton();
		btnLast.setToolTipText("Poslednji slog");
		btnLast.setIcon(new ImageIcon(getClass()
				.getResource("/images/Last.png")));
		btnLast.setFocusable(false);

		btnAdd = new JButton();
		btnAdd.setToolTipText("Dodaj");
		btnAdd.setIcon(new ImageIcon(getClass().getResource("/images/Add.png")));
		btnAdd.setFocusable(false);

		btnRemove = new JButton();
		btnRemove.setToolTipText("Izbriši");
		btnRemove.setIcon(new ImageIcon(getClass().getResource(
				"/images/Remove.png")));
		btnRemove.setFocusable(false);

		btnNextForm = new JButton();
		btnNextForm.setToolTipText("Vezne forme");
		btnNextForm.setIcon(new ImageIcon(getClass().getResource(
				"/images/Link.png")));
		btnNextForm.setFocusable(false);

		btnCommit = new JButton();
		btnCommit.setToolTipText("Commit");
		btnCommit.setIcon(new ImageIcon(getClass().getResource(
				"/images/Commit.png")));
		btnCommit.setFocusable(false);

		btnRollback = new JButton();
		btnRollback = new JButton();
		btnRollback.setToolTipText("Izbriši");
		btnRollback.setIcon(new ImageIcon(getClass().getResource(
				"/images/Remove.png")));
		btnRollback.setFocusable(false);
		
		btnReport = new JButton();
		btnReport = new JButton();
		btnReport.setToolTipText("Izveštaj");
		btnReport.setText("Izvestaj");
		btnReport.setFont(new Font("ARIAL", Font.BOLD, 16));
		btnReport.setFocusable(false);
		btnReport.setVisible(false);

		bar = new JToolBar();
		bar.add(btnFind);
		bar.add(btnReload);
		bar.add(btnPikup);
		bar.add(btnHelp);
		bar.addSeparator();
		bar.add(btnFirst);
		bar.add(btnPrev);
		bar.add(btnNext);
		bar.add(btnLast);
		bar.addSeparator();
		bar.add(btnAdd);
		bar.add(btnRemove);
		bar.addSeparator();
		bar.add(btnNextForm);
		bar.addSeparator();
		bar.add(btnReport);

		getContentPane().add(bar, "dock north, grow");
		rezimi = new JPanel(new MigLayout("align center"));
		rezimi.setVisible(true);
		rezimi.add(lblMode, "dock center");
		getContentPane().add(rezimi, "dock north");
		topPanel = new JPanel(new MigLayout("align center"));
		topPanel.setVisible(false);
		getContentPane().add(topPanel, "dock north, grow");

		middlePanel = new JPanel(new MigLayout("fill"));
		middlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		getContentPane().add(middlePanel, "center, grow");

		bottomPanel = new JPanel(new MigLayout("fill"));
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		dataPanel = new JPanel(new MigLayout("align center"));

		bottomPanel.add(dataPanel);

		buttons = new JPanel(new MigLayout("align center"));

		buttons.add(btnCommit, "wrap");
		buttons.add(btnRollback);
		bottomPanel.add(buttons, "dock east");

		//bottomPanel.add();

		getContentPane().add(bottomPanel, "dock south, grow");

	}
	
	public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth,
	        double... percentages) {
	    double total = 0;
	    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	        total += percentages[i];
	    }
	 
	    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	        TableColumn column = table.getColumnModel().getColumn(i);
	        column.setPreferredWidth((int)
	                (tablePreferredWidth * (percentages[i] / total)));
	    }
	}

	public void goFirst(JTable tblGrid) {
		int rowCount = tblGrid.getModel().getRowCount();
		if (rowCount > 0) {
			tblGrid.setRowSelectionInterval(0, 0);
		}
	}

	public void goPrev(JTable tblGrid) {
		int selectedRow = tblGrid.getSelectedRow();
		int rowCount = tblGrid.getModel().getRowCount();
		if (selectedRow != -1) {
			if (selectedRow != 0) {
				tblGrid.setRowSelectionInterval(selectedRow, selectedRow - 1);
			} else {
				tblGrid.setRowSelectionInterval(rowCount - 1, rowCount - 1);
			}
		} else {
			tblGrid.setRowSelectionInterval(0, 0);
		}
	}

	public void goNext(JTable tblGrid) {
		int selectedRow = tblGrid.getSelectedRow();
		int rowCount = tblGrid.getModel().getRowCount();
		if (selectedRow != -1) {
			if (selectedRow != rowCount - 1) {
				tblGrid.setRowSelectionInterval(selectedRow, selectedRow + 1);
			} else {
				tblGrid.setRowSelectionInterval(0, 0);
			}
		} else {
			tblGrid.setRowSelectionInterval(0, 0);
		}
	}

	public void goLast(JTable tblGrid) {
		int rowCount = tblGrid.getModel().getRowCount();
		if (rowCount > 0) {
			tblGrid.setRowSelectionInterval(rowCount - 1, rowCount - 1);
		}
	}

}
