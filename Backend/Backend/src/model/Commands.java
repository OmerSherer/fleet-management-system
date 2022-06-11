package model;

public class Commands {
    public interface ICommand {
        void execute();
    }

    public abstract class Command implements ICommand {
        public abstract void execute();
    }

    public class OpenServerCommand extends Command {
        public void execute() {
            System.out.println("server opened!");
        }
    }

    public class ConnectCommand extends Command {
        public void execute() {
            System.out.println("connected!");
        }
    }

    public class DefineVarCommand extends Command {
        public void execute() {
            System.out.println("var defined!");
        }
    }

}
