package thread;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
            PrintWriter saida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())));
            System.out.println("After");
            String res = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: application/json\r\n"
                    + "\r\n"
                    + "hello world";
            String result;
            StringBuilder sb = new StringBuilder();
            for (int ch; (ch = cliente.getInputStream().read()) != -1; ) {
                sb.append((char) ch);
            }

            System.out.println(sb.toString());
            System.out.println("end");
            saida.println(res);
            saida.close();
            cliente.close();
        } catch (Exception e) {
        }

        System.out.println("Client disconnected");
    }

    private SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:Ss z");

}
