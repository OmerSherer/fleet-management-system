package model.Interpreter;

public class Variable {
    String name;
    Double value;
    String sim;

    public Variable() {
    }

    public Variable(String name, Double i, String s) {
        this.name = name;
        this.value = i;
        this.sim = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public Variable setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getSim() {
        return sim;
    }

    public Variable setSim(String sim) {
        this.sim = sim;
        return this;
    }


}
