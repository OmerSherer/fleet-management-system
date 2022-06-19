package frontend.View;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;

import frontend.View.Controllers.FleetOverview;
import frontend.View.Controllers.FxmlController;
import frontend.ViewModel.FrontendViewModel;
import frontend.serializable.Controls;
import frontend.serializable.*;

/**
 * JavaFX App
 */
public class APCFrontendView extends Application implements FrontendView {

    private static Scene scene;
    private static FrontendViewModel viewModel;
    private static FxmlController controller;
    public static SimpleObjectProperty<GeneralData> generalData;
    public static SimpleObjectProperty<MonitoringData> monitoringData;
    public static SimpleObjectProperty<PastFlights> pastFlights;
    public static SimpleObjectProperty<PastFlightInfo> pastFlightInfo;
    public static SimpleBooleanProperty isLoading;
    private static int backendPort;
    private static String backendIP;

    public APCFrontendView() {
        APCFrontendView.generalData = new SimpleObjectProperty<>();
        APCFrontendView.monitoringData = new SimpleObjectProperty<>();
        APCFrontendView.pastFlights = new SimpleObjectProperty<>();
        APCFrontendView.pastFlightInfo = new SimpleObjectProperty<>();
        APCFrontendView.isLoading = new SimpleBooleanProperty();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML1("loading"), 640, 480);
        stage.setScene(scene);
        stage.show();
        // new Thread(() -> {
        try {
            connectToBackend();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // }).start();
    }

    private void connectToBackend() throws IOException {
        viewModel.connectToBackend(backendIP, backendPort);
        setRoot("fleetoverview");
    }

    public void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        controller.onLoad();
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(APCFrontendView.class.getResource(fxml + ".fxml"));
        switch (fxml) {
            case "fleetoverview":
                controller = new FleetOverview();
                break;

            default:
                try {
                    throw new Exception("Controller not found");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        // controller = new FleetOverview();
        fxmlLoader.setController(controller);
        // controller = fxmlLoader.getController();
        controller.init(this, generalData, monitoringData, pastFlights, pastFlightInfo, isLoading);
        return fxmlLoader.load();
    }

    private Parent loadFXML1(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(APCFrontendView.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    @Override
    public void update(Observable o, Object arg) {
    }

    @Override
    public void setViewModel(FrontendViewModel frontendViewModel) {
        viewModel = frontendViewModel;
        viewModel.bindProp(generalData, monitoringData, pastFlights, pastFlightInfo, isLoading);
    }

    @Override
    public void getGeneralData() {
        viewModel.getGeneralData();
    }

    @Override
    public void getMonitoringData() {
        viewModel.getMonitoringData();
    }

    @Override
    public void sendCode(String string) {
        viewModel.sendCode(string);
    }

    @Override
    public void controlAgent(Controls controls) {
        viewModel.controlAgent(controls);
    }

    @Override
    public void getPastFlights() {
        viewModel.getPastFlights();
    }

    @Override
    public void getPastFlightInfo(String string) {
        viewModel.getPastFlightInfo(string);
    }

    @Override
    public boolean connectToBackend(String IP, int port) {
        return viewModel.connectToBackend(IP, port);
    }

    @Override
    public void startTheApp(String backendIP, int backendPort) {
        APCFrontendView.backendIP = backendIP;
        APCFrontendView.backendPort = backendPort;
        launch();
    }

}