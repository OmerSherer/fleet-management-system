package Command;

import Interpreter.Token;

public class ConstantValue extends Command.Command {

	private Token value;
		
	public ConstantValue(Token value) {
		this.value = value;
	}
	
	@Override
	public Token execute() throws Exception {
		return value;
	}

	@Override
	public void validate() throws Exception {}

}
