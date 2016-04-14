package creditcard.ui;

import framework.commands.Command;
import framework.commands.CommandManager;
import framework.commands.CreatePartyCommand;
import framework.dto.PartyDTO;
import framework.ui.AddCutomerDialog;
import framework.util.GeneratorUtil;
import framework.util.ValidatorUtil;
import creditcard.services.PartyServiceImp;

public class JDialog_AddCutomer extends AddCutomerDialog {

	public JDialog_AddCutomer(String custType) {
		super(custType);
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		try {
			isAddNew = true;
			pojoP = new PartyDTO();
			pojoP.setName(JTextField_NAME.getText());
			pojoP.setCity(JTextField_CT.getText());
			pojoP.setEmail(JTextField_EM.getText());
			pojoP.setZip(JTextField_ZIP.getText());
			pojoP.setStreet(JTextField_STR.getText());
			pojoP.setState(JTextField_ST.getText());
			if ("P".equalsIgnoreCase(custType)) {
				pojoP.setBirthDate(GeneratorUtil.getDateFromString(JTextField_BD.getText()));
				pojoP.setType("P");
			} else {
				if (ValidatorUtil.isNumeric(JTextField_NoOfEmp.getText())) {
					pojoP.setNumberOfEmployees(Integer.parseInt(JTextField_NoOfEmp.getText()));
				} else {
					pojoP.setNumberOfEmployees(0);
				}
				pojoP.setType("C");
			}
			Command command = new CreatePartyCommand(PartyServiceImp.getInstance(), pojoP);
			CommandManager manager = CommandManager.getInstance();
			manager.setCommand(command);
			manager.invokeCommand();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		dispose();
	}
}