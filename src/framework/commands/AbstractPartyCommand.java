package framework.commands;

import framework.services.AbstractPartyService;

public abstract class AbstractPartyCommand  implements Command {

	protected AbstractPartyService serviceP;
	
	public AbstractPartyCommand(AbstractPartyService serviceP) {
		super();
		this.serviceP = serviceP;
	}

	@Override
	public abstract void execute();

}
