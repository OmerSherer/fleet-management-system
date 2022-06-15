package frontend.ViewModel;

import java.util.Observable;
import java.util.Observer;

import frontend.Model.FrontendModel;
import frontend.serializable.AgentData;
import frontend.serializable.Controls;
import frontend.serializable.*;
import javafx.beans.property.SimpleObjectProperty;

public class APCFrontendViewModel extends Observable implements Observer, FrontendViewModel {
    private AgentData chosenPlane;
    public SimpleObjectProperty<GeneralData> generalData;
    public SimpleObjectProperty<MonitoringData> monitoringData;
    public SimpleObjectProperty<PastFlights> pastFlights;
    public SimpleObjectProperty<PastFlightInfo> pastFlightInfo;
    private FrontendModel frontendModel;

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
        new Thread(() -> frontendModel.acquirePastFlights()).run();
    }

    @Override
    public void setPastFlights() {
        pastFlights.set(frontendModel.getPastFlights());
    }

    @Override
    public void getPastFlightInfo(String string) {
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
        }
    }

}
