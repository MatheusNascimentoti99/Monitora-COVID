/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import routes.Router;
import routes.RouterListUsers;
import routes.RouterSendForm;

/**
 *
 * @author matheusnascimento
 */
public class RouterController {
    private Router route;
    
    public Object[] router(String path, String method, String body, HashMap data_base){
        if(path.equals("/paciente/reportClinical") && method.equals("POST")){
            route = new RouterSendForm();
            return route.response(body, data_base);
        }
        if(path.equals("/medico/pacientes") && method.equals("GET")){
            route = new RouterListUsers();
            System.out.println("Listagem");
            return route.response(body, data_base);
        }
        return null;
    }
}
