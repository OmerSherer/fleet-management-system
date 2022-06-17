package frontend.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;

import frontend.ViewModel.FrontendViewModel;
import frontend.serializable.Controls;

/**
 * JavaFX App
 */
public class APCFrontendView extends Application implements FrontendView {

    private static Scene scene;
    private FrontendViewModel viewModel;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("loading"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(APCFrontendView.class.getResource(fxml + ".fxml"));
        fxmlLoader.getController();
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setViewModel(FrontendViewModel frontendViewModel) {
        viewModel = frontendViewModel;
    }

    @Override
    public void getGeneralData() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getMonitoringData() {
        // TODO Auto-generated method stub

    }

    @Override
    public void sendCode(String string) {
        // TODO Auto-generated method stub

    }

    @Override
    public void controlAgent(Controls controls) {
        // TODO Auto-generated method stub

    }

    @Override
    public void getPastFlights() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getPastFlightInfo(String string) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean connectToBackend(String IP, int port) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void run() {
        new Thread(() -> launch()).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            APCFrontendView.setRoot("primary");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}