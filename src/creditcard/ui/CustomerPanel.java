package creditcard.ui;

import java.util.List;

import framework.dto.PartyDTO;
import framework.ui.CustomerBasePanel;
import creditcard.services.PartyServiceImp;

public class CustomerPanel extends CustomerBasePanel {
	private final static String[] columnNames = new String[] { "Customer No", "Name", "City", "Person/Company", "Email",
			"DOB", "Employee No" };

	public CustomerPanel() {
		super(columnNames);
	}

	@Override
	public void displayCustomerList() {
		List<PartyDTO> custList = PartyServiceImp.getInstance().getAllParties();
		if (custList != null) {
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int i = 0; i < custList.size(); i++) {
				PartyDTO obj = custList.get(i);
				if (obj != null) {
					rowdata[0] = obj.getId();
					rowdata[1] = obj.getName();
					rowdata[2] = obj.getCity();
					rowdata[3] = obj.getType();
					rowdata[4] = obj.getEmail();
					rowdata[5] = obj.getBirthDate() != null ? obj.getBirthDate().toString() : "";
					rowdata[6] = obj.getNumberOfEmployees();
					model.addRow(rowdata);
				}
			}
		}
	}

	@Override
	public void JButtonPerCust_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog_AddCutomer pac = new JDialog_AddCutomer("P");
		pac.setBounds(350, 20, 300, 300);
		pac.show();

		if (pac.isAddNew()) {
			displayCustomerList();
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
	}

	@Override
	public void JButtonCompCust_actionPerformed(java.awt.event.ActionEvent event) {

		JDialog_AddCutomer pac = new JDialog_AddCutomer("C");
		pac.setBounds(350, 20, 300, 300);
		pac.show();

		if (pac.isAddNew()) {
			displayCustomerList();
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
	}

	@Override
	public void setButtonNames() {
		JButton_CompanyCustomer.setText("Add Company Customer");
		JButton_PersonCustomer.setText("Add Person Customer");
	}
}
