package thread;


import java.io.BufferedWriter;
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
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            Object o;
            o = ois.readObject();
            System.out.println((String)o);
            out.close();
            ois.close();
            cliente.close();
        } catch (Exception e) {
        }

        System.out.println("Client disconnected");
    }

    private SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:Ss z");

}
