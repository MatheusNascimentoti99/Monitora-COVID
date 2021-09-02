package thread;

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
            System.out.println("Before");
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            System.out.println("After");
            String res = "HTTP/1.1 200 OK\\r\\n";
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