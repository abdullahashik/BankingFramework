package banking.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.UIManager;

import framework.ui.MainPanel;

public class BankFrame extends javax.swing.JFrame {

	private MainPanel mainPane;
	private CustomerPanel custPane;
	private AccountPanel accPane;

	public BankFrame() {
		setTitle("Bank Application.");
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(700, 400);
		setVisible(false);

		custPane = new CustomerPanel();
		custPane.setName("Customer");
		accPane = new AccountPanel();
		accPane.setName("Account");

		ArrayList<JPanel> listPane = new ArrayList<JPanel>();
		listPane.add(custPane);
		listPane.add(accPane);
		mainPane = new MainPanel(listPane);
		getContentPane().add(BorderLayout.CENTER, mainPane);
	}

	static public void main(String args[]) {
		try {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}
			(new BankFrame()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == BankFrame.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}
}
