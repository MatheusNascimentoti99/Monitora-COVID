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
import model.ThreadCliente;
/**
 *
 * @author matheusnascimento
 */
public class main {
    public static void main(String[] args) {
      try {
        //Converte o parametro recebido para int (número da porta)
        System.out.println("Incializando o servidor...");
        int port = 8082;
        //Iniciliza o servidor
        ServerSocket serv = new ServerSocket(port);
        System.out.println("Servidor iniciado, ouvindo a porta " + serv.getLocalPort());
        System.out.println("Host: " + serv.getLocalSocketAddress());
        //Aguarda conexões
        while(true) {
             Socket clie = serv.accept();
             //Inicia thread do cliente
             new ThreadCliente(clie).start();
        }
     }
    catch(Exception e) {}
  }
}
