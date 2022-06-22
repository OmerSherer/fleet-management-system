package model;

import model.Command.Command;
import model.Command.PrintCommand;
import model.Command.VarCommand;
import model.Interpreter.Interpreter;
import model.Interpreter.SymbolTable;

public class Main {
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();
        Interpreter.run(Interpreter.interpret("src/model/resources/testcode.ptm"));

    }
}
