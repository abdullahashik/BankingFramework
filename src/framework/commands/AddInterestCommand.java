package framework.commands;

import framework.services.AbstractAccountService;

public class AddInterestCommand extends AbstractAccountCommand{

	private double interest;
	
	public AddInterestCommand(AbstractAccountService service, double interest) {
		super(service);
		this.interest = interest;
	}
	
	@Override
	public void execute() throws RuntimeException{
		
	   //here call the service layer to save
       if (!serviceA.addInterest(interest))  //update the UI if the save success 
    	   throw new RuntimeException();

	}

}
