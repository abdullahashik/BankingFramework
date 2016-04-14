package framework.ui;

public abstract class WithdrawDialog extends javax.swing.JDialog {

	protected String accnr;
	protected boolean isNewWithdraw = false;
	protected double currentBalance;

	public WithdrawDialog(String aaccnr, double currentBal) {
		this.currentBalance = currentBal;
		this.accnr = aaccnr;
		setTitle("Withdraw");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(277, 134);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 48, 24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 36, 48, 24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 12, 156, 20);
		getContentPane().add(JTextField_AMT);
		JTextField_AMT.setBounds(84, 36, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 84, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 84, 84, 24);

		JTextField_NAME.setText(accnr);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		
		setComponentNames();
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK) {
				JButtonOK_actionPerformed(event);
				isNewWithdraw = true;
			} else if (object == JButton_Cancel) {
				JButtonCalcel_actionPerformed(event);
				isNewWithdraw = false;
			}
		}
	}

	public abstract void JButtonOK_actionPerformed(java.awt.event.ActionEvent event);
	
	public abstract void setComponentNames();

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

	public boolean isNewWithdraw() {
		return isNewWithdraw;
	}
	
	protected javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	protected javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_AMT = new javax.swing.JTextField();
	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
}