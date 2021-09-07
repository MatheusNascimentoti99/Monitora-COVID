/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

import java.util.HashMap;
import com.google.gson.Gson;
import java.util.EmptyStackException;
import java.util.Iterator;
import model.Paciente;

/**
 *
 * @author matheusnascimento
 */
public class RouterListUsers implements Router{

    public Object[] response(Object body, HashMap data_base) {
        Object [] res = new Object[3]; //Response
        try{
            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            Iterator i = data_base.values().iterator();
            Paciente paciente;
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append('[');
            while(i.hasNext()){
                paciente = (Paciente)i.next();
                jsonBuilder.append(paciente.toString());
                if(i.hasNext())
                    jsonBuilder.append(',');
            }
            jsonBuilder.append(']');
            System.out.println(data_base.size());
            res[0] = "200";
            res[1] = "OK";
            res[2] = jsonBuilder.toString();
        }catch(Exception e){
            System.out.println("Error: " + e);
            res[0] = "500";
            res[1] = "Erro";
            res[2] = "Erro ao buscar dados";
        }
        return res;
    }
     
}
