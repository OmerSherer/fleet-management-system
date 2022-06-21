package controller;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class AgentsServer extends Server {

    HashMap<Integer, Socket> clients = new HashMap<>();
    int nextClient = 0;

    public AgentsServer(int port) {
        super(port);
    }

    @Override
    protected void startServer() {
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            serverSocket.setSoTimeout(1000);
            while(!stop){
                try{
                    Socket client = serverSocket.accept();
                    clients.put(nextClient, client);
                    nextClient++;
                } catch (Exception e){
                    out.println("Timeout");
                }
            }
        } catch (Exception e){
            out.println("Error");
        }
    }


}
