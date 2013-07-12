package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * User: Zack Smith
 * Date: 7/9/13
 * Time: 12:40 PM
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        System.out.println("Enter in the formula in the format: (operation),#,#,...");
        try {
            kkSocket = new Socket("localhost", 2337);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException uhe) {
            System.err.println("Don't know about host: localhost");
            System.exit(1);
        } catch (IOException ioe) {
            System.err.println("Couldn't get I/O for the connection to: localhost");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String clientInput, fromServer;

        //Client communication is first
        while (!(clientInput = stdIn.readLine()).equals("exit")) {
            out.println(clientInput);
            if (clientInput.equals("Bye."))
                break;

            fromServer = in.readLine();
            if (fromServer != null) {
                System.out.println("Server: " + fromServer);
                out.println(fromServer);
            }
        }

        //Server communication is first
//        while (!(fromServer = in.readLine()).equals(null)) {
//            if (fromServer != null) {
//                System.out.println("Server: " + fromServer);
//            }
//
//            clientInput = stdIn.readLine();
//            if (!clientInput.trim().equals("") || clientInput != null) {
//                out.println(clientInput);
//            }
//        }

        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }
}
