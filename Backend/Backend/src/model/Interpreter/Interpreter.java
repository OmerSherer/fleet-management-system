package model.Interpreter;

import model.Command.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Interpreter {
    public static Queue<Command> interpret(String filePath){
        File file = new File(filePath);
        SymbolTable symbolTable = new SymbolTable();
        Queue<Command> commands = new LinkedList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                commands.add(Parser.parse(line, symbolTable, scanner));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commands;
    }

    public static void run(Queue<Command> commands){
        while(!commands.isEmpty()){
            Command command = commands.poll();
            if (command != null) {
                command.execute();
            }
        }
    }

}
