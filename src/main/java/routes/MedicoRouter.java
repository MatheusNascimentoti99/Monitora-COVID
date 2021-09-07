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
public class MedicoRouter implements Router{

    public Object[] GET(Object body, HashMap data_base) {
        Object [] res = new Object[3]; //Response
        try{
            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            Iterator i = data_base.values().iterator();
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append('[');

            Object row;
            while(i.hasNext()){
                row = i.next();
                jsonBuilder.append(row.toString());
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

    public Object[] POST(Object o, HashMap hm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[] PUT(Object o, HashMap hm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[] DELETE(Object o, HashMap hm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}