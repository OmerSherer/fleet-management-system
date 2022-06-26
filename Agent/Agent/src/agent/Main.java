package agent;

import controller.Controller;
import model.Model;
import view.CLIIO;
import view.View;

public class Main {
    public static void mian(String[] args) {
        System.out.println("Hello World!");
        View view = new View(new CLIIO());
        Model model = new Model();
        Controller controller = new Controller(view, model);

        view.start();
    }
}
