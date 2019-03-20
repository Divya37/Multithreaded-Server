package server;

import server.handler.MultiThreadedServer;

public class ServerMain {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        MultiThreadedServer server = new MultiThreadedServer(9000);
        new Thread(server).start();

        try {
            Thread.sleep(100 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }
}
