package creditcard.ui;

import framework.commands.AddInterestCommand;
import framework.commands.Command;
import framework.commands.CommandManager;
import framework.util.ValidatorUtil;
import creditcard.services.AccountServiceImp;

public class JDialog_AddInterest extends javax.swing.JDialog {

	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	javax.swing.JTextField JTextField_Interest = new javax.swing.JTextField();


	public JDialog_AddInterest() {
		setTitle("Add Interest");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(300, 150);
		setVisible(false);
		JLabel1.setText("Add Interest To All Accounts:");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 300, 24);
		JLabel2.setText("Amount:");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 48, 48, 24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36, 84, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 84, 84, 24);
		getContentPane().add(JTextField_Interest);
		JTextField_Interest.setBounds(84, 48, 144, 24);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK) {
				JButtonOK_actionPerformed(event);
			} else if (object == JButton_Cancel) {
				JButtonCalcel_actionPerformed(event);
			}
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		if (!ValidatorUtil.isNumeric(JTextField_Interest.getText())) {
			dispose();
			return;
		}
		Command command = new AddInterestCommand(AccountServiceImp.getInstance(), Double.parseDouble(JTextField_Interest.getText()));
		CommandManager manager = CommandManager.getInstance();
		manager.setCommand(command);
		try {
			manager.invokeCommand();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

}