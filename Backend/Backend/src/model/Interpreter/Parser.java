package model.Interpreter;

import model.Command.Command;
import model.Command.CommandFactory;
import model.Command.ConditionCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Parser {

    public static Command parse(String code, SymbolTable symbolTable, Scanner scanner) {
        try {

            // delete empty spaces in the beginning and end of the line
            code = code.trim();

            // split the line into words
            String[] args = code.split(" ");


            if(CommandFactory.commands.containsKey(args[0])){
                Command command = (Command) CommandFactory.commands.get(args[0]).getConstructor(String[].class).newInstance((Object) args);
                command.setSymbolTable(symbolTable);
                if(command instanceof ConditionCommand){
                    ((ConditionCommand) command).SetConditionCommand(scanner);
                }

                return command;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
