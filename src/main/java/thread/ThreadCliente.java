package thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadCliente extends Thread {

    private Socket cliente;

    public ThreadCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            cliente.setSoTimeout(200);
            BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            PrintWriter out = new PrintWriter ( new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream(), "utf-8")));
            
            
            String inputLine;
            boolean body = false;
            String body_json = "";
            try{
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                    if(inputLine.contains("{")){
                       body = true; 
                    }
                    if(body)
                        body_json = body_json + inputLine;
                        
                }
            }catch (Exception e){
                out.write("HTTP/1.1 200 OK\r\n"
                    + "Content-Type: application/json\r\n"
                    + "\r\n"
                    + "O Json passado foi: " + body_json);
                out.flush();
                out.close();
                in.close();
            }
            
        } catch (Exception e) {
        }finally{
            try {
                cliente.close();
            } catch (IOException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Client disconnected");
    }

    private SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:Ss z");

}
