/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller;

import com.mynharcorp.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author harold
 */


@Named
@ViewScoped
public class PlantillaController implements Serializable{
    
    public void verificarSesion(){
        try{
            
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario obj = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            
            if(obj == null){
                context.getExternalContext().redirect("./../permisos.xhtml");
                
            }
            
        }catch(IOException e){
            e.getStackTrace();
        }
    }
    
}
