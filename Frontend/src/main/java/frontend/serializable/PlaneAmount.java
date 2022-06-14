package frontend.serializable;

import java.io.Serializable;
import java.time.LocalDate;

public class PlaneAmount implements Serializable {
    public LocalDate date;
    public int amount;

    public PlaneAmount() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
