/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Pattern;
import routes.Router;
import routes.MedicoRouter;
import routes.PacienteRouter;

/**
 *
 * @author matheusnascimento
 */
public class RouterController {

    private Router route;

    public Object[] router(String url, String method, String body, HashMap data_base) {
        String[] urlSplit = url.split("\\?");
        String path = urlSplit[0];

        HashMap<String, String> params = new HashMap();
        if (urlSplit.length == 2) {
            urlSplit = urlSplit[1].split("\\&");

            for (int i = 0; i < urlSplit.length; i++) {
                String[] entry = urlSplit[i].split("=");
                params.put(entry[0], entry[1]);
            }
        }

        Gson gson = new Gson();
        String json = gson.toJson(params);
        if (path.equals("/paciente")) {
            route = new PacienteRouter();
            if (method.equals("POST")) {
                return route.POST(body, data_base);
            }

            if (method.equals("PUT")) {
                return route.PUT(body, data_base);
            }

            if (method.equals("GET")) {
                return route.GET(json, data_base);
            }

            if (method.equals("DELETE")) {
                return route.DELETE(json, data_base);
            }

        }
        if (path.equals("/medico/pacientes") && method.equals("GET")) {
            route = new MedicoRouter();
            if (method.equals("GET")) {
                return route.GET(body, data_base);
            }

        }
        return null;
    }
}
