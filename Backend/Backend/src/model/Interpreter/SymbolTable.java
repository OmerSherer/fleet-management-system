package model.Interpreter;

import java.util.HashMap;

public class SymbolTable {
    public static HashMap<String, Variable> variables = new HashMap<>();

    public static Variable getVariable(String x) {
        return variables.get(x);
    }

    public static Variable addVariable(String name){
        if (!variables.containsKey(name)) {
            variables.put(name, new Variable(name, 0.0, null));
        }
        return variables.get(name);
    }


    public static boolean containsKey(String arg) {
        return variables.containsKey(arg);
    }

    public static Variable[] getVariables() {
        return variables.values().toArray(new Variable[variables.size()]);
    }
}
