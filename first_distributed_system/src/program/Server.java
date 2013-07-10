package program;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: Zack Smith
 * Date: 7/9/13
 * Time: 5:33 PM
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(2337);
        } catch (IOException ioe) {
            System.err.println("Server can not listen on port 4444");
            System.exit(-1);
        }

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                ClientThread thread = new ClientThread(clientSocket);
                System.out.println("New client thread made");
                thread.start();
            } catch (IOException ioe) {
                System.err.println("Accept failed: 4444");
                System.exit(-1);
            }
        }
    }

}
