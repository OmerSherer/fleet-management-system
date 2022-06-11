package model;

import java.util.HashMap;
import model.Commands.Command;

public class Interpreter {
    HashMap<String, Command> map = new HashMap<>();

    public Interpreter() {
        Commands commands = new Commands();
        map.put("openDataServer", commands.new OpenServerCommand());
        map.put("connect", commands.new ConnectCommand());
        map.put("define", commands.new DefineVarCommand());
        map.put("print", commands.new PrintCommand());
    }

    public void interpret(String commands) {
        if(commands.isEmpty()){
            return;
        }
        String[] arr = commands.split(" ");
        int index = 0;
        while (index < arr.length) {
            String command = arr[index];
            Command c = map.get(command);
            if (c != null) {
                index = c.execute(arr, index);
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        interpreter.interpret("connect print \"Hello World\"");
    }

}
