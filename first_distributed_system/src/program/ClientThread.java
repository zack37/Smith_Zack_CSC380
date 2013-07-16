package program;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

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
            ObjectInputStream oIn = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            //BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Reader and writer made");

            Contract fromClient;
            while ((fromClient = (Contract) oIn.readObject()) != null) {

                System.out.println("Client input not null");

                System.out.println("Performing operation");

                try {
                    Object calling;
                    Class loadedObject = Class.forName(fromClient.getClassPath());
                    calling = loadedObject.newInstance();

                    Method m = loadedObject.getMethod(fromClient.getMethodName(), Number[].class);
                    out.println(m.invoke(calling, new Object[]{fromClient.getParameters()}));
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
            oIn.close();
            //in.close();
            clientSocket.close();
        } catch (IOException ioe) {
            System.err.println("Something went wrong with reading and writing.");
            ioe.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("That particular method can not be accessed");
        } catch (ClassNotFoundException e) {
            System.err.println("Pulling the contract class failed");
        }
    }
}
