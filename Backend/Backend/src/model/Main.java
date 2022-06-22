package model;

import model.Command.Command;
import model.Command.PrintCommand;
import model.Command.VarCommand;
import model.Interpreter.SymbolTable;

public class Main {
    public static void main(String[] args) {
        String str = "var x = 1+1";
        String[] args1 = str.split(" ");
        Command command = new VarCommand();
        SymbolTable symbolTable = new SymbolTable();
        command.setSymbolTable(symbolTable);
        command.execute(args1);
        str = "var y = 2*(x+1)";
        args1 = str.split(" ");
        command = new VarCommand();
        command.setSymbolTable(symbolTable);
        command.execute(args1);
        str = "print y";
        args1 = str.split(" ");
        command = new PrintCommand();
        command.setSymbolTable(symbolTable);
        command.execute(args1);

    }
}
