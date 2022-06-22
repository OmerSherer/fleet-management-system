package model.Command;

import model.Interpreter.SymbolTable;

public abstract class Command {
    protected SymbolTable symbolTable;
    public abstract void execute(String[] args);
    public abstract void setSymbolTable(SymbolTable symbolTable);
}
