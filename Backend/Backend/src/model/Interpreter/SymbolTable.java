package model.Interpreter;

import java.util.Arrays;
import java.util.HashMap;

public class SymbolTable {
    public HashMap<String, Variable> variables = new HashMap<>();
    public SymbolTable parent;

    public SymbolTable(SymbolTable symbolTable) {
        this.parent = symbolTable;

    }

    public SymbolTable() {
    }

    public  Variable getVariable(String x) {
        if(variables.containsKey(x)){
            return variables.get(x);
        }
        else if(parent != null){
            return parent.getVariable(x);
        }
        else{
            return null;
        }
    }

    public Variable addVariable(String name){
        if (!variables.containsKey(name)) {
            variables.put(name, new Variable(name, 0.0, null));
        }
        return variables.get(name);
    }


    public boolean containsKey(String arg) {
        return variables.containsKey(arg) || (parent != null && parent.containsKey(arg));
    }

    public Variable[] getVariables() {
        // return an array of variables and the parent's variables
        Variable[] variables = new Variable[this.variables.size()];
        int i = 0;
        for (Variable variable : this.variables.values()) {
            variables[i] = variable;
            i++;
        }
        if (parent != null) {
            Variable[] parentVariables = parent.getVariables();
            for (Variable variable : parentVariables) {
                if (!Arrays.asList(variables).contains(variable)) {
                    variables = Arrays.copyOf(variables, variables.length + 1);
                    variables[variables.length - 1] = variable;
                }
                }
            }
        return variables;
        }


    }

