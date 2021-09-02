package thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadCliente extends Thread {

    private Socket cliente;

    public ThreadCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            PrintWriter saida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())));
            BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println("After");
            String res = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: application/json\r\n"
                    + "\r\n"
                    + "hello world";
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Message from client: " + message);
            }
            System.out.println("end");
            saida.println(res);
            saida.close();
            reader.close();
            cliente.close();
        } catch (Exception e) {
        }

        System.out.println("Client disconnected");
    }

    private SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:Ss z");

}
