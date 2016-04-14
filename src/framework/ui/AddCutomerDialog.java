package framework.ui;

import framework.dto.PartyDTO;

public abstract class AddCutomerDialog extends javax.swing.JDialog {

	protected PartyDTO pojoP;
	protected String custType;
	protected boolean isAddNew = false;

	public AddCutomerDialog(String custType) {
		this.custType = custType;
		setTitle("Add Customer");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(270, 300);
		setVisible(false);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 36, 48, 24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 60, 48, 24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 84, 48, 24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 108, 48, 24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 132, 48, 24);
		JLabel6.setText("Email");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 156, 48, 24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(120, 36, 156, 20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(120, 60, 156, 20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(120, 84, 156, 20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(120, 108, 156, 20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(120, 132, 156, 20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(120, 156, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 216, 84, 24);
		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		getContentPane().add(JButton_Calcel);
		JButton_Calcel.setBounds(156, 216, 84, 24);

		if ("P".equalsIgnoreCase(custType)) {
			JLabel7.setText("Date Of Birth");
			getContentPane().add(JLabel7);
			JLabel7.setForeground(java.awt.Color.black);
			JLabel7.setBounds(12, 180, 96, 24);

			JTextField_BD = new javax.swing.JTextField();
			getContentPane().add(JTextField_BD);
			JTextField_BD.setBounds(120, 180, 156, 20);
		} else {
			JLabel7.setText("No of employees");
			getContentPane().add(JLabel7);
			JLabel7.setForeground(java.awt.Color.black);
			JLabel7.setBounds(12, 180, 96, 24);

			JTextField_NoOfEmp = new javax.swing.JTextField();
			getContentPane().add(JTextField_NoOfEmp);
			JTextField_NoOfEmp.setBounds(120, 180, 156, 20);
		}

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Calcel.addActionListener(lSymAction);
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK) {
				JButtonOK_actionPerformed(event);
				isAddNew = true;
			} else if (object == JButton_Calcel) {
				JButtonCalcel_actionPerformed(event);
				isAddNew = false;
			}
		}
	}

	public abstract void JButtonOK_actionPerformed(java.awt.event.ActionEvent event);

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

	public PartyDTO getPojoParty() {
		return pojoP;
	}

	public boolean isAddNew() {
		return isAddNew;
	}
	
	protected javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	protected javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	protected javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Calcel = new javax.swing.JButton();
	protected javax.swing.JTextField JTextField_NoOfEmp;
	protected javax.swing.JTextField JTextField_BD;

}