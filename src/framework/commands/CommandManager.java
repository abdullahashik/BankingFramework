package framework.commands;

public class CommandManager implements Invoker {

	Command command;
	private static CommandManager instance;
	
	private CommandManager(){
	}
	
	public static CommandManager getInstance(){
		if(instance == null)
			instance = new CommandManager();
		return instance;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void invokeCommand(){
		command.execute();
	}
	
}
