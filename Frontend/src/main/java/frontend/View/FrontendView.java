package frontend.View;

import java.util.Observer;

import frontend.ViewModel.FrontendViewModel;
import frontend.serializable.Controls;

public interface FrontendView extends Observer {
    void run();

    void setViewModel(FrontendViewModel frontendViewModel);

    void getGeneralData();

    void getMonitoringData();

    void sendCode(String string);

    void controlAgent(Controls controls);

    void getPastFlights();

    void getPastFlightInfo(String string);

    boolean connectToBackend(String IP, int port);

}
