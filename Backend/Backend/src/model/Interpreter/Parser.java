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
                // create a symbol table that contains all the variables in the current scope

                if(command instanceof ConditionCommand){
                    SymbolTable currentSymbolTable = new SymbolTable(symbolTable);
                    command.setSymbolTable(currentSymbolTable);
                    ((ConditionCommand) command).SetConditionCommand(scanner);
                }
                else {
                    command.setSymbolTable(symbolTable);
                }

                return command;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
