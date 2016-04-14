package framework.ui;

public abstract class DepositDialog extends javax.swing.JDialog {

	protected String accnr;
	protected boolean isNewDeposit = false;

	public DepositDialog(String aaccnr) {
		accnr = aaccnr;
		setTitle("Deposit");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(300, 150);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 48, 24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 48, 48, 24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 12, 144, 24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36, 84, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 84, 84, 24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84, 48, 144, 24);
		JTextField_NAME.setText(accnr);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK) {
				JButtonOK_actionPerformed(event);
				isNewDeposit = true;
			} else if (object == JButton_Cancel) {
				JButtonCalcel_actionPerformed(event);
				isNewDeposit = false;
			}
		}
	}

	public abstract void JButtonOK_actionPerformed(java.awt.event.ActionEvent event);

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

	public boolean isNewDeposit() {
		return isNewDeposit;
	}
	
	protected javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	protected javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	protected javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();

}