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

            String fromClient;
            while ((fromClient = in.readLine()) != null) {
                String[] input = fromClient.split(",");

                System.out.println("Client input not null");

                ArrayList<Number> parameters = new ArrayList<Number>();

                for (String s : input) {
                    try {
                        double temp = Double.valueOf(s);
                        parameters.add(temp);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Could not parse data. Moving on...");
                    }
                }

                System.out.println("Performing operation");

                try {
                    MathLogic math;
                    Class<MathLogic> loadedMath = (Class<MathLogic>) Class.forName("program.MathLogic");
                    math = loadedMath.newInstance();
                    Number[] darnYouJava = new Number[parameters.size()];
                    for (int i = 0; i < darnYouJava.length; i++)
                        darnYouJava[i] = parameters.get(i);

                    Method m = loadedMath.getMethod(input[0], Number[].class);
                    out.println(m.invoke(math, new Object[]{darnYouJava}));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }


            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException ioe) {
            System.out.println("Something went wrong with reading and writing.");
        } catch (IllegalAccessException e) {
            System.out.println("That particular method can not be accessed");
        }
    }
}
