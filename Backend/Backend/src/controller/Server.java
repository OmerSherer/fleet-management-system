package controller;


import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public abstract class Server {
    int PORT;
    boolean stop = false;



    PrintStream out = System.out;
    public void start(){
       stop = false;
       new Thread(this::startServer).start();
    }

    public void stop(){
        stop = true;
    }

    public Server(int PORT) {
        this.PORT = PORT;
    }

    protected abstract void startServer();
}
