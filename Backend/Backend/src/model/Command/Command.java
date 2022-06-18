package model.Command;

import model.Interpreter.*;

public abstract class Command {
	
	public static final int numOfArgs = 0;
	
	public abstract Token execute() throws Exception;
	public abstract void validate() throws Exception;
}
