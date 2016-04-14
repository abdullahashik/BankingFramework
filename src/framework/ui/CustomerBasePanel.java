package framework.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public abstract class CustomerBasePanel extends JPanel {

	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Object rowdata[];

	public CustomerBasePanel(String[] columns) {
		setLayout(null);
		this.setBounds(0, 0, 800, 350);
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		for (String col:columns) {
			model.addColumn(col);
		}
		rowdata = new Object[columns.length];

		JTable1 = new JTable(model);
		this.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 612, 200);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 580, 0);

		JButton_PersonCustomer.setText("Add Company Customer");
		JButton_PersonCustomer.setActionCommand("jbutton");
		this.add(JButton_PersonCustomer);
		JButton_PersonCustomer.setBounds(24, 20, 192, 33);

		JButton_CompanyCustomer.setText("Add Company Customer");
		JButton_CompanyCustomer.setActionCommand("jbutton");
		this.add(JButton_CompanyCustomer);
		JButton_CompanyCustomer.setBounds(240, 20, 192, 33);

		SymAction lSymAction = new SymAction();
		JButton_PersonCustomer.addActionListener(lSymAction);
		JButton_CompanyCustomer.addActionListener(lSymAction);
		
		displayCustomerList();
		setButtonNames();
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_PersonCustomer)
				JButtonPerCust_actionPerformed(event);
			else if (object == JButton_CompanyCustomer)
				JButtonCompCust_actionPerformed(event);
		}
	}
	
	protected javax.swing.JButton JButton_PersonCustomer = new javax.swing.JButton();
	protected javax.swing.JButton JButton_CompanyCustomer = new javax.swing.JButton();
	
	public abstract void setButtonNames();
	public abstract void displayCustomerList();
	public abstract void JButtonPerCust_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonCompCust_actionPerformed(java.awt.event.ActionEvent event);
}
