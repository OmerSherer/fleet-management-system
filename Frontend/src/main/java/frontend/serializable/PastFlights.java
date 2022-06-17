package frontend.serializable;

import java.io.Serializable;
import java.util.List;

public class PastFlights implements Serializable {
    List<PastFlight> pastFlights;

    public PastFlights() {
    }

    public List<PastFlight> getPastFlights() {
        return pastFlights;
    }

    public void setPastFlights(List<PastFlight> pastFlights) {
        this.pastFlights = pastFlights;
    }
}
