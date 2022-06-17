package frontend.serializable;

import java.io.Serializable;
import java.util.Map;

public class MonitoringData implements Serializable {
    public Map<String, PlaneAttr> planeAttrs;
    public double height;
    public double direction;
    public double speed;
    public double horizon;
    public double turn;
    public double vertSpeed;

    public MonitoringData() {
    }

    public Map<String, PlaneAttr> getPlaneAttrs() {
        return planeAttrs;
    }

    public void setPlaneAttrs(Map<String, PlaneAttr> planeAttrs) {
        this.planeAttrs = planeAttrs;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHorizon() {
        return horizon;
    }

    public void setHorizon(double horizon) {
        this.horizon = horizon;
    }

    public double getTurn() {
        return turn;
    }

    public void setTurn(double turn) {
        this.turn = turn;
    }

    public double getVertSpeed() {
        return vertSpeed;
    }

    public void setVertSpeed(double vertSpeed) {
        this.vertSpeed = vertSpeed;
    }

}
