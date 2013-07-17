package program;

import java.io.*;
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
        ObjectOutputStream oos = null;
        try {
            kkSocket = new Socket("localhost", 2337);
            //out = new PrintWriter(kkSocket.getOutputStream(), true);
            oos = new ObjectOutputStream(kkSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException uhe) {
            System.err.println("Don't know about host: localhost");
            System.exit(1);
        } catch (IOException ioe) {
            System.err.println("Couldn't get I/O for the connection to: localhost");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;

        //Client communication is first
        while (true) {

            System.out.print("Class Path (Fully qualified): ");
            String classPath = stdIn.readLine();

            System.out.print("Method Name: ");
            String methodName = stdIn.readLine();

            System.out.print("Parameters in comma separated list: ");
            Object[] parameters = stdIn.readLine().split(",");

            if (classPath.equals("exit") || methodName.equals("exit")) break;

            Contract contract = new Contract(classPath, methodName, parameters);

            oos.writeObject(contract);
            oos.flush();

            //out.println(clientInput);
//            if (clientInput.equals("Bye."))
//                break;

            fromServer = in.readLine();
            if (fromServer != null) {
                System.out.println("Server: " + fromServer);
                //out.println(fromServer);
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

        oos.close();
        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }
}
