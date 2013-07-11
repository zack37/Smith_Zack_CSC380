package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;

/**
 * User: Zack Smith
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
            System.out.println("Reader and writer made");

            MathLogic math = new MathLogic();

            String fromClient;
            while ((fromClient = in.readLine()) != null) {
                String[] input = fromClient.split(",");

                ArrayList<Number> parameters = new ArrayList<Number>();

                for (String s : input) {
                    if (s.getClass().equals(Number.class))
                        parameters.add(Double.parseDouble(s));
                }

                System.out.println("Client input not null");


                System.out.println("Performing operation");

                for (Method m : math.getClass().getMethods()) {
                    if (m.getName().equals(input[0]))
                        m.invoke(math, parameters);
                }

            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException ioe) {
            System.out.println("Something went wrong with reading and writing.");
        } catch (InvocationTargetException e) {
            System.out.println("The calling method threw an error");
        } catch (IllegalAccessException e) {
            System.out.println("That particular method can not be accessed");
        }
    }
}
