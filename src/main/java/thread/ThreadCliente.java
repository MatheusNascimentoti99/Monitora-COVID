package thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

public class ThreadCliente extends Thread {

    private Socket cliente;

    public ThreadCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {

            Writer out = new OutputStreamWriter(cliente.getOutputStream(), "utf-8");
            out.write("HTTP/1.1 200 OK\r\n"
                    + "Content-Type: application/json\r\n"
                    + "\r\n"
                    + "hello world");
            out.flush();
            BufferedReader ois = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String inputLine;
            while ((inputLine = ois.readLine()) != null) {
                System.out.println(inputLine);
            }
            ois.close();
            out.close();
            cliente.close();
        } catch (Exception e) {
        }

        System.out.println("Client disconnected");
    }

    private SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:Ss z");

}
