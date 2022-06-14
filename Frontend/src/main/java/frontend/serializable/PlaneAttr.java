package frontend.serializable;

import java.io.Serializable;
import java.util.List;

public class PlaneAttr implements Serializable {
    public String correlativeAttr;
    public double mean;
    public String correlationType;
    public double std;
    public double threshold;
    public double xCenter;
    public double yCenter;
    public double radius;
    public double coefficient;
    public double variable;
    public List<Point> data;

    public PlaneAttr() {
    }

    public String getCorrelativeAttr() {
        return correlativeAttr;
    }

    public void setCorrelativeAttr(String correlativeAttr) {
        this.correlativeAttr = correlativeAttr;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public String getCorrelationType() {
        return correlationType;
    }

    public void setCorrelationType(String correlationType) {
        this.correlationType = correlationType;
    }

    public double getStd() {
        return std;
    }

    public void setStd(double std) {
        this.std = std;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getxCenter() {
        return xCenter;
    }

    public void setxCenter(double xCenter) {
        this.xCenter = xCenter;
    }

    public double getyCenter() {
        return yCenter;
    }

    public void setyCenter(double yCenter) {
        this.yCenter = yCenter;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getVariable() {
        return variable;
    }

    public void setVariable(double variable) {
        this.variable = variable;
    }

    public List<Point> getData() {
        return data;
    }

    public void setData(List<Point> data) {
        this.data = data;
    }

}
