package controller;

import model.Model;
import view.View;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observer;

public class Controller implements PropertyChangeListener {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addSupportListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getSource() instanceof View){
            System.out.println(evt.getNewValue());
        }
    }
}
