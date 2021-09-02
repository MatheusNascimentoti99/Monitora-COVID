/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import thread.ThreadCliente;
/**
 *
 * @author matheusnascimento
 */
public class main {
    public static void main(String[] args) {
      try {
        //Converte o parametro recebido para int (número da porta)
        System.out.println("Incializando o servidor...");
        //Iniciliza o servidor
        ServerSocket serv = new ServerSocket(Integer.valueOf(System.getenv("PORT")));
        System.out.println("Servidor iniciado, ouvindo a porta " + serv.getLocalPort());
        System.out.println("Host: " + serv.toString());
        //Aguarda conexões
        
        while(true) {
             Socket clie = serv.accept();
             System.out.println(clie.getInetAddress().getHostAddress());
             //Inicia thread do cliente
             new ThreadCliente(clie).start();
        }
     }
    catch(Exception e) {}
  }
}
