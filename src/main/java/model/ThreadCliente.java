package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadCliente extends Thread {

  private Socket cliente;

  public ThreadCliente(Socket cliente) {
    this.cliente = cliente;
  }

  public void run() {
    try {
        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        saida.flush();
        saida.writeObject("Servidor atendeu");
        saida.close();
        cliente.close();
    }

    catch(Exception e) {
       System.out.println("Excecao ocorrida na thread: " + e.getMessage());
       try {
         cliente.close();
       }

       catch(Exception ec) {}
    }
  }
}