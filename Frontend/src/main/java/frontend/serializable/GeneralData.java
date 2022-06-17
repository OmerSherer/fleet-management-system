package frontend.serializable;

import java.io.Serializable;
import java.util.List;

public class GeneralData implements Serializable {
    public List<PlaneData> planesData;
    public double activePlanesPrecent;
    public List<Double> averageDistanceEachMonth;
    public List<PlaneAmount> planesOverTime;

    public GeneralData() {
    }

    public List<PlaneData> getPlanesData() {
        return planesData;
    }

    public void setPlanesData(List<PlaneData> planesData) {
        this.planesData = planesData;
    }

    public double getActivePlanesPrecent() {
        return activePlanesPrecent;
    }

    public void setActivePlanesPrecent(double activePlanesPrecent) {
        this.activePlanesPrecent = activePlanesPrecent;
    }

    public List<Double> getAverageDistanceEachMonth() {
        return averageDistanceEachMonth;
    }

    public void setAverageDistanceEachMonth(List<Double> averageDistanceEachMonth) {
        this.averageDistanceEachMonth = averageDistanceEachMonth;
    }

    public List<PlaneAmount> getPlanesOverTime() {
        return planesOverTime;
    }

    public void setPlanesOverTime(List<PlaneAmount> planesOverTime) {
        this.planesOverTime = planesOverTime;
    }

}
