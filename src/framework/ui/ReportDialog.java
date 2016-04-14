package framework.ui;

public class ReportDialog extends javax.swing.JDialog {
	protected String reportString;

	public ReportDialog(String reportStr) {
		this.reportString = reportStr;
		getContentPane().setLayout(null);
		setSize(500, 350);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24, 24, 524, 240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0, 0, 500, 237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156, 276, 96, 24);

		JTextField1.setText(reportString);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}

	protected class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}
	
	protected javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	protected javax.swing.JTextArea JTextField1 = new javax.swing.JTextArea();
	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
}
