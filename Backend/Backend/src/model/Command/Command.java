package model.Command;

import model.Interpreter.SymbolTable;

public abstract class Command {
    protected SymbolTable symbolTable;
    protected String[] args;

    public Command(String[] args) {
        this.args = args;
    }

    public abstract void execute();
    public void setSymbolTable(SymbolTable symbolTable){
        this.symbolTable = symbolTable;
    }
}
