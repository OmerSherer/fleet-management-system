package frontend.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;

import frontend.serializable.*;

public class APCFrontendModel extends Observable implements FrontendModel {
    private Socket backend;
    private GeneralData generalData;
    private MonitoringData monitoringData;
    private PastFlights pastFlights;
    private PastFlightInfo pastFlightInfo;
    private ObjectInputStream serverInput;
    private ObjectOutputStream serverOutput;

    @Override
    public boolean connectToBackend(String IP, int port) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
        // try {
        // backend = new Socket(IP, port);
        // System.out.println("connected to server");
        // serverInput = new ObjectInputStream(backend.getInputStream());
        // serverOutput = new ObjectOutputStream(backend.getOutputStream());
        // return true;
        // } catch (UnknownHostException e) {
        // return false;
        // } catch (IOException e) {
        // return false;
        // }
    }

    @Override
    public GeneralData getGeneralData() {
        return generalData;
    }

    @Override
    public MonitoringData getMonitoringData() {
        return monitoringData;
    }

    @Override
    public PastFlights getPastFlights() {
        return pastFlights;
    }

    @Override
    public PastFlightInfo getPastFlightInfo() {
        return pastFlightInfo;
    }

    @Override
    public void acquireGeneralData() {
        try {
            serverOutput.writeObject(FrontendMessage.getGeneralData);
            generalData = (GeneralData) serverInput.readObject();
            setChanged();
            ;
            notifyObservers();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void acquireMonitoringData(AgentData agentData) {
        try {
            serverOutput.writeObject(FrontendMessage.getMonitoringData);
            monitoringData = (MonitoringData) serverInput.readObject();
            setChanged();
            ;
            notifyObservers();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendCode(String s) {
        try {
            serverOutput.writeObject(FrontendMessage.sendCode);
            serverOutput.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void controlAgent(Controls controls) {
        try {
            serverOutput.writeObject(FrontendMessage.controlAgent);
            serverOutput.writeObject(controls);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void acquirePastFlights() {
        try {
            serverOutput.writeObject(FrontendMessage.getPastFlights);
            pastFlights = (PastFlights) serverInput.readObject();
            setChanged();
            notifyObservers();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void acquirePastFlightInfo(String flightCode) {
        try {
            serverOutput.writeObject(FrontendMessage.getPastFlightInfo);
            serverOutput.writeObject(flightCode);
            pastFlightInfo = (PastFlightInfo) serverInput.readObject();
            setChanged();
            notifyObservers();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            serverInput.close();
            serverOutput.close();
            backend.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addObserverToModel(Observer o) {
        addObserver(o);
    }

}
