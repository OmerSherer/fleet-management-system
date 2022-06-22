package model.Command;

import java.util.HashMap;

public class CommandFactory {
    public static HashMap<String, Class<? extends Command>> commands = new HashMap<>();

    static {
        commands.put("var", VarCommand.class);
        commands.put("print", PrintCommand.class);
        commands.put("if", IfCommand.class);
    }
}
