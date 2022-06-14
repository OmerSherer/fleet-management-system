package frontend.serializable;

import java.io.Serializable;

public class Point implements Serializable {
    public double x;
    public boolean isAnomaly;

    public Point() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public boolean isAnomaly() {
        return isAnomaly;
    }

    public void setAnomaly(boolean isAnomaly) {
        this.isAnomaly = isAnomaly;
    }

}
