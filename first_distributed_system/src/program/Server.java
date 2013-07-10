package program;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: Berwyn Codeweaver
 * Date: 7/9/13
 * Time: 5:33 PM
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException ioe) {
            System.out.println("Server can not listen on port 4444");
            System.exit(-1);
        }

        Socket clientSocket = null;

        try {
            clientSocket = serverSocket.accept();
        } catch (IOException ioe) {
            System.out.println("Accept failed: 4444");
            System.exit(-1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        MathLogic math = new MathLogic();

        String[] input = in.readLine().split(",");

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

}
