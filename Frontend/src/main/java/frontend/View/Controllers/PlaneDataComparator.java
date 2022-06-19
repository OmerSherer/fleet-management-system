package frontend.View.Controllers;

import java.util.Comparator;

import frontend.serializable.PlaneData;

public class PlaneDataComparator implements Comparator<PlaneData> {

    @Override
    public int compare(PlaneData o1, PlaneData o2) {
        return (int) ((int) o1.miles - o2.miles);
    }

}
