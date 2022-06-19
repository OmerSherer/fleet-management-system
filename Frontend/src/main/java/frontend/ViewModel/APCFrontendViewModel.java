package frontend.ViewModel;

import java.util.Observable;
import java.util.Observer;

import frontend.Model.FrontendModel;
import frontend.serializable.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

public class APCFrontendViewModel extends Observable implements Observer, FrontendViewModel {
    private AgentData chosenPlane;
    public SimpleObjectProperty<GeneralData> generalData;
    public SimpleObjectProperty<MonitoringData> monitoringData;
    public SimpleObjectProperty<PastFlights> pastFlights;
    public SimpleObjectProperty<PastFlightInfo> pastFlightInfo;
    public SimpleBooleanProperty isLoading;
    private FrontendModel frontendModel;

    public APCFrontendViewModel() {
        this.generalData = new SimpleObjectProperty<>();
        this.monitoringData = new SimpleObjectProperty<>();
        this.pastFlights = new SimpleObjectProperty<>();
        this.pastFlightInfo = new SimpleObjectProperty<>();
        this.isLoading = new SimpleBooleanProperty();
    }

    @Override
    public boolean connectToBackend(String IP, int port) {
        return frontendModel.connectToBackend(IP, port);
    }

    @Override
    public void setModel(FrontendModel frontendModel) {
        this.frontendModel = frontendModel;
        frontendModel.addObserverToModel(this);
    }

    @Override
    public void getGeneralData() {
        isLoading.set(true);
        new Thread(() -> frontendModel.acquireGeneralData()).run();
    }

    @Override
    public void setGeneralData() {
        generalData.set(frontendModel.getGeneralData());
    }

    @Override
    public void setChosenAgent(String string) {
        chosenPlane = new AgentData();
        chosenPlane.ID = string;
    }

    @Override
    public void getMonitoringData() {
        isLoading.set(true);
        new Thread(() -> frontendModel.acquireMonitoringData(chosenPlane)).run();
    }

    @Override
    public void setMonitoringData() {
        monitoringData.set(frontendModel.getMonitoringData());
    }

    @Override
    public void sendCode(String string) {
        frontendModel.sendCode(string);
    }

    @Override
    public void controlAgent(Controls controls) {
        frontendModel.controlAgent(controls);
    }

    @Override
    public void getPastFlights() {
        isLoading.set(true);
        new Thread(() -> frontendModel.acquirePastFlights()).run();
    }

    @Override
    public void setPastFlights() {
        pastFlights.set(frontendModel.getPastFlights());
    }

    @Override
    public void getPastFlightInfo(String string) {
        isLoading.set(true);
        new Thread(() -> frontendModel.acquirePastFlightInfo(string)).run();
    }

    @Override
    public void setPastFlightInfo() {
        pastFlightInfo.set(frontendModel.getPastFlightInfo());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == frontendModel) {
            setGeneralData();
            setMonitoringData();
            setPastFlights();
            setPastFlightInfo();
            isLoading.set(false);
        }
    }

    @Override
    public void bindProp(SimpleObjectProperty<GeneralData> generalData,
            SimpleObjectProperty<MonitoringData> monitoringData, SimpleObjectProperty<PastFlights> pastFlights,
            SimpleObjectProperty<PastFlightInfo> pastFlightInfo, SimpleBooleanProperty isLoading) {
        generalData.bind(this.generalData);
        monitoringData.bind(this.monitoringData);
        pastFlights.bind(this.pastFlights);
        pastFlightInfo.bind(this.pastFlightInfo);
        isLoading.bind(this.isLoading);
    }

}
