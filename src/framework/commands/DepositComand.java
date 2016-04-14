package framework.commands;

import framework.services.AbstractAccountService;
public class DepositComand extends AbstractAccountCommand {

	private String accountNumber;
	private double ammount;
	
	public DepositComand(AbstractAccountService service, String accountNumber, double ammount){
		super(service);
		this.accountNumber = accountNumber;
		this.ammount = ammount;
	}
	
	@Override
	public void execute() throws RuntimeException{
		if (!serviceA.deposit(accountNumber, ammount))
			throw new RuntimeException();
		
	}

}
