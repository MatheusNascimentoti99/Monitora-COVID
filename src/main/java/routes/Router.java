/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

import java.util.HashMap;

/**
 *
 * @author matheusnascimento
 */
public interface Router {
    
    public Object[] response(Object body, HashMap data_base);
    
}
