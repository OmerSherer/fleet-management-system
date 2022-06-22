package model.Interpreter;

import model.Command.Command;
import model.Command.CommandFactory;

import java.lang.reflect.InvocationTargetException;

public class Parser {

    public static Command parse(String code, SymbolTable symbolTable) {
        try {
            String[] args = code.split(" ");

            if(CommandFactory.commands.containsKey(args[0])){
                Command command = (Command) CommandFactory.commands.get(args[0]).getConstructor(String[].class).newInstance((Object) args);
                command.setSymbolTable(symbolTable);
                return command;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
