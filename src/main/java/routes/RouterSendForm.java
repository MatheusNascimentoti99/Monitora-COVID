/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

import java.util.HashMap;
import com.google.gson.Gson;
import model.Paciente;

/**
 *
 * @author matheusnascimento
 */
public class RouterSendForm implements Router{

    public Object[] response(Object body, HashMap data_base) {
        Object [] res = new Object[3]; 
        try{
            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            Paciente paciente = gson.fromJson((String)body, Paciente.class);
            System.out.println(data_base.size());
            Object objRes = data_base.put(paciente.getCpf(), paciente);
            if(objRes == null){
                res[0] = "201";
                res[1] = "OK";
            }else{
                res[0] = "200";
                res[1] = "OK";
            }
            res[2] = paciente.toString();
        }catch(Exception e){
            System.out.println("Error: " + e);
            res[0] = "500";
            res[1] = "Erro";
            res[2] = "Erro ao atualizar dados";
        }
        return res;
    }
     
}
