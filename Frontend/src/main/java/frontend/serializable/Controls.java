package frontend.serializable;

public class Controls extends AgentData {
    public float aileron;
    public float elevator;
    public float rudder;
    public float throttle;

    public Controls() {
    }

    public Controls(float aileron, float elevator, float rudder, float throttle) {
        this.aileron = aileron;
        this.elevator = elevator;
        this.rudder = rudder;
        this.throttle = throttle;
    }

}
