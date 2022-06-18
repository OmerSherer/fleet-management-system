package model;

import model.Interpreter.Interpreter;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            Interpreter.run(Interpreter.getCommands(new File("src/model/resources/testcode.ptm")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
