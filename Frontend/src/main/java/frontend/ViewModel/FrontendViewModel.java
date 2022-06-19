package frontend.ViewModel;

import frontend.Model.FrontendModel;
import frontend.serializable.Controls;
import frontend.serializable.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

public interface FrontendViewModel {
    boolean connectToBackend(String IP, int port);

    void setModel(FrontendModel frontendModel);

    void getGeneralData();

    void setGeneralData();

    void setChosenAgent(String string);

    void getMonitoringData();

    void setMonitoringData();

    void sendCode(String string);

    void controlAgent(Controls controls);

    void getPastFlights();

    void setPastFlights();

    void getPastFlightInfo(String string);

    void setPastFlightInfo();

    void bindProp(SimpleObjectProperty<GeneralData> generalData, SimpleObjectProperty<MonitoringData> monitoringData,
            SimpleObjectProperty<PastFlights> pastFlights, SimpleObjectProperty<PastFlightInfo> pastFlightInfo,
            SimpleBooleanProperty isLoading);
}
