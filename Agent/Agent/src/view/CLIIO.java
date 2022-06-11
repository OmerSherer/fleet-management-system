package view;

import java.util.Scanner;


public class CLIIO implements DefaultIO{
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String readText() {
        return scanner.nextLine();
    }

    @Override
    public float readVal() {
        return scanner.nextFloat();
    }

    @Override
    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public void write(float val) {
        System.out.println(val);
    }
}
