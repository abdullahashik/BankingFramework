package creditcard.ui;

import framework.commands.Command;
import framework.commands.CommandManager;
import framework.commands.WithdrawComand;
import framework.ui.WithdrawDialog;
import framework.util.ValidatorUtil;
import creditcard.services.AccountServiceImp;

public class JDialog_Charge extends WithdrawDialog {

	public JDialog_Charge(String aaccnr, double currentBal) {
		super(aaccnr, currentBal);
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		if (!ValidatorUtil.isNumeric(JTextField_AMT.getText())) {
			isNewWithdraw = false;
			dispose();
			return;
		}
		double deposit = Double.parseDouble(JTextField_AMT.getText());
		Command command = new WithdrawComand(AccountServiceImp.getInstance(), accnr, deposit);
		CommandManager manager = CommandManager.getInstance();
		manager.setCommand(command);
		try {
			manager.invokeCommand();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		dispose();
	}

	@Override
	public void setComponentNames() {
		setTitle("Charge");
	}
}