package model;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    try
        {
            String message;
            BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println("IP client: "+cliente.getInetAddress());
            while((message=reader.readLine())!=null)
            {
                System.out.println("Message from client: "+message);
            }
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            cliente.getOutputStream();
             String res = "HTTP/1.0 200 OK\n"+ "Server: HTTP server/0.1\n" 
                     + "Date: "+format.format(new java.util.Date())+"\n" 
              + "Content-type: application/json; charset=UTF-8\n"
                    + "Content-Length: 38\n\n"
                    + "{\"teste\": 0}";
            saida.write(res.getBytes());
            saida.flush();
            reader.close();
            saida.close();
        }catch(Exception e)
        {
        try {
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Client disconnected");
        }
  }
  
  private SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:Ss z");

}