package model;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
        }catch(Exception e)
        {
            System.out.println("Client disconnected");
        }
  }
}