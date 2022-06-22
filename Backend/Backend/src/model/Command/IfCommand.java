package model.Command;

public class IfCommand extends ConditionCommand{

    public IfCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute() {
        if(this.checkCondition()){
            for(Command command : this.commands){
                if (command != null) {
                    command.execute();
                }
            }
        }
    }
}
