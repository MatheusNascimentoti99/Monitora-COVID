package model;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
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
            while((message=reader.readLine())!=null)
            {
                System.out.println("Message from client: "+message);
                System.out.println("IP client: "+cliente.getInetAddress());
            }
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            saida.println("Response from Serve. Date:" + new Date().toString());
            saida.close();
            cliente.close();
        }catch(Exception e)
        {
        try {
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        }finally{
            System.out.println("Client disconnected");
        }
  }
}