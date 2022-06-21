package frontend.View.Controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import frontend.serializable.CorrelationType;
import frontend.serializable.PlaneAttr;
import frontend.serializable.Point;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Affine;

public class MonitoringController extends FxmlController {

    @FXML
    private ListView<String> attrs;

    @FXML
    private Canvas direction;

    @FXML
    private LineChart<Integer, Double> firstParam;

    @FXML
    private Menu fleetOverviewMenuItem;

    @FXML
    private Canvas height;

    @FXML
    private Canvas horizon;

    @FXML
    private Canvas mainChart;

    @FXML
    private Menu monitoringMenuItem;

    @FXML
    private Slider rudder;

    @FXML
    private LineChart<Integer, Double> secondParam;

    @FXML
    private Canvas speed;

    @FXML
    private Menu teleoperationMenuItem;

    @FXML
    private Slider throttle;

    @FXML
    private Menu timeCapsuleMenuItem;

    @FXML
    private Canvas turn;

    @FXML
    private Canvas vertSpeed;

    @Override
    public void onLoad() {
        onMonitoringDataChange();
    }

    private void drawLine(Canvas c, Double var, Double coeff) {
        c.getGraphicsContext2D().strokeLine(0, c.getHeight() - coeff, c.getWidth(),
                c.getHeight() - (c.getWidth() * var + coeff));
    }

    private void drawCircle(Canvas c, Double xCenter, Double yCenter, Double radius) {
        c.getGraphicsContext2D().strokeOval(xCenter, c.getHeight() - yCenter, radius * 2, radius * 2);
    }

    @Override
    protected void onMonitoringDataChange() {
        // String[] strings = monitoringData.get().planeAttrs.keySet().toArray();
        String[] strings = { "a", "b", "c", "d" };
        attrs.getItems().addAll(strings);
        attrs.getSelectionModel().selectedIndexProperty()
                .addListener((arg0) -> onSelectedAttrChange(strings[((ReadOnlyIntegerProperty) arg0).get()]));
    }

    private void onSelectedAttrChange(String attr) {
        Map<String, PlaneAttr> planeAttrs = monitoringData.get().planeAttrs;
        PlaneAttr planeAttr = planeAttrs.get(attr);

        List<Double> attr1 = planeAttr.getData().stream()
                .map(Point::getX)
                .collect(Collectors.toList());
        LineChart.Series<Integer, Double> series1 = new LineChart.Series<>();
        for (int i = 0; i < attr1.size(); i++) {
            series1.getData().add(new LineChart.Data<Integer, Double>(
                    i, attr1.get(i)));
        }
        firstParam.getData().clear();
        firstParam.getData().add(series1);
        firstParam.legendVisibleProperty().set(false);

        if (!(planeAttr.correlationType == CorrelationType.ZScore)) {
            List<Double> attr2 = planeAttrs.get(planeAttr.correlativeAttr).getData().stream()
                    .map(Point::getX)
                    .collect(Collectors.toList());
            LineChart.Series<Integer, Double> series2 = new LineChart.Series<>();
            for (int i = 0; i < attr2.size(); i++) {
                series2.getData().add(new LineChart.Data<Integer, Double>(
                        i, attr2.get(i)));
            }
            secondParam.getData().clear();
            secondParam.getData().add(series2);
            secondParam.legendVisibleProperty().set(false);

            Double xMin = attr1.stream().min((Double o1, Double o2) -> ((Double) (o1 - o2)).intValue()).get();
            Double xMax = attr1.stream().max((Double o1, Double o2) -> ((Double) (o1 - o2)).intValue()).get();
            Double yMin = attr2.stream().min((Double o1, Double o2) -> ((Double) (o1 - o2)).intValue()).get();
            Double yMax = attr2.stream().max((Double o1, Double o2) -> ((Double) (o1 - o2)).intValue()).get();
            // Double xMin = attr1.stream().min((Double o1, Double o2) -> ((Double) (o1 -
            // o2)).intValue()).get() / 1.1;
            // Double xMax = attr1.stream().max((Double o1, Double o2) -> ((Double) (o1 -
            // o2)).intValue()).get() * 1.1;
            // Double yMin = attr2.stream().min((Double o1, Double o2) -> ((Double) (o1 -
            // o2)).intValue()).get() / 1.1;
            // Double yMax = attr2.stream().max((Double o1, Double o2) -> ((Double) (o1 -
            // o2)).intValue()).get() * 1.1;

            Double scaleX = mainChart.getWidth() / (xMax - xMin);
            Double scaleY = mainChart.getHeight() / (yMax - yMin);

            Double scale;
            if (scaleX - scaleY < 0) {
                scale = scaleX;
            } else {
                scale = scaleY;
            }

            GraphicsContext gc = mainChart.getGraphicsContext2D();
            gc.scale(scale, scale);

            if (planeAttr.correlationType == CorrelationType.LinearRegression) {
                drawLine(mainChart, planeAttr.variable, planeAttr.coefficient);
            } else {
                drawCircle(mainChart, planeAttr.xCenter, planeAttr.yCenter, planeAttr.threshold);
            }

            for (int i = 0; i < attr1.size(); i++) {
                gc.setFill(Color.NAVY);
                if (planeAttr.data.get(i).isAnomaly) {
                    gc.setFill(Color.RED);
                }
                gc.fillOval(attr1.get(i) - xMin, attr2.get(i) - yMin, 5, 5);
            }

        } else {
            Double xMin = attr1.stream().min((Double o1, Double o2) -> ((Double) (o1 - o2)).intValue()).get();
            Double xMax = attr1.stream().max((Double o1, Double o2) -> ((Double) (o1 - o2)).intValue()).get();
            // Double xMin = attr1.stream().min((Double o1, Double o2) -> ((Double) (o1 -
            // o2)).intValue()).get() / 1.1;
            // Double xMax = attr1.stream().max((Double o1, Double o2) -> ((Double) (o1 -
            // o2)).intValue()).get() * 1.1;
            Double scaleX = mainChart.getWidth() / (xMax - xMin);
        }

    }

}
