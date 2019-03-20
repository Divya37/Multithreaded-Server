package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;


public class WorkerRunnable implements Runnable{

    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            String outputMessage = "HTTP/1.1 200 OK\n\nWorkerRunnable: "
                                    + this.serverText
                                    + " - "
                                    + time
                                    + "";
            output.write((outputMessage).getBytes());
            log.info(outputMessage);
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}