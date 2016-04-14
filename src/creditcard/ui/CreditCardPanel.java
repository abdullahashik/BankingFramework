package creditcard.ui;

import java.util.List;

import javax.swing.JOptionPane;

import framework.commands.Command;
import framework.commands.CommandManager;
import framework.commands.ReportCommand;
import framework.dto.AccountDTO;
import framework.dto.ReportDTO;
import framework.ui.AccountBasePanel;
import framework.ui.ReportDialog;
import creditcard.entities.Person;
import creditcard.services.AccountServiceImp;
import creditcard.services.ReportServiceImp;

@SuppressWarnings("serial")
public class CreditCardPanel extends AccountBasePanel {
	private final static String[] columnNames = new String[] { "Credit Card Acc No", "Name", "City", "Person/Company",
			"Type", "CC Amount", "Interest" };

	public CreditCardPanel() {
		super(columnNames);
		JButton_Addinterest.setVisible(false);
	}

	@Override
	public void displayAccountList() {
		List<AccountDTO> custList = AccountServiceImp.getInstance().getAllAccounts();
		if (custList != null && model != null) {
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int i = 0; i < custList.size(); i++) {
				AccountDTO obj = custList.get(i);
				if (obj != null) {
					rowdata[0] = obj.getAccountNumber();
					rowdata[1] = obj.getParty().getName();
					rowdata[2] = obj.getParty().getAddress().getCity();
					if (obj.getParty() instanceof Person) {
						rowdata[3] = "P";
					} else {
						rowdata[3] = "C";
					}
					rowdata[4] = obj.getType();
					rowdata[5] = obj.getBalance();
					rowdata[6] = obj.getInterest();
					model.addRow(rowdata);
				}
			}
		}
	}

	@Override
	public void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	@Override
	public void JButtonAddAcc_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog_AddCreditCard pac = new JDialog_AddCreditCard();
		pac.setBounds(450, 20, 600, 400);
		pac.show();
		if (pac.isAddNew()) {
			displayAccountList();
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
	}

	@Override
	public void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			JDialog_Deposit dep = new JDialog_Deposit(accnr);
			dep.setBounds(430, 15, 275, 200);
			dep.show();
			if (dep.isNewDeposit()) {
				displayAccountList();
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please select an account to deposit!");
			return;
		}
	}

	@Override
	public void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			Double currAmount = (Double) model.getValueAt(selection, 5);
			JDialog_Charge wd = new JDialog_Charge(accnr, currAmount);
			wd.setBounds(430, 15, 275, 200);
			wd.show();
			if (wd.isNewWithdraw()) {
				displayAccountList();
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please select an account to charge!");
			return;
		}
	}

	@Override
	public void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog_AddInterest wd = new JDialog_AddInterest();
		wd.setBounds(300, 25, 300, 220);
		wd.show();
		displayAccountList();
	}

	@Override
	public void JButtonReport_actionPerformed(java.awt.event.ActionEvent event) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			ReportDTO dto = new ReportDTO();
			dto.setFilter(accnr);
			dto.setType("Monthly");
			Command command = new ReportCommand(ReportServiceImp.getInstance(), dto);
			CommandManager manager = CommandManager.getInstance();
			manager.setCommand(command);
			manager.invokeCommand();
			String tmpStr = ((ReportCommand) command).getReportResult();
			ReportDialog re = new ReportDialog(tmpStr);
			re.setBounds(200, 50, 600, 350);
			re.show();
		} else {
			JOptionPane.showMessageDialog(this, "Please select an account to make the report!");
			return;
		}
	}

	@Override
	public void setButtonNames() {
		JButton_AddAcc.setText("Create A Credit Card Account");
		JButton_Addinterest.setText("Add Interest");
		JButton_Deposit.setText("Deposit");
		JButton_Exit.setText("Exit");
		JButton_Report.setText("Report");
		JButton_Withdraw.setText("Charge");
	}

}
