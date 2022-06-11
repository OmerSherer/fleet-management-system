package model;

import java.util.HashMap;
import model.Commands.Command;

public class Interpreter {
    HashMap<String, Command> map = new HashMap<>();

    public Interpreter() {
        Commands commands = new Commands();
        map.put("openServer", commands.new OpenServerCommand());
        map.put("connect", commands.new ConnectCommand());
        map.put("define", commands.new DefineVarCommand());

    }
}
