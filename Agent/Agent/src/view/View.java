package view;

import java.util.Objects;

public class View implements IView {
    DefaultIO dio;

    public View(DefaultIO dio) {
        this.dio = dio;
    }

    @Override
    public void start() {
        String input;
        while (!Objects.equals(input = dio.readText(), "exit")){
            dio.write(input);
        }
    }
}
