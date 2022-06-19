package frontend.View.Controllers;

import frontend.View.FrontendView;
import frontend.serializable.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class FxmlController {
    public SimpleObjectProperty<GeneralData> generalData;
    public SimpleObjectProperty<MonitoringData> monitoringData;
    public SimpleObjectProperty<PastFlights> pastFlights;
    public SimpleObjectProperty<PastFlightInfo> pastFlightInfo;
    public SimpleBooleanProperty isLoading;
    public FrontendView frontendView;

    public FxmlController() {
        this.generalData = new SimpleObjectProperty<>();
        this.monitoringData = new SimpleObjectProperty<>();
        this.pastFlights = new SimpleObjectProperty<>();
        this.pastFlightInfo = new SimpleObjectProperty<>();
        this.isLoading = new SimpleBooleanProperty();
    }

    public void init(FrontendView frontendView, SimpleObjectProperty<GeneralData> generalData,
            SimpleObjectProperty<MonitoringData> monitoringData, SimpleObjectProperty<PastFlights> pastFlights,
            SimpleObjectProperty<PastFlightInfo> pastFlightInfo, SimpleBooleanProperty isLoading) {
        this.generalData.bind(generalData);
        this.monitoringData.bind(monitoringData);
        this.pastFlights.bind(pastFlights);
        this.pastFlightInfo.bind(pastFlightInfo);
        this.isLoading.bind(isLoading);
        this.frontendView = frontendView;
        this.generalData.addListener((arg0) -> {
            onGeneralDataChange();
        });
        this.monitoringData.addListener((arg0) -> {
            onMonitoringDataChange();
        });
        this.pastFlights.addListener((arg0) -> {
            onPastFlightsChange();
        });
        this.pastFlightInfo.addListener((arg0) -> {
            onPastFlightInfoChange();
        });
        this.isLoading.addListener((arg0) -> {
            onIsLoadingChange();
        });
    }

    protected void onGeneralDataChange() {
    }

    protected void onMonitoringDataChange() {
    }

    protected void onPastFlightsChange() {
    }

    protected void onPastFlightInfoChange() {
    }

    protected void onIsLoadingChange() {
    }

}
