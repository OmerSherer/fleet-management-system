package frontend.serializable;

import java.io.Serializable;
import java.time.LocalDate;

public class PastFlight implements Serializable {
    public LocalDate date;
    public int length;
    public String agent;
    public int id;

    public PastFlight() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
