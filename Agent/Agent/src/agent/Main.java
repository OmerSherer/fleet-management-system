package agent;

import view.CLIIO;
import view.View;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        View view = new View(new CLIIO());
        view.start();
    }
}
