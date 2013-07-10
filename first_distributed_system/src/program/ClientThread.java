package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * User: Berwyn Codeweaver
 * Date: 7/9/13
 * Time: 8:02 PM
 */
public class ClientThread extends Thread {

    private Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            MathLogic math = new MathLogic();

            String fromClient;
            while ((fromClient = in.readLine()) != null) {
                String[] input = fromClient.split(",");


                if (input.length == 3) {
                    if (input[0].equals("a")) {
                        out.println(math.add(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                    } else if (input[0].equals("s")) {
                        out.println(math.subtract(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                    } else {
                        out.println("Sorry. Something went wrong. Please try again");
                    }
                }
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException ioe) {
            System.out.println("Something went wrong with reading and writing.");
        }
    }
}
