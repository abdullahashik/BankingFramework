package framework.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public abstract class AccountBasePanel extends JPanel {

	boolean isAddNewAccount;
	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Object rowdata[];

	public AccountBasePanel(String[]columns) {
		this.setLayout(null);
		this.setBounds(0, 0, 575, 310);

		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		for (String col:columns) {
			model.addColumn(col);
		}
		rowdata = new Object[columns.length];
		isAddNewAccount = false;

		this.add(JScrollPane1);
		JScrollPane1.setBounds(12, 62, 544, 250);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 520, 0);

		this.add(JButton_AddAcc);
		JButton_AddAcc.setText("Add Account");
		JButton_AddAcc.setBounds(24, 20, 192, 33);
		
		this.add(JButton_Addinterest);
		JButton_Addinterest.setBounds(568, 20, 96, 33);
		JButton_Addinterest.setText("Add interest");
		
		this.add(JButton_Deposit);
		JButton_Deposit.setText("Deposit");
		JButton_Deposit.setBounds(568, 60, 96, 33);
		
		this.add(JButton_Withdraw);
		JButton_Withdraw.setText("Withdraw");
		JButton_Withdraw.setBounds(568, 100, 96, 33);

		this.add(JButton_Report);
		JButton_Report.setText("Report");
		JButton_Report.setBounds(568, 140, 96, 31);

		this.add(JButton_Exit);
		JButton_Exit.setText("Exit");
		JButton_Exit.setBounds(568, 280, 96, 31);

		SymAction lSymAction = new SymAction();
		JButton_AddAcc.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Report.addActionListener(lSymAction);
		JButton_Exit.addActionListener(lSymAction);
		
		displayAccountList();
		setButtonNames();
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_AddAcc)
				JButtonAddAcc_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
			else if (object == JButton_Report)
				JButtonReport_actionPerformed(event);
		}
	}
	
	public abstract void setButtonNames();
	public abstract void displayAccountList();
	public abstract void JButtonExit_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonAddAcc_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonReport_actionPerformed(java.awt.event.ActionEvent event);
	
	protected javax.swing.JButton JButton_AddAcc = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Report = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Exit = new javax.swing.JButton();
}
