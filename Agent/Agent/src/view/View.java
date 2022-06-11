package view;

import controller.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

public class View implements IView {
    DefaultIO dio;
    PropertyChangeSupport support;


    public View(DefaultIO dio) {
        this.dio = dio;
        support = new PropertyChangeSupport(this);
       // support.addPropertyChangeListener(c);
    }

    @Override
    public void start() {
        String input;
        while (!Objects.equals(input = dio.readText(), "exit")){
            dio.write(input);
            support.firePropertyChange(new PropertyChangeEvent(this, "input", null, input));
        }
    }

    public void addSupportListener(PropertyChangeListener pcl){
        support.addPropertyChangeListener(pcl);
    }
}
