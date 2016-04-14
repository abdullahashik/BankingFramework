package creditcard.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.UIManager;

import framework.ui.MainPanel;

public class CreditCardFrame extends javax.swing.JFrame {

	private MainPanel mainPane;
	private CustomerPanel custPane;
	private CreditCardPanel accPane;

	public CreditCardFrame() {
		setTitle("Credit Card Application.");
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(700, 400);
		setVisible(false);

		custPane = new CustomerPanel();
		custPane.setName("Customer");
		accPane = new CreditCardPanel();
		accPane.setName("Credit Card");

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
			(new CreditCardFrame()).setVisible(true);
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
			if (object == CreditCardFrame.this)
				CCFrame_windowClosing(event);
		}
	}

	void CCFrame_windowClosing(java.awt.event.WindowEvent event) {
		CCFrame_windowClosing_Interaction1(event);
	}

	void CCFrame_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}
}
