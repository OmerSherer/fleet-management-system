package frontend.Model;

import java.util.Observer;

import frontend.serializable.AgentData;
import frontend.serializable.Controls;
import frontend.serializable.FlightCode;
import frontend.serializable.GeneralData;
import frontend.serializable.MonitoringData;
import frontend.serializable.PastFlightInfo;
import frontend.serializable.PastFlights;

public interface FrontendModel {
    boolean connectToBackend(String IP, int port);

    GeneralData getGeneralData();

    MonitoringData getMonitoringData();

    PastFlights getPastFlights();

    PastFlightInfo getPastFlightInfo();

    void acquireGeneralData();

    void acquireMonitoringData(AgentData agentData);

    void sendCode(String s);

    void controlAgent(Controls controls);

    void acquirePastFlights();

    void acquirePastFlightInfo(String id);

    void close();

    void addObserverToModel(Observer o);

}
