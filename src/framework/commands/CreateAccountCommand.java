package framework.commands;

import framework.dto.AccountDTO;
import framework.services.AbstractAccountService;

public class CreateAccountCommand extends AbstractAccountCommand {

	private AccountDTO dto;
	
	public CreateAccountCommand(AbstractAccountService serviceA, AccountDTO dto) {
		super(serviceA);
		this.dto = dto;
	}

	@Override
	public void execute() {
		//here call the service layer to save
	       if (!serviceA.saveAccount(dto))  //update the UI if the save success 
	    	   throw new RuntimeException();
	}
	
}
