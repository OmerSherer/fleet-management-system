package frontend.View.Controllers;

import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import frontend.serializable.PlaneAmount;
import frontend.serializable.PlaneData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Menu;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;

public class FleetOverview extends FxmlController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Menu fleetOverviewMenuItem;

        @FXML
        private Canvas map;

        @FXML
        private Menu monitoringMenuItem;

        @FXML
        private LineChart<String, Integer> sizeVsTime;

        @FXML
        private BarChart<String, Double> startMonthChart;

        @FXML
        private BarChart<String, Double> startYearChart;

        @FXML
        private Menu teleoperationMenuItem;

        @FXML
        private Menu timeCapsuleMenuItem;

        @FXML
        private PieChart usedVsUnused;

        @FXML
        void initialize() {
                assert fleetOverviewMenuItem != null
                                : "fx:id=\"fleetOverviewMenuItem\" was not injected: check your FXML file 'fleetoverview.fxml'.";
                assert map != null : "fx:id=\"map\" was not injected: check your FXML file 'fleetoverview.fxml'.";
                assert monitoringMenuItem != null
                                : "fx:id=\"monitoringMenuItem\" was not injected: check your FXML file 'fleetoverview.fxml'.";
                assert sizeVsTime != null
                                : "fx:id=\"sizeVsTime\" was not injected: check your FXML file 'fleetoverview.fxml'.";
                assert startMonthChart != null
                                : "fx:id=\"startMonthChart\" was not injected: check your FXML file 'fleetoverview.fxml'.";
                assert startYearChart != null
                                : "fx:id=\"startYearChart\" was not injected: check your FXML file 'fleetoverview.fxml'.";
                assert teleoperationMenuItem != null
                                : "fx:id=\"teleoperationMenuItem\" was not injected: check your FXML file 'fleetoverview.fxml'.";
                assert timeCapsuleMenuItem != null
                                : "fx:id=\"timeCapsuleMenuItem\" was not injected: check your FXML file 'fleetoverview.fxml'.";
                assert usedVsUnused != null
                                : "fx:id=\"usedVsUnused\" was not injected: check your FXML file 'fleetoverview.fxml'.";
        }

        @Override
        public void onLoad() {
                // frontendView.getGeneralData();
                onGeneralDataChange();
        }

        @Override
        protected void onGeneralDataChange() {
                String[] months = {
                                "Jan",
                                "Feb",
                                "Mar",
                                "Apr",
                                "May",
                                "Jun",
                                "Jul",
                                "Aug",
                                "Sep",
                                "Oct",
                                "Nov",
                                "Dec",
                };
                // temp
                double activePlanesPrecent = 40;
                List<PlaneAmount> planesOverTime = new LinkedList<>();
                PlaneAmount planeAmount1 = new PlaneAmount();
                planeAmount1.setDate(LocalDate.now());
                planeAmount1.setAmount(2);
                PlaneAmount planeAmount2 = new PlaneAmount();
                planeAmount2.setDate(LocalDate.now().plusDays(3));
                planeAmount2.setAmount(5);
                planesOverTime.add(planeAmount1);
                planesOverTime.add(planeAmount2);
                List<Double> averageDistanceEachMonth = new LinkedList<>();
                averageDistanceEachMonth.add((Double) 3.0);
                averageDistanceEachMonth.add((Double) 5.0);
                averageDistanceEachMonth.add((Double) 4.0);
                averageDistanceEachMonth.add((Double) 7.0);
                averageDistanceEachMonth.add((Double) 3.0);
                averageDistanceEachMonth.add((Double) 6.0);
                averageDistanceEachMonth.add((Double) 9.0);
                averageDistanceEachMonth.add((Double) 1.0);
                averageDistanceEachMonth.add((Double) 6.0);
                averageDistanceEachMonth.add((Double) 2.0);
                averageDistanceEachMonth.add((Double) 0.0);
                averageDistanceEachMonth.add((Double) 12.0);
                List<PlaneData> planesData = new LinkedList<>();
                PlaneData planeData1 = new PlaneData();
                planeData1.setName("oz");
                planeData1.setMiles(5);
                planesData.add(planeData1);
                PlaneData planeData2 = new PlaneData();
                planeData2.setName("Yonatan");
                planeData2.setMiles(2);
                planesData.add(planeData2);
                PlaneData planeData3 = new PlaneData();
                planeData3.setName("Omer");
                planeData3.setMiles(10);
                planesData.add(planeData3);
                PlaneData planeData4 = new PlaneData();
                planeData4.setName("Idan");
                planeData4.setMiles(3);
                planesData.add(planeData4);

                // uncomment
                // double activePlanesPrecent = generalData.get().activePlanesPrecent;
                // List<PlaneAmount> planesOverTime = generalData.get().planesOverTime;
                // List<Double> averageDistanceEachMonth =
                // generalData.get().averageDistanceEachMonth;
                // List<PlaneData> planesData = generalData.get().planesData;

                Image image;
                try {
                        image = new Image(frontendView.getClass().getResource("israel-airports-map.jpeg").toURI()
                                        .toString());
                        map.getGraphicsContext2D().drawImage(image, 0, 0,
                                        image.getWidth() / (image.getWidth() / map.getWidth()),
                                        image.getHeight() / (image.getWidth() / map.getWidth()));
                } catch (URISyntaxException e) {
                        e.printStackTrace();
                }
                List<PieChart.Data> precenteges = new LinkedList<>();
                precenteges.add(new Data("used", activePlanesPrecent));
                precenteges.add(new Data("not used", 100 - activePlanesPrecent));
                ObservableList<PieChart.Data> observableList = FXCollections.observableList(precenteges);
                usedVsUnused.setData(observableList);
                usedVsUnused.getData().forEach(data -> {
                        String percentage = String.format("%.2f%%", (data.getPieValue()));
                        Tooltip toolTip = new Tooltip(percentage);
                        Tooltip.install(data.getNode(), toolTip);
                });

                List<Integer> amounts = planesOverTime.stream()
                                .map(PlaneAmount::getAmount)
                                .collect(Collectors.toList());
                List<LocalDate> dates = planesOverTime.stream()
                                .map(PlaneAmount::getDate)
                                .collect(Collectors.toList());
                LineChart.Series<String, Integer> series = new LineChart.Series<>();
                for (int i = 0; i < amounts.size(); i++) {
                        series.getData().add(new LineChart.Data<String, Integer>(
                                        dates.get(i).format(DateTimeFormatter.ISO_LOCAL_DATE), amounts.get(i)));
                }
                sizeVsTime.getData().clear();
                sizeVsTime.getData().add(series);
                sizeVsTime.legendVisibleProperty().set(false);

                BarChart.Series<String, Double> e = new BarChart.Series<>();
                for (int i = 0; i < averageDistanceEachMonth.size(); i++) {
                        e.getData().add(new BarChart.Data<String, Double>(months[i], averageDistanceEachMonth.get(i)));
                }
                startYearChart.setLegendVisible(false);
                startYearChart.getData().add(e);

                List<String> agents = new LinkedList<>();
                List<Double> miles = new LinkedList<>();
                java.util.Collections.sort(planesData, new PlaneDataComparator());
                for (PlaneData planeData : planesData) {
                        agents.add(planeData.name);
                        miles.add(planeData.miles);
                }
                BarChart.Series<String, Double> s = new BarChart.Series<>();
                for (int j = 0; j < agents.size(); j++) {
                        s.getData().add(new BarChart.Data<String, Double>(agents.get(j),
                                        miles.get(j)));
                }
                startMonthChart.setLegendVisible(false);
                startMonthChart.getData().add(s);
        }

}
