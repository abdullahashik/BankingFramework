package framework.commands;

import framework.services.AbstractAccountService;

public class WithdrawComand extends AbstractAccountCommand {

	private String accountNumber;
	private double ammount;
	
	public WithdrawComand(AbstractAccountService service, String accountNumber, double ammount){
		super(service);
		this.accountNumber = accountNumber;
		this.ammount = ammount;
	}
	
	@Override
	public void execute() throws RuntimeException{
		if (!serviceA.wihdraw(accountNumber, ammount))
			throw new RuntimeException();
		
	}

}
