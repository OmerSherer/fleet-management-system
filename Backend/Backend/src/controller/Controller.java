package controller;

public class Controller {
    Server server = new AgentsServer(1000);

    public Server getServer() {
        return server;
    }
}
