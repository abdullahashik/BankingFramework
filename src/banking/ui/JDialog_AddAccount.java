package banking.ui;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import framework.commands.Command;
import framework.commands.CommandManager;
import framework.commands.CreateAccountCommand;
import framework.dto.AccountDTO;
import framework.dto.PartyDTO;
import framework.entities.Party;
import framework.ui.AddAccountDialog;
import framework.util.ValidatorUtil;
import banking.services.AccountServiceImp;
import banking.services.PartyServiceImp;

public class JDialog_AddAccount extends AddAccountDialog {

	public JDialog_AddAccount() {
		super();
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		try {
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			Party pt = null;
			if (selection >= 0) {
				String partyId = (String) model.getValueAt(selection, 0);
				pt = PartyServiceImp.getInstance().findParty(partyId);
			} else {
				JOptionPane.showMessageDialog(this, "Please select a customer!");
				return;
			}

			isAddNew = true;
			AccountDTO pojoA = new AccountDTO();
			if (ValidatorUtil.isNumeric(JTextField_BALANCE.getText())) {
				pojoA.setBalance(Integer.parseInt(JTextField_BALANCE.getText()));
			} else {
				pojoA.setBalance(0);
			}
			pojoA.setType(accType);
			pojoA.setInterest(0);
			pojoA.setInterestRate(0);
			pojoA.setParty(pt);

			Command command = new CreateAccountCommand(AccountServiceImp.getInstance(), pojoA);
			CommandManager manager = CommandManager.getInstance();
			manager.setCommand(command);
			manager.invokeCommand();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		dispose();
	}

	public boolean isAddNew() {
		return isAddNew;
	}

	@Override
	public void initial() {
		setTitle("Add Account");
		JRadioButton_First.setText("Checking");
		JRadioButton_Second.setText("Saving");
		JRadioButton_Third.setVisible(false);
		JRadioButton_First.setSelected(true);
		JRadioButton_Second.setSelected(false);
		accType = "Ch";
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
	public void JRadioButtonFirst_mouseClicked(MouseEvent event) {
		JRadioButton_First.setSelected(true);
		JRadioButton_Second.setSelected(false);
		accType = "Ch";
	}

	@Override
	public void JRadioButtonSecond_mouseClicked(MouseEvent event) {
		JRadioButton_First.setSelected(false);
		JRadioButton_Second.setSelected(true);
		accType = "S";
	}

	@Override
	public void JRadioButtonThird_mouseClicked(MouseEvent event) {

	}
}
