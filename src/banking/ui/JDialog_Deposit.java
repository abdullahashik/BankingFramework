package banking.ui;

import framework.commands.Command;
import framework.commands.CommandManager;
import framework.commands.DepositComand;
import framework.ui.DepositDialog;
import framework.util.ValidatorUtil;
import banking.services.AccountServiceImp;

public class JDialog_Deposit extends DepositDialog {

	public JDialog_Deposit(String aaccnr) {
		super(aaccnr);
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		if (!ValidatorUtil.isNumeric(JTextField_Deposit.getText())) {
			isNewDeposit = false;
			dispose();
			return;
		}
		Command command = new DepositComand(AccountServiceImp.getInstance(), accnr, Double.parseDouble(JTextField_Deposit.getText()));
		CommandManager manager = CommandManager.getInstance();
		manager.setCommand(command);
		try {
			manager.invokeCommand();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		dispose();
	}

}