package model.Command;

import model.Expression.ExpressionEvaluator;
import model.Interpreter.SymbolTable;
import model.Interpreter.Variable;

public class VarCommand extends Command{

    @Override
    public void execute(String[] args) {
        if(args.length < 4) {
            System.out.println("Invalid number of arguments");
            return;
        }
        if(args[3].equals("bind")){
            symbolTable.addVariable(args[1]);
            symbolTable.getVariable(args[1]).setSim(args[4]);

            return;
        }

        // for each variable in the symbol table, check if it is exists in the args[3] and if it is, replace it with the value in the symbol table
        for(Variable var : symbolTable.getVariables()){
            if(args[3].contains(var.getName())){
                // get the index of the variable in the args[3]
                int index = args[3].indexOf(var.getName());
                // replace the variable with the value in the symbol table
                args[3] = args[3].substring(0, index) + var.getValue() + args[3].substring(index + var.getName().length());
            }
        }

        String varName = args[1];
        double varValue = (double) 0;
        if (ExpressionEvaluator.isExpression(args[3])){
            varValue = ExpressionEvaluator.evaluate(args[3]);
        } else if (ExpressionEvaluator.isDouble(args[3])) {
            varValue = Double.parseDouble(args[3]);
        } else if (symbolTable.containsKey(args[3])) {
            varValue = symbolTable.getVariable(args[3]).getValue();
        } else {
            System.out.println("Invalid value");
        }
        symbolTable.addVariable(varName).setValue(varValue);


    }

    @Override
    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }


    public static void main(String[] args) {
        VarCommand command = new VarCommand();
        SymbolTable symbolTable = new SymbolTable();
        command.setSymbolTable(symbolTable);
        String str = "var x = 1+1";
        String[] args1 = str.split(" ");
        command.execute(args1);
        str = "var x = bind \"sim\"";
        command.execute(str.split(" "));
        str = "var y = x+1";
        command.execute(str.split(" "));
        System.out.println(symbolTable.getVariable("x").getValue());
        System.out.println(symbolTable.getVariable("x").getSim());
        System.out.println(symbolTable.getVariable("y").getValue());
    }
}
