package frontend;

public class Main {
    public static void main(String[] args) {
        FrontendFacade frontendFacade = new APCFrontend();
        frontendFacade.launchMainWindow("backendIP", 123);
    }
}
