package framework.commands;

public interface Invoker {

	public void setCommand(Command command);
	
	public void invokeCommand();
}
